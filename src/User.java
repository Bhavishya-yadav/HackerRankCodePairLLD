import java.util.UUID;

public class User {
    private String name;
    private String id;
    private UserRole role;

    public User(String name, UserRole Role) {
        this.name = name;
        this.id = UUID.randomUUID().toString().substring(4);
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    
}
