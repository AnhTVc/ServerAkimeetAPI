package facade.food;

import com.google.gson.Gson;
import com.project.DAO.sql.CollectionDAO;
import com.project.POJO.result.Home;
import com.project.POJO.result.SaleResult;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by VietAnh on 11/15/2016.
 */
@Path("/am-thuc")
public class SaleFoodFace {
    /**
     * Tìm kiếm ưu đãi:
     *  - Ưu đãi đặc biêt
     *  - Ưu đãi mới nhất
     *  - Ưu đãi được quan tâm nhiều nhất
     * @param limit
     * @param offset
     * @param type
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/uu-dai")
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
