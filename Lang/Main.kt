import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.network.fold
import com.github.kotlintelegrambot.logging.LogLevel
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.dispatcher.*
import com.github.kotlintelegrambot.webhook

fun main() {
    val bot = Bot.Builder()
        .token("YOUR_TELEGRAM_TOKEN")
        .logLevel(LogLevel.Network.Body)
        .build()

    bot.dispatch {
        command("start") {
            bot.sendMessage(chatId = message.chat.id, text = "Hello from Kotlin!")
        }
    }

    bot.startPolling()
}
