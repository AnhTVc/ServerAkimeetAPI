package facade;

/**
 * Created by VietAnh on 9/25/2016.
 */

import com.google.gson.Gson;
import com.project.DAO.sql.SaleDao;
import com.project.POJO.result.Campaign;
import com.project.POJO.result.SaleResult;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Gợi ý người dùng. 4 campsa. Hiện tại đang để random
 */
@Path("/recommend")
public class RecommendFacade {
    private static final Logger logger = Logger.getLogger(RecommendFacade.class);
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getSaleFacade() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        SaleDao saleDao = new SaleDao();
        SaleResult recommend_sale = saleDao.recommendSale();
        saleDao.closeBD();
        stopWatch.stop();
        logger.info("it time : " + stopWatch.getTime() + "ms");
        logger.info("---------------------");
        return gson.toJson(recommend_sale);
    }
}
