package models;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.flywaydb.core.Flyway;
import play.db.DB;

import java.sql.SQLException;
import java.util.List;
import play.db.DB;
import javax.sql.DataSource;

/**
 * Created by carl on 3/16/15.
 */
public class TaskDAO extends BaseDAO{

    public static List<Task> list(){
        String sql = "select * from task";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        List<Task> items = null;
        try{
            items = runner.query(sql, new BeanListHandler<Task>(Task.class,new TaskRowProcessor()));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public static Task get(Long id){
        String sql = "select * from task where id = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task item = null;
        try{
            item = runner.query(sql,new BeanHandler<Task>(Task.class, new TaskRowProcessor()),id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    public static Task findByName(String name){
        String sql = "select * from task where name = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task item = null;
        try {
            return runner.query(sql, new BeanHandler<Task>(Task.class, new TaskRowProcessor()),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static Task insert(Task item){
        String sql = "insert into task(name, desn, start_date, end_date) values (?, ?, ?, ?)";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        try{
            Long id = runner.insert(sql, new ScalarHandler<Long>(),item.name, item.desn, item.startDate, item.endDate);
            item = get(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    public static Task update(Task item){
        String sql = "update task set name = ?, desn = ?, start_date = ?, end_date = ? where id = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task returnItem = null;
        try{
            runner.update(sql,item.name,item.desn,item.startDate,item.endDate,item.id);
            returnItem = get(item.id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnItem;
    }

    public static void delete(Long id){
        String sql = "delete from task where id = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        try{
            runner.update(sql, id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
