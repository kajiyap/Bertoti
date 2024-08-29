import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import service.Venda;
import service.impl.AVista;
import service.impl.Financiamento;
import service.impl.Parcelado;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final Subject subject;

    public MyAmazingBot(String botToken, Subject subject) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
        this.subject = subject;
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            Venda venda;

            SendMessage message = null;
            if (messageText.equals("/Parcelado")) {
                venda = new Parcelado();
                message = SendMessage.builder().chatId(chatId).text(venda.vender()).build();
            } else if (messageText.equals("/Avista")) {
                venda = new AVista();
                message = SendMessage.builder().chatId(chatId).text(venda.vender()).build();
            } else if (messageText.equals("/Financiado")) {
                venda = new Financiamento();
                message = SendMessage.builder().chatId(chatId).text(venda.vender()).build();
            } else {
                message = SendMessage.builder().chatId(chatId).text(messageText).build();
            }

            try {
                telegramClient.execute(message);
                subject.notifyObservers(messageText); // Notificar observadores
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
