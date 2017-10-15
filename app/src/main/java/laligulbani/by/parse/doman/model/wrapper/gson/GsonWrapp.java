package laligulbani.by.parse.doman.model.wrapper.gson;


import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import laligulbani.by.parse.doman.model.user.User;
import laligulbani.by.parse.doman.model.user.gson.GsonUser;
import laligulbani.by.parse.doman.model.wrapper.Wrapp;


public class GsonWrapp implements Wrapp {

    @SerializedName("items")
    private Collection<GsonUser> items;

    @SerializedName("nextPageToken")
    private String nextPageToken;

    @SerializedName("kind")
    private String kind;

    @SerializedName("etag")
    private String etag;

    @Override
    public List<User> getItems() {
        return items.stream()
                .map(gsonUser -> (User) gsonUser)
                .collect(toList());
    }


    @Override
    public String getNextPageToken() {
        return nextPageToken;
    }

    @Override
    public String getKind() {
        return kind;
    }

    @Override
    public String getEtag() {
        return etag;
    }
}
