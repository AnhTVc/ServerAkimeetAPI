package facade;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.DAO.sql.LicenseDAO;
import com.project.POJO.result.DeviceInfo;
import org.apache.commons.lang.time.StopWatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by VietAnh on 11/1/2016.
 */

@Path("/checklicense")
public class CheckLicenseFace {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getCheckLicenseFace(@QueryParam("project") String projectName,
                                      @QueryParam("email") String email,
                                      @QueryParam("deviceinfo") String data) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Gson gson = new Gson();

        stopWatch.stop();
        System.out.println("it time : " + stopWatch.getTime() + "ms");
        System.out.println("---------------------");
        LicenseDAO licenseDAO = new LicenseDAO();

        JsonObject jsonObject = new JsonObject();

        DeviceInfo deviceInfo = gson.fromJson(data, DeviceInfo.class);

        if(licenseDAO.registerLicences(projectName,email,deviceInfo))
            jsonObject.addProperty("process", "true");
        else{
            jsonObject.addProperty("process", "false");
        }

        licenseDAO.closeBD();
        return gson.toJson(jsonObject);
    }

}
