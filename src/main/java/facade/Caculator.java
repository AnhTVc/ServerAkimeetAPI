package facade;

import com.project.POJO.Affinity;
import com.google.gson.Gson;
import com.project.DAO.sql.AffinityDao;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by nguyennhunai on 27/07/2016.
 */
@Path("interest")
public class Caculator {
    private static final Logger logger = Logger.getLogger(Caculator.class);
    @POST
    @Path("affinity")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String getAffinityFacade(@FormParam("domain")    String domain,
                                            @FormParam("from_date") String fromDate,
                                            @FormParam("to_date")   String toDate) {

        System.out.println("start ....");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();
        List<Affinity> results = new ArrayList<>();


//

        if (fromDate != null && toDate != null ) {

            AffinityDao affinityDao = new AffinityDao();
            Map<Long,String> topicMap = affinityDao.topicMapDao();
            List<Affinity> affinity = affinityDao.getAffinityDao(fromDate,toDate,domain,topicMap);
            affinityDao.closeBD();

            results.addAll(affinity);
        gson.toJson(results);
        }
        stopWatch.stop();
        System.out.println("it time : " + stopWatch.getTime() + "ms");
        System.out.println("end ....\n--------------------------");
        return gson.toJson(results);
//        return results;
    }

    @GET
    @Path("square")
    @Produces(MediaType.APPLICATION_JSON)
    public String square(@QueryParam("input") double input){
        return "nainn";
    }
    }
