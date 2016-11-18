package facade.drink;

import com.google.gson.Gson;
import com.project.DAO.sql.RestaurantDAO;
import com.project.POJO.Restaurant;
import com.project.POJO.result.Drink;
import com.project.POJO.result.ResultAPI;
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
 * Face đồ uống
 * Created by VietAnh on 11/14/2016.
 */
@Path("/do-uong")
public class DrinkFace {
    static final int LIMIT = 8;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/tat-ca")
    public String getEntertainment(@QueryParam("limit") int limit,
                                   @QueryParam("offset") int offset){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByType(Define.RESTAURANT_TYPE_DRINK);

        SaleResult saleResult = new SaleResult(restaurants);

        stopWatch.stop();
        restaurantDAO.close();
        return gson.toJson(saleResult);
    }

    /**
     * Tra la danh sach nha hang do uong
     * the loai theo define: 8 nha hang
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getDrink(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        Drink drink = new Drink(
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_CAFEENENT, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_GIAIKHAT, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_MOC, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_BONGDA, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_SACH, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_THUCUNG, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_PHIM, LIMIT)));

        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(drink);
    }

    /**
     * Tìm kiếm các nhà hàng cafe sự kiện
     * RESTAURANT_TYPE_DRINK: 2
     * TAG_DRINK_CAFEENENT
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/cafe-su-kien")
    public String getCafeEvent(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_CAFEENENT);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/giai-khat")
    public String getCafeGiaiKhat(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_GIAIKHAT);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/moc")
    public String getCafeMoc(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_MOC);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/bong-da")
    public String getCafeBongDa(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_BONGDA);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/sach")
    public String getCafeSach(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_SACH);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/thu-cung")
    public String getCafeThuCung(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_THUCUNG);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/phim")
    public String getCafePhim(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_DRINK, Define.TAG_DRINK_PHIM);
        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }
}
