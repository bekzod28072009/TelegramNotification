import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "YourBotUsername"; // Bot username
    }

    @Override
    public String getBotToken() {
        return "YOUR_TELEGRAM_BOT_TOKEN"; // Bot token from BotFather
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String receivedText = update.getMessage().getText();

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("You said: " + receivedText);

            try {
                execute(message); // Send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
