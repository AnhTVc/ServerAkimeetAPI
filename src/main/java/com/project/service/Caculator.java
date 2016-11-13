//package service;
//
//import AffinityDao;
//import org.eclipse.jetty.server.Request;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * Created by nguyennhunai on 27/07/2016.
// */
//@Path("interest")
//public class facade.Caculator {
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("affinity")
//    public List getAffinityFacade(String domain, Request request) {
//
//
//        List results = new ArrayList<>();
//
//        String fromDate = request.getParameter("from_date");
//        String toDate = request.getParameter("to_date");
//
//
//        if (fromDate != null && toDate != null ) {
//
//            AffinityDao affinityDao = new AffinityDao();
//            Map<Long,String> topicMap = affinityDao.topicMapDao();
//            List affinity = affinityDao.getAffinityDao(fromDate,toDate,domain,topicMap);
//            affinityDao.closeBD();
//
//            results.addAll(affinity);
//        }
//        return results;
//    }
//    }
