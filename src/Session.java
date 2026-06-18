import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Session {
    private String sessionId;
    private User candidate;
    private User interviewer;
    private Set<User> participants;
    private CodeEditor editor;
    private List<Message> messages;
    private List<SessionObserver> observers;
    private SessionStatus status;

    public Session(User interviewer) {
        this.sessionId = UUID.randomUUID().toString().substring(4);
        this.candidate = null;
        this.interviewer = interviewer;
        this.participants = new HashSet<>();
        this.editor = new CodeEditor();
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.observers.add(new ConsoleObserver());
        this.status = SessionStatus.CREATED;
        notifyObservers("Session created");
    }

    public void addParticipant(User user) throws Exception {
        activeSessionCheck();
        participants.add(user);  
    }

    public void addCandidate(User user) throws Exception {
        activeSessionCheck();
        if(candidate != null && candidate.getId() != user.getId()) 
            throw new Exception("Candidate is already there!!!!");
        candidate = user;
        notifyObservers("Candidate joined interview");
    }

    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.notify(event));
    }

    private void activeSessionCheck() throws Exception {
        if(this.status.equals(SessionStatus.COMPLETED))
            throw new Exception("Session is already done and dusted");
    }

    public String getSessionId() {
        return sessionId;
    }

    public User getCandidate() {
        return candidate;
    }

    public User getInterviewer() {
        return interviewer;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public SessionStatus getStatus() {
        return status;
    }



}
