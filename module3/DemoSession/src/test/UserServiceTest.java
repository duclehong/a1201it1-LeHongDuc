package test;

import model.User;
import org.junit.Test;
import service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceTest {
    UserService userService = new UserService();
    @Test
    public void testGetUserName1() {
        User user = userService.getUserByName("Linh");
        assertEquals("Linh", user.getUsername());
        assertEquals("123456", user.getPassword());
    }

    @Test
    public void testGetUserName2() {
        User user = userService.getUserByName("Nam");
        assertNull(user);
    }
}
