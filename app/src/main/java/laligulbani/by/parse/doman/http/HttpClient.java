package laligulbani.by.parse.doman.http;


import java.io.InputStream;

public interface HttpClient {
    InputStream request (String url);
}
