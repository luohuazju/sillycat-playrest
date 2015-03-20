package controllers;

import models.Task;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

/**
 * Created by carl on 3/16/15.
 */
public class TaskApplication extends Controller {

    public static Result items() {
        List<Task> items = null;
        return ok(Json.toJson(items));
    }

    public static Result item(Long id) {
        Task item = null;
        return item == null ? notFound() : ok(Json.toJson(item));
    }

    public static Result save(){
        Task item = Json.fromJson(request().body().asJson(), Task.class);
        Task insertedItem = null;
        return created(Json.toJson(insertedItem));
    }

    public static Result update(Long id){
        Task item = Json.fromJson(request().body().asJson(),Task.class);
        Task updatedItem = null;
        return ok(Json.toJson(updatedItem));
    }

    public static Result delete(Long id){
        return noContent();
    }
}
