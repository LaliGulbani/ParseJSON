package laligulbani.by.parse.doman.model.wrapper;


import java.util.List;

import laligulbani.by.parse.doman.model.user.User;

public interface Wrapp {

    List<User> getItems();

    String getNextPageToken();

    String getKind();

    String getEtag();
}
