package facade;


import com.google.gson.Gson;
import com.project.DAO.sql.AutoCompleteDAO;
import com.project.DAO.sql.HomeDao;
import com.project.DAO.sql.SaleDao;
import com.project.POJO.result.Campaign;
import com.project.POJO.result.Home;
import com.project.POJO.result.SaleResult;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import org.glassfish.jersey.server.JSONP;
/**
 * Created by VietAnh on 9/8/2016.
 */
@Path("/AutoComplete")
public class AutoComplete {
    private static final Logger logger = Logger.getLogger(AutoComplete.class);
    //private static final Logger logger = Logger.getLogger(Homefacade.class);

    /**
     * Timf kiếm nhanh
     * @param keyword
     * @return
     */
    @GET
    @Produces({"application/x-javascript"})
    @JSONP(queryParam = "callback")
    public String getAutoComplete(@QueryParam("keyword")   String keyword) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        AutoCompleteDAO autoCompleteDAO = new AutoCompleteDAO();
        ArrayList<com.project.POJO.result.AutoComplete> autoCompletes = autoCompleteDAO.getAutoCompletes(keyword);

        logger.info("it time : " + stopWatch.getTime() + "ms");
        logger.info("---------------------");
        autoCompleteDAO.closeBD();
        return gson.toJson(autoCompletes);
    }
}
