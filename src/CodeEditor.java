import java.util.ArrayList;
import java.util.List;

public class CodeEditor {
    private String currContent;
    private List<CodeVersion> versions;
    private int currVersion;

    public CodeEditor() {
        this.currContent = "";
        this.currVersion = 0;
        versions = new ArrayList<>();
    }

    public String getContent() {
        return currContent;
    }

    public void setContent(String content) {
        this.currContent = content;
        CodeVersion v = new CodeVersion(content, ++currVersion);
        versions.add(v);
    }

    public void rollbackToVersion(int version) throws Exception{
        for(int i = currVersion-1; i>=0; i--) {
            CodeVersion v = versions.get(i);
            if (v.getVersionNumber() == version) {
                currContent = v.getContent();
                currVersion++;
                versions.add(new CodeVersion(currContent, currVersion));
                return;
            }
        }
        throw new Exception("No such version found!!!" + version);
    }

}
