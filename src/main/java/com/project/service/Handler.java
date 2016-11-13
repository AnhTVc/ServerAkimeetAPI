package com.project.service;




import com.google.gson.Gson;
import facade.AffinityFacade;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 21/11/2014.
 */
public class Handler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(Handler.class);

    @Override
    public void handle(String path_request, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        List results = new ArrayList<>();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String domain = path_request.split("/")[1];
        String path = path_request.replaceAll("/" + domain + "/", "");


        switch (path){

            case "interest/affinity":
                AffinityFacade affinityFacade = new AffinityFacade();
                results.addAll(affinityFacade.getAffinityFacade(domain, request));
                break;
        }


            logger.info(path_request);
            // 3. response to client
            Gson gson = new Gson();
            httpServletResponse.getWriter().println(gson.toJson(results));
           stopWatch.stop();
        logger.info("it time : " + stopWatch.getTime() + "ms");
    }
    }

