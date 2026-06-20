public class HackerRankCodePairApplication {
    public static void main(String[] args) throws Exception {

        SessionManager sessionManager = SessionManager.getInstance();
        User interviewer = new User("Ankit", UserRole.INTERVIEWER);
        User candidate = new User("Bhavishya", UserRole.CANDIDATE);
        User participant = new User("Vipin", UserRole.OBSERVER);
        Session session = new Session(interviewer);
        sessionManager.addSession(session);

        session.addCandidate(candidate);
        session.addParticipant(participant);
        session.sendMessage("Interview Started", interviewer);
        session.editCode(candidate, "public class Solution { }");
        session.editCode(interviewer, "public class Solution { public static void main(String[] args) {} }");
        System.out.println(session.showCurrentCode());
        session.rollbackToVersion(1);
        System.out.println(session.showCurrentCode());
        session.leave(candidate);
        session.endSession();
        
    }
}
