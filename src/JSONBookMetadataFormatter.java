import java.io.IOException;
import com.google.gson.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JsonArray ja = new JsonArray();
    public JSONBookMetadataFormatter(){
        reset();
    }
    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        ja = new JsonArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JsonObject book = new JsonObject();
        book.addProperty("ID",b.getISBN());
        book.addProperty("Title", b.getTitle());
        book.addProperty("Publisher", b.getPublisher());
        JsonArray authorList = new JsonArray();
        for (String author : b.getAuthors()){
            authorList.add(author);
        }
        book.add("Authors", authorList);
        ja.add(book);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse((ja.toString()+"\n"));
        return gson.toJson(je);
    }
}
