package clase.arep;
import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class LogServerFacade {
   private static final String[] LOG_SERVICE_URL = {"http://localhost:35001/logservicefacade","http://localhost:35002/logservicefacade","http://localhost:35003/logservicefacade"};
    public static void main(String[] args){
        HttpConnection invoker = new HttpConnection(LOG_SERVICE_URL);
        port(4657);
        staticFiles.location("/static");
        get("/logservice", (req,res) -> {
            res.type("application/json");
            return invoker.Invoke(args);
        });
    }
}
