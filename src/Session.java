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
        this.status = SessionStatus.ONGOING;
        notifyObservers("Session created by interviewer : " + interviewer.getName());
    }

    public void addParticipant(User user) throws Exception {
        activeSessionCheck();
        participants.add(user);  
        notifyObservers("Participant joined for interview " + user.getName());
    }

    public void addCandidate(User user) throws Exception {
        activeSessionCheck();
        if(candidate != null && candidate.getId() != user.getId()) 
            throw new Exception("Candidate is already there!!!!");
        candidate = user;
        notifyObservers("Candidate joined interview " + user.getName());
    }

    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.notify(event));
    }

    private void activeSessionCheck() throws Exception {
        if(this.status.equals(SessionStatus.COMPLETED))
            throw new Exception("Session is already done and dusted");
    }

    public void sendMessage(String message, User sender) {
        Message m1 = new Message(message, sender);
        messages.add(m1);
        notifyObservers(m1.toString());
    }

    public void editCode(User user, String content) {
        editor.setContent(content);
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

    public CodeEditor getEditor() {
        return editor;
    }

    public String showCurrentCode() {
        return editor.getContent();
    }

    public void rollbackToVersion(int version) throws Exception {
        editor.rollbackToVersion(version);
    }

    public void leave(User user) throws Exception {
        if(user.getId().equals(candidate.getId())) {
            notifyObservers("Candidate left!!!!");
        } else if(user.getId().equals(interviewer.getId())) {
            notifyObservers("Interviewer left!!!!");
        } else {
            if(participants.contains(user)) {
                participants.remove(user);
            } else {
                throw new Exception("No such participant exist!!!!");
            }
        }
    }

    public void endSession() {
        notifyObservers("Event ended!!!");
    }
}
