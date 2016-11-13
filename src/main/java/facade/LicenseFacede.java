package facade;

import com.google.gson.Gson;
import com.project.DAO.sql.LicenseDAO;
import com.project.POJO.result.Licences;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by VietAnh on 11/1/2016.
 */

@Path("/license")
public class LicenseFacede {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getLicenseFacede(@QueryParam("project") String projectName) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("it time : " + stopWatch.getTime() + "ms");
        Gson gson = new Gson();

        stopWatch.stop();

        LicenseDAO licenseDAO = new LicenseDAO();
        Licences licences = licenseDAO.getLicences(projectName);
        licenseDAO.closeBD();
        System.out.println("---------------------");
        return gson.toJson(licences);
    }


}
