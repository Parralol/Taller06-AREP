package clase.arep;

import static spark.Spark.get;
import static spark.Spark.port;

public class LogService {
    public static void main(){
        port(5000);
        get("/logservicefacade", (req,res) -> {res.type("application/json");
                                                return "json";});
        
    }
}
