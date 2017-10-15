package laligulbani.by.parse;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import laligulbani.by.parse.doman.constant.Constants;
import laligulbani.by.parse.doman.factory.Factory;
import laligulbani.by.parse.doman.http.HttpClient;
import laligulbani.by.parse.doman.model.user.User;
import laligulbani.by.parse.doman.model.user.gson.GsonUser;
import laligulbani.by.parse.doman.model.wrapper.Wrapp;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static laligulbani.by.parse.doman.mocks.Mock.stream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION)
public class GsonParserTest {

    protected static final String TAG = GsonParserTest.class.getSimpleName();

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final String EXPECTED_AVATAR = "http://placehold.it/32x32";
    private static final String PATH_USER = "user/user.json";
    private static final String PATH_USERS = "user/user_list.json";
    private static final String PATH_USERS_WITH_ROOT_OBJECT = "user/user_list_with_root_object.json";
    private static final String PATH_GENERATED = "generated.json";

    private HttpClient mHttpClient;
    private Factory factory;

    @Before
    public void setUp() {

        factory = new Factory();
        mHttpClient = mock(HttpClient.class);
    }

    public InputStream getInputStream(String path) {
        InputStream mockedInputStream = stream(path);
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        return mHttpClient.request("http://myBackend/getUserList");
    }
    @Test
        public void parseGson_generated() throws Exception {

        final List<User> userList = factory.createGsonParser(getInputStream(PATH_GENERATED)).parseCollection();

        GsonUser gsonUser = (GsonUser) userList.get(0);
        Date registered = gsonUser.getRegistered();

        assertTrue(userList.size() == 5);
        assertTrue(userList.get(0).getId() == 0);
        assertEquals("Shelia Chang", userList.get(0).getName());
    }

    @Test
    public void parseGson() throws Exception {
        final User user = factory.createGsonParser(getInputStream(PATH_USER)).parseUser();

        assertEquals(EXPECTED_ID, user.getId());
        assertEquals(EXPECTED_NAME, user.getName());
        assertEquals(EXPECTED_AVATAR, user.getAvatar());
    }

    @Test
    public void parseGsonCollection() throws Exception {
        InputStream response = getInputStream(PATH_USERS);

        final List<User> userList = factory.createGsonParser(response).parseCollection();

        assertTrue(userList.size() == 2);
        assertTrue(userList.get(0).getId() == 1);
        assertEquals(EXPECTED_NAME, userList.get(0).getName());
    }

    @Test
    public void parseGsonCollectionWithObject() throws Exception {
        InputStream responseWithObject = getInputStream(PATH_USERS_WITH_ROOT_OBJECT);

        final Wrapp wrapp = factory.createGsonParser(responseWithObject).parseObject();
        assertTrue(wrapp.getItems().size() == 2);
        assertEquals("Vasia", wrapp.getItems().get(0).getName());
    }
}
