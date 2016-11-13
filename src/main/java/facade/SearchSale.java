package facade;

import com.google.gson.Gson;
import com.project.DAO.sql.CollectionDAO;
import com.project.DAO.sql.SaleDao;
import com.project.POJO.result.SaleResult;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by VietAnh on 9/14/2016.
 */

@Path("/search")
public class SearchSale {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getSearchSale(@QueryParam("city") String city,
                                @QueryParam("district") String district,
                                @PathParam("date") String date,
                                @PathParam("time") String time,
                                @PathParam("limit") int limit,
                                @PathParam("offset") int offset) {


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //Tim kiem, loc
        SaleDao saleDao = new SaleDao();

        stopWatch.stop();
        return new Gson().toJson(saleDao.searchSale(city, district, date, time, limit, offset));
    }
}
