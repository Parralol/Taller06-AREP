package clase.arep;

import static spark.Spark.get;
import static spark.Spark.port;

import static spark.Service.*;

public class LogService {

    public static void main(String[] args){
        ignite();
        port(getPort());
       
        get("/logservicefacade", (req,res) -> {res.type("application/json");
                                                return "json";});
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
