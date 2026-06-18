import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap;
    private static UserManager instance = new UserManager();

    private UserManager() {
        userMap = new HashMap<>();
    }

    public static UserManager getInstance() {
        return instance;
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }

}
