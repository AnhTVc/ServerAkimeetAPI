import com.project.DAO.sql.PoolManagerRead;
import com.project.DAO.sql.PoolManagerWrite;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import com.project.util.ConstantConfigurationManager;


/**
 * Created by nguyennhunai on 24/07/2016.
 */
public class ServiceMain {

    private static final Logger logger = Logger.getLogger(ServiceMain.class);

    public static void main(String[] args) throws Exception {

        //ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        //minThread : core*25
        //maxThread : core*75
        QueuedThreadPool threadPool = new QueuedThreadPool(200, 10, 2000);
        Server jettyServer = new Server(threadPool);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        jettyServer.setHandler(context);

        ServerConnector connector = new ServerConnector(jettyServer);
//        connector.setHost("192.168.149.106");
        connector.setPort(ConstantConfigurationManager.PORT);
        jettyServer.addConnector(connector);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        logger.info("Server is starting . . .");

              jerseyServlet.setInitParameter(
                      "jersey.config.server.provider.packages","facade");

//              jerseyServlet.setInitParameter(
//              "jersey.config.server.provider.classnames", Homefacade.class.getCanonicalName());



        try {
           jettyServer.start();
           logger.info("Server is running on port " + ConstantConfigurationManager.PORT +" ...");
            jettyServer.join();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            PoolManagerRead.closePool();
            PoolManagerWrite.closePool();
            jettyServer.destroy();
        }
    }
}
