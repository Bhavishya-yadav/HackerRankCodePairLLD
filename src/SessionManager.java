import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<String, Session> sessionsMap;
    private static SessionManager instance = new SessionManager();

    private SessionManager() {
        sessionsMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        return instance;
    }

    public void addSession(Session session) {
        sessionsMap.put(session.getSessionId(), session);
    }

    public Session getSessionById(String id) {
        return sessionsMap.get(id);
    }
}
