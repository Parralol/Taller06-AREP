package clase.arep;

import static spark.Spark.get;
import static spark.Spark.port;


public class LogService {

    public static void main(String[] args){
        port(getPort());
       
        get("/logservicefacade", (req,res) -> {res.type("application/json");
            return "{\"a\":{\"b\":\"data\"}}";});

        get("/logs", (req,res) -> {
            String message = req.queryParams("val");
            res.type("application/json");
            DbConnection.addLog(message);
            return DbConnection.getLogs();});
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
