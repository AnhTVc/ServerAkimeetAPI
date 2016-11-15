package facade;

import com.google.gson.Gson;
import com.project.DAO.sql.SaleDao;
import com.project.POJO.Restaurant;
import com.project.POJO.result.Campaign;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by knight_cs on 23/08/2016.
 */
@Path("/nha-hang")
public class SaleFacade {
    private static final Logger logger = Logger.getLogger(SaleFacade.class);
//    @POST
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getSaleFacade(@QueryParam("id_sale")   String idSale) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        SaleDao saleDao = new SaleDao();

        Restaurant restaurant = saleDao.getSale(idSale);
        saleDao.closeBD();
        stopWatch.stop();
        logger.info("it time : " + stopWatch.getTime() + "ms");
        logger.info("---------------------");

        return gson.toJson(restaurant);
    }

}
