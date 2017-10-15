package laligulbani.by.parse.doman.parser;


import java.util.List;

import laligulbani.by.parse.doman.model.user.User;
import laligulbani.by.parse.doman.model.user.gson.GsonUser;
import laligulbani.by.parse.doman.model.wrapper.Wrapp;

public interface Parser {

    User parseUser() throws Exception;

    List<GsonUser> parseCollection() throws Exception;

    Wrapp parseObject() throws Exception;
}
