package facade.travel;

import com.google.gson.Gson;
import com.project.DAO.sql.RestaurantDAO;
import com.project.POJO.Restaurant;
import com.project.POJO.result.SaleResult;
import com.project.util.constant.Define;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by VietAnh on 11/17/2016.
 */
public class TravelFace {
    /**
     * Find restaurant Travel
     * @param limit
     * @param offset
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/tat-ca")
    public String getEntertainment(@QueryParam("limit") int limit,
                                   @QueryParam("offset") int offset){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByType(Define.RESTAURANT_TYPE_TRAVEL);

        SaleResult saleResult = new SaleResult(restaurants);

        stopWatch.stop();
        restaurantDAO.close();
        return gson.toJson(saleResult);
    }
}
