package com.company;

import com.company.container.ComponentContainer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {

        try {

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            ToysShop toysShop = new ToysShop();
            ComponentContainer.TOYS_BOT = toysShop;

            telegramBotsApi.registerBot(toysShop);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
