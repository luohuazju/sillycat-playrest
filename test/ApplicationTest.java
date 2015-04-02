import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.routes;
import models.TaskDAO;
import org.junit.*;

import play.libs.Json;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @BeforeClass
    public static void before() {
        running(fakeApplication(), () -> {
            TaskDAO.create();
        });
    }

    @AfterClass
    public static void after(){
        running(fakeApplication(), () -> {
            TaskDAO.clean();
        });
    }

    @Test
    public void dummy() {
        int a = 1 + 1;
        Assert.assertEquals(2, a);
    }

    @Test
    public void list() {
        running(fakeApplication(), () -> {
            Result result = controllers.TaskApplication.items();
            assertThat(status(result)).isEqualTo(OK);
            assertThat(Json.parse(contentAsString(result)).size() > 0).isTrue();
        });
    }

}
