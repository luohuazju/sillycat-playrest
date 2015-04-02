package models;

import org.flywaydb.core.Flyway;
import play.db.DB;

/**
 * Created by carl on 4/1/15.
 */
public class BaseDAO {

    private static Flyway initFlyway(){
        Flyway flyway = new Flyway();
        flyway.setDataSource(DB.getDataSource());
        return flyway;
    }

    public static void create(){
        Flyway flyway = initFlyway();
        flyway.migrate();
    }

    public static void clean(){
        Flyway flyway = initFlyway();
        flyway.clean();
    }

}
