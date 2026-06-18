public class ConsoleObserver implements SessionObserver{

    @Override
    public void notify(String message) {
        System.out.println("[Logger]" + message);
    }
    
}
