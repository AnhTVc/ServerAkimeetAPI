package facade.entertainment;

import com.google.gson.Gson;
import com.project.DAO.sql.RestaurantDAO;
import com.project.POJO.Restaurant;
import com.project.POJO.result.Entertainment;
import com.project.POJO.result.ResultAPI;
import com.project.util.constant.Define;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by VietAnh on 11/13/2016.
 */
@Path("/giai-tri")
public class EntertainmentFace {
    static final int LIMIT = 8;
    /**
     * Lấy thông tin trong lĩnh vực giải trí
     * Mỗi thể loại 8 nhà hàng
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getEntertainmentFace(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        Entertainment entertainment = new Entertainment(
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_KARAOKE, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_HATCHONHAUNGHE, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_RAPCHIEUPHIM, LIMIT)),
                new ResultAPI(restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_KHUVUICHOI, LIMIT)));

        stopWatch.stop();
        restaurantDAO.close();
        return gson.toJson(entertainment);
    }


    /**
     * Tìm trong lĩnh vực giải trí các quán karaoke
     * type: 3, type restaurant 3, nằm trong lĩnh vực giải trí
     * TAG_ENTERTAINMENT_KARAOKE
     * Find in collection
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/karaoke")
    public String getKaraoke() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_KARAOKE);

        restaurantDAO.close();
        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/hat-cho-nhau-nghe")
    public String getHatChoNhauNghe() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_HATCHONHAUNGHE);


        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/rap-chieu-phim")
    public String getRapChieuPhim() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_RAPCHIEUPHIM);


        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/khu-vui-choi")
    public String getKHUVUICHOI() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurantByTypeAndCollection(Define.RESTAURANT_TYPE_ENTERTAINMENT, Define.TAG_ENTERTAINMENT_KHUVUICHOI);


        stopWatch.stop();
        return gson.toJson(new ResultAPI(restaurants));
    }
}

