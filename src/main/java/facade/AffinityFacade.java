package facade;

import com.project.DAO.sql.AffinityDao;
import org.eclipse.jetty.server.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by nguyennhunai on 26/07/2016.
 */
public class AffinityFacade {

    public  List getAffinityFacade(String domain, Request request) {


        List results = new ArrayList<>();

        String fromDate = request.getParameter("from_date");
        String toDate = request.getParameter("to_date");


        if (fromDate != null && toDate != null ) {

            AffinityDao affinityDao = new AffinityDao();
            Map<Long,String> topicMap = affinityDao.topicMapDao();
            List affinity = affinityDao.getAffinityDao(fromDate,toDate,domain,topicMap);
            affinityDao.closeBD();

            results.addAll(affinity);
        }
        return results;
    }
}
