package clase.arep;
import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.port;

import static spark.Spark.staticFiles;

public class LogServerFacade {
    private static final String[] LOG_SERVICE_URL = {"http://rest1:6001/logservicefacade","http://rest2:6001/logservicefacade","http://rest3:6001/logservicefacade"};
    private static final String[] LOG_URL = {"http://rest1:6001/logs","http://rest2:6001/logs","http://rest3:6001/logs"};
   //private static final String[] LOG_SERVICE_URL = {"http://localhost:35000/logservicefacade","http://localhost:35000/logservicefacade","http://localhost:35000/logservicefacade"};
    public static void main(String[] args){
        
        port(getPort());
        staticFiles.location("/static");
        get("/logservice", (req,res) -> {
            HttpConnection invoker = new HttpConnection(LOG_SERVICE_URL);
            res.type("application/json");
            return invoker.Invoke(args);
        });
        get("/favicon.ico", (req,res) -> {return "";});

        get("/logs", (req,res) -> {
            HttpConnection invoker = new HttpConnection(LOG_URL);
            res.type("application/json");
            return invoker.getLog(req);
        });        
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
