package facade;

import com.google.gson.Gson;
import com.project.DAO.sql.CollectionDAO;
import com.project.POJO.result.Campaign;
import com.project.POJO.result.Home;
import com.project.POJO.result.SaleResult;
import com.project.util.DAOUtil;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by VietAnh on 9/14/2016.
 */


@Path("/tim-kiem-theo-chu-de")
public class Collection {
    private static final Logger logger = Logger.getLogger(AddtionFacade.class);
    /**
     * Function get collection
     * @param limit
     * @param offset
     * @param type
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getCollection(@QueryParam("limit")   int limit,
                                   @QueryParam("offset")   int offset,
                                   @QueryParam("type")   int type) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Gson gson = new Gson();
        CollectionDAO collectionDAO = new CollectionDAO();
        SaleResult saleResult = new SaleResult(collectionDAO.getCollection(type, limit, offset));
        collectionDAO.closeBD();
        stopWatch.stop();
        return gson.toJson(saleResult);
    }
}
