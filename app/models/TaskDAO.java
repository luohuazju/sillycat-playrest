package models;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import play.db.DB;

import java.sql.SQLException;
import java.util.List;
import play.db.DB;
import javax.sql.DataSource;

/**
 * Created by carl on 3/16/15.
 */
public class TaskDAO{

    public List<Task> list(){
        String sql = "select * from task";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        List<Task> items = null;
        try{
            items = runner.query(sql, new BeanListHandler<Task>(Task.class));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public Task findByName(String name){
        String sql = "select * from task where name = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task item = null;
        try {
            return runner.query(sql, new BeanHandler<Task>(Task.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public Task insert(Task item){
        String sql = "insert into task(name, desn, startDate, endDate) values (?, ?, ?, ?)";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task returnItem = null;
        try{
            returnItem = runner.insert(sql, new BeanHandler<Task>(Task.class),item.name, item.desn, item.startDate, item.endDate);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnItem;
    }

    public Task update(Task item){
        String sql = "update task set name = ?, desn = ?, startDate = ?, endDate = ? where id = ?";
        QueryRunner runner = new QueryRunner(DB.getDataSource());
        Task returnItem = null;
        return null;
    }

}
