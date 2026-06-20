public class CodeVersion {
    private String content;
    private int versionNumber;
    private long timeStamp;

    public CodeVersion(String content, int versionNumber) {
        this.content = content;
        this.versionNumber = versionNumber;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    
}
