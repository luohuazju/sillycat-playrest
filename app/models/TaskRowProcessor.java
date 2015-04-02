package models;

import org.apache.commons.dbutils.BasicRowProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carl on 4/1/15.
 */
public class TaskRowProcessor extends BasicRowProcessor {

    @Override
    public Object toBean(ResultSet rs, Class type) throws SQLException {
        Task item = new Task();
        item.id = rs.getLong("ID");
        item.name = rs.getString("NAME");
        item.desn = rs.getString("DESN");
        item.startDate = rs.getTimestamp("START_DATE");
        item.endDate = rs.getTimestamp("END_DATE");
        return item;
    }

    @Override
    public <T> List<T> toBeanList(ResultSet rs, Class<T> type) throws SQLException {
        List newlist = new ArrayList();
        try {
            while (rs.next()) {
                newlist.add(toBean(rs, type));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return newlist;
    }


}
