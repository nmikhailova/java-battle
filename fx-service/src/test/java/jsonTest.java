import fx.service.JsonSerializationService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Оля on 18.04.2016.
 */
public class jsonTest {

    @Test
    public void toJson(){
        JsonSerializationService<User> js = new JsonSerializationService<User>();
        User user = new User();
        user.setName("Ola");
        user.setAge(20);
        String json = js.objectToJson(user);
        Assert.assertEquals("All right", json, user.toString());
        //System.out.println(json);
        User us = js.objectFromJson(json, User.class);
        System.out.println(us.toString());
        
    }

    @Test
    public void fromJson(){
        JsonSerializationService<User> js = new JsonSerializationService<User>();
        User user = new User();
        user.setName("Ola");
        user.setAge(20);
        String json = js.objectToJson(user);
        User us = js.objectFromJson(json, User.class);
        Assert.assertEquals(user, us);
        //System.out.println(us.toString());


    }
}
