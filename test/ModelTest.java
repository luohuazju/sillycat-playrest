import models.TaskDAO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import static play.test.Helpers.*;


/**
 * Created by carl on 4/1/15.
 */
public class ModelTest {

    @BeforeClass
    public static void before() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                TaskDAO.create();
            }
        });
    }

    @AfterClass
    public static void after(){
        running(fakeApplication(), new Runnable() {
            public void run() {
                TaskDAO.clean();
            }
        });
    }

    @Test
    public void dummy() {
        int a = 1 + 1;
        Assert.assertEquals(2, a);
    }

    @Test
    public void list(){
        running(fakeApplication(), new Runnable() {
            public void run() {
                List list = TaskDAO.list();
                Assert.assertNotNull(list);
            }
        });
    }
}
