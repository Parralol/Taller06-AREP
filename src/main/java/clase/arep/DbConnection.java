package clase.arep;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

public final class DbConnection {
    static String connectionString = "mongodb://root:pass@db:27017/logs";
    static MongoCollection<Document> collection;
    public static void addLog(String message){
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString))
                .build();
        try(MongoClient client = MongoClients.create(settings)){
            MongoDatabase db = client.getDatabase("logs");
            collection = db.getCollection("logs");
            Document logEntry = new Document();
            logEntry.append("Message", message);
            logEntry.append("Date", new Date());
            collection.insertOne(logEntry);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

     public static List<String> getLogs() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://mongo-db:27017/logs")){
            MongoDatabase db = mongoClient.getDatabase("logs");
            MongoCollection<Document> collection = db.getCollection("logs");
            List<Document> ultimas10Cadenas = collection
                    .find()
                    .sort(Sorts.descending("fecha"))
                    .limit(10)
                    .into(new ArrayList<>());
            ArrayList<String> listLogs = new ArrayList<>();
            for (Document doc : ultimas10Cadenas) {
                String mensaje = doc.getString("mensaje");
                Date fecha = doc.getDate("fecha");
                listLogs.add(fecha + " " +   mensaje);
            }
            return listLogs;
        } catch (Exception e) {
            System.err.println("Error al obtener el registro en MongoDB: " + e.getMessage());

        }
        return null;
    }

}
