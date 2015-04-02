package controllers;

import models.Task;
import models.TaskDAO;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by carl on 3/16/15.
 */
public class TaskApplication extends Controller {

    public static Result items() {
        List<Task> items = TaskDAO.list();
        return ok(Json.toJson(items));
    }

    public static Result item(Long id) {
        Task item = TaskDAO.get(id);
        return item == null ? notFound() : ok(Json.toJson(item));
    }

    public static Result save(){
        Task item = Json.fromJson(request().body().asJson(), Task.class);
        item = TaskDAO.insert(item);
        return ok(Json.toJson(item));
    }

    public static Result update(Long id){
        Task item = Json.fromJson(request().body().asJson(),Task.class);
        Task updatedItem = TaskDAO.update(item);
        return ok(Json.toJson(updatedItem));
    }

    public static Result delete(Long id){
        TaskDAO.delete(id);
        return noContent();
    }
}
