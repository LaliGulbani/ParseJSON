package laligulbani.by.parse.doman.factory;



import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Factory {

    public Parser createGsonParser(String pSource) {
        return createGsonParser(new ByteArrayInputStream(pSource.getBytes()));
    }

    public Parser createGsonParser(InputStream pSource) {
        return new GsonParser(pSource);
    }

    public Parser createJSONParser(String pSource) {
        return createJSONParser(new ByteArrayInputStream(pSource.getBytes()));
    }

    public Parser createJSONParser(InputStream pSource) {
        return new JSONParser(pSource);
    }
}
