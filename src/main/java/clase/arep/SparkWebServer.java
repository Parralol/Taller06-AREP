package clase.arep;

import static spark.Spark.*;

public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        staticFiles.location("/static");
        get("/hello", (req,res) -> "Hello Docker!" );
        get("/calculadora", (req,res) -> Serial.generateRespone(req.queryParams("val")));
        get("/palindromo", (req,res) -> Serial.palindromo(req.queryParams("val")) ? "true" : "false");
        get("/vector", (req,res) ->  Serial.vector(req.queryParams("val")));
  }



private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4567;
  }
}
