package facade;

import com.google.gson.Gson;
import com.project.DAO.sql.SaleDao;
import com.project.POJO.result.SaleResult;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by VietAnh on 9/14/2016.
 */
@Path("/find")
public class FindFacade {

    /**
     * Tìm kiếm mọi thứ ở đây
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getFindFace(@QueryParam("keyword") String keyword){
        //Tim kiem
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        SaleDao saleDao = new SaleDao();
        Gson gson = new Gson();
        SaleResult saleResult = saleDao.findSale(keyword);
        saleDao.closeBD();
        stopWatch.stop();
        return gson.toJson(saleResult);
    }
}
