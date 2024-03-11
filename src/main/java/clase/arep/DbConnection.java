package clase.arep;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    static String connectionString = "mongodb://db:27017";
    static MongoCollection<Document> collection;
    public static void addLog(String message){
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(connectionString))
        .build();
    // Connect to MongoDB
    try (com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings)) {
    // Connect to the "test" database (update with your desired database name)
    MongoDatabase database = mongoClient.getDatabase("db");

    // Create a collection (table) named "myTable"
    collection = database.getCollection("logs");

    // Create an index on the "dateAdded" field for better performance
    collection.createIndex(new Document("date", 1));

    // Create a document with a text field and the current date
    Document document = new Document("text", message)
            .append("date", new Date());

    // Insert the document into the collection
    collection.insertOne(document);

    System.out.println("Document added to the collection successfully.");
} catch (Exception e) {
    System.err.println("Error: " + e.getMessage());
    e.printStackTrace();
}
    }

     public static String getLogs() {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase db = mongoClient.getDatabase("db");
            MongoCollection<Document> collection = db.getCollection("logs");

            List<Document> rep = collection
                    .find()
                    .sort(Sorts.descending("date"))
                    .limit(10)
                    .into(new ArrayList<>());

            List<String> listLogs = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();

            for (Document docu : rep) {
                String mensaje = docu.getString("text");
                Date fecha = docu.getDate("date");
                listLogs.add(fecha + " " + mensaje);
            }

            // Convert the list to a JSON-formatted string
            return objectMapper.writeValueAsString(listLogs);
        } catch (Exception e) {
            System.err.println("Error al obtener el registro en MongoDB: " + e.getMessage());
        }
        return null;
    }

}
