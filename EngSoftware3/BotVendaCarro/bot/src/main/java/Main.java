import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import service.Observer;
import service.impl.MessageObserver;

public class Main {
    public static void main(String[] args) {
        String botToken = "SeuToken";
        Subject subject = new Subject();

        // Criar e adicionar observadores
        Observer observer1 = new MessageObserver("Observer 1");
        Observer observer2 = new MessageObserver("Observer 2");
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new MyAmazingBot(botToken, subject));
            System.out.println("MyAmazingBot successfully started!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
