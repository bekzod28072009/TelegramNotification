package main

import (
    "log"
    "os"

    tgbotapi "github.com/go-telegram-bot-api/telegram-bot-api/v5"
)

func main() {
    bot, err := tgbotapi.NewBotAPI(os.Getenv("TELEGRAM_TOKEN"))
    if err != nil {
        log.Panic(err)
    }

    u := tgbotapi.NewUpdate(0)
    u.Timeout = 60

    updates := bot.GetUpdatesChan(u)
    for update := range updates {
        if update.Message != nil {
            msg := tgbotapi.NewMessage(update.Message.Chat.ID, "Hello from Go!")
            bot.Send(msg)
        }
    }
}
