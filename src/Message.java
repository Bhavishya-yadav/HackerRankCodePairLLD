import java.time.LocalTime;

public class Message {
    private String message;
    private User sender;
    private LocalTime time;

    public Message(String message, User sender) {
        this.message = message;
        this.sender = sender;
        this.time = LocalTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public LocalTime getTime() {
        return time;
    }

    public String toString() {
        return "Message sent by " + sender.getName() + " message : " + message + " time : " + time;
    }
}
