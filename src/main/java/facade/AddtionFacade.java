package facade;

import com.project.POJO.result.Home;
import com.project.POJO.result.SaleResult;
import com.google.gson.Gson;
import com.project.DAO.sql.AddtionDao;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by knight_cs on 31/08/2016.
 */

@Path("/addtion/{type}")
public class AddtionFacade {

    private static final Logger logger = Logger.getLogger(AddtionFacade.class);
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getAddtionFacade(@QueryParam("limit")   int limit,
                                   @QueryParam("offset")   int offset,
                                   @PathParam("type")   String type) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        AddtionDao addtionDao = new AddtionDao();

        SaleResult saleResult = addtionDao.getAllSale(limit, offset, type);
        addtionDao.closeBD();
        stopWatch.stop();
        System.out.println("it time : " + stopWatch.getTime() + "ms");
        System.out.println("---------------------");
        return gson.toJson(saleResult);
    }

}
