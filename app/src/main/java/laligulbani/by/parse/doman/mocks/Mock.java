package laligulbani.by.parse.doman.mocks;


import junit.framework.Assert;

import java.io.InputStream;

public class Mock {
    public static InputStream stream(final String pName) {
        final InputStream resourceAsStream = Mock.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("resource not found, maybe you forget add .json?", resourceAsStream);
        return resourceAsStream;
    }
}
