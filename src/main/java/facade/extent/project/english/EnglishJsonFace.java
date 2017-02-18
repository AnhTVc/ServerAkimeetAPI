package facade.extent.project.english;

import com.extent.project.english.POJO.ToiecTest;
import com.extent.project.english.util.PDFUtil;
import com.google.gson.Gson;
import com.mongodb.util.JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import static facade.extent.project.english.Contant.*;

/**
 * Created by AnhTVc on 2/18/17.
 */

@Path("english")
public class EnglishJsonFace {
    /**
     * Face trả về dữ liệu (JSON) khi yêu cầu bài toiec.
     * @param typebook: Loại sán như Longman: type = 1, LONGMAN_BOOK
     * @param namebook: e.g: LONGMANIntroductory
     * @param toiec: e.g toiec one, two, three
     * @return: json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getEnglishJsonFace(@QueryParam("typebook") int typebook,
                                     @QueryParam("book") int namebook,
                                     @QueryParam("toeic") int toiec){


        if(typebook == LONGMAN_BOOK){
            if(namebook == LONGMANIntroductory){
                if(toiec == TEST_ONE){
                    return "Server Not Response";
                }else if(toiec == TEST_TWO){

                }else{
                    return "Request Error Paramaster";
                }
            }else if(namebook == LONGMANIntermediate){
                if(toiec == TEST_ONE){
                    return "Server Not Response";
                }else if(toiec == TEST_TWO){
                    String content = PDFUtil.fileToString(URL_RESULT + "test_2.json");

                    return content;
                }else{

                    return "Request Error Paramaster";
                }
            }else if(namebook == LONGMANAdvanced){
                if(toiec == TEST_ONE){
                    return "Server Not Response";
                }else if(toiec == TEST_TWO){

                    return "Server Not Response";
                }else{
                    return "Request Error Paramaster";
                }
            }else if(namebook == LONGMANMoreTest){
                if(toiec == TEST_ONE){
                    return "Server Not Response";
                }else if(toiec == TEST_TWO){
                    return "Server Not Response";
                }else if(toiec == TEST_THREE){
                    return "Server Not Response";
                }else if(toiec == TEST_FOUR){
                    return "Server Not Response";
                }else{
                    return "Request Error Paramaster";
                }
            }else
            {
                return "Request Error Paramaster";
            }

        }else {
            return "Request Error Paramaster";
        }
        return "Server Not Response";
    }
}
