import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import play.GlobalSettings;
import play.Logger;
import play.api.Application;
import play.api.mvc.Action;
import play.api.mvc.RequestHeader;
import play.libs.F;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.SimpleResult;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by carl on 4/1/15.
 */
public class Global extends GlobalSettings{

    public void onStart(Application app) {
        Logger.info("Application has started");
        ObjectMapper mapper = new ObjectMapper()
                .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Json.setObjectMapper(mapper);
    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

    public play.mvc.Action onRequest(Http.Request request, Method actionMethod) {
        Logger.debug("method=" + request.method() + " uri=" + request.uri() + " remote-address=" + request.remoteAddress());
        return super.onRequest(request, actionMethod);
    }

}
