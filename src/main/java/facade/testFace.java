package facade;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.lang.time.StopWatch;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by VietAnh on 9/30/2016.
 */
@Path("/json")
public class testFace {
    @GET
    @Produces({"application/x-javascript"})
    @JSONP(queryParam = "callback")
    public String gettestFace() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("1", "values 1");
        jsonObject.addProperty("2", "values 1");
        jsonObject.addProperty("3", "values 1");
        jsonObject.addProperty("14", "values 1");

        return gson.toJson(jsonObject);

    }
}
