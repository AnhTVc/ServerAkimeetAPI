package facade;

import com.project.POJO.result.Home;
import com.project.POJO.result.SaleResult;
import com.google.gson.Gson;
import com.project.DAO.sql.HomeDao;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by knight_cs on 16/08/2016.
 * Custome by vietanh:
 * Du lieu tra lai trang home
 */
@Path("/")
public class Homefacade {
    //private static final Logger logger = Logger.getLogger(Homefacade.class);
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getHomeFacade() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        HomeDao homeDao = new HomeDao();

        SaleResult specialSale = homeDao.getSpecialSale();
        SaleResult lastSale = homeDao.getLastSale();
        SaleResult careSale = homeDao.getCareSale();
        SaleResult businessSale = homeDao.getBusinessSale();
        Home home = new Home(specialSale,lastSale,careSale, businessSale);
        homeDao.closeBD();
        stopWatch.stop();
        System.out.println("it time : " + stopWatch.getTime() + "ms");
        System.out.println("---------------------");
        return gson.toJson(home);
    }

}
