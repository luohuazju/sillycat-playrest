import models.TaskDAO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;


/**
 * Created by carl on 4/1/15.
 */
public class ModelTest {

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
    public void list(){
        running(fakeApplication(), () -> {
            List list = TaskDAO.list();
            Assert.assertNotNull(list);
        });
    }
}
