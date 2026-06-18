import java.time.LocalTime;

public class Message {
    private String message;
    private String senderId;
    private LocalTime time;

    public Message(String message, String senderId) {
        this.message = message;
        this.senderId = senderId;
        this.time = LocalTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public LocalTime getTime() {
        return time;
    }
}
