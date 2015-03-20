package models;

import play.db.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by carl on 3/16/15.
 */
public class TaskDAO{

    public List<Task> list(){
        String sql = "";
        List<Task> items = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = DB.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }

}
