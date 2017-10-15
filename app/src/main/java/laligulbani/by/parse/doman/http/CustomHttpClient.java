package laligulbani.by.parse.doman.http;


import java.io.InputStream;

public class CustomHttpClient implements HttpClient {

    @Override
    public InputStream request(String url) {
        throw new IllegalStateException("Implement HttpClient");
    }
}