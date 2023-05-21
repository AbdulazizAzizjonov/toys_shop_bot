package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;
import java.util.List;

public class KeyboardUtil {

    public static ReplyKeyboardMarkup contactMarkup(){
        KeyboardButton contactButton = new KeyboardButton("Raqamni jo'natish\uD83D\uDCDE");
        contactButton.setRequestContact(true);
        KeyboardRow row = getRow(contactButton);
        List<KeyboardRow> rowList = getRowList(row);
        return getMarkup(rowList);
    }


    public static ReplyKeyboardMarkup locationButton() {
        KeyboardButton locationButton = new KeyboardButton("Joylashuvni jo'natish\uD83D\uDCCD");
        KeyboardButton cancel = new KeyboardButton("Bekor qilish ❎");
        locationButton.setRequestLocation(true);
        KeyboardRow row1 = getRow(locationButton);
        KeyboardRow row2 = getRow(cancel);
        List<KeyboardRow> rowList = getRowList(row1, row2);
        return getMarkup(rowList);
    }


    public static ReplyKeyboardMarkup orderList() {
        KeyboardButton simple = new KeyboardButton("Oddiy");
        KeyboardButton pdf = new KeyboardButton("PDF");
        KeyboardButton excel = new KeyboardButton("EXCEL");
        KeyboardButton back = new KeyboardButton("Ortga qaytish◀️");

        KeyboardRow row1 = getRow(simple, pdf, excel);
        KeyboardRow row4 = getRow(back);

        List<KeyboardRow> rowList = getRowList(row1, row4);
        return getMarkup(rowList);
    }

    public static ReplyKeyboardMarkup CustomerMenu() {

        KeyboardButton menuButton = getButton("Menyu\uD83D\uDCDD");

        KeyboardButton orders = getButton("Buyurtmalarim\uD83D\uDECD");
        KeyboardButton basket = getButton("Savatcha🛒");
        KeyboardButton otherService = getButton("Boshqa xizmatlar\uD83D\uDCDD");

        KeyboardRow row1 = getRow(menuButton);
        KeyboardRow row2 = getRow(basket, orders);
        KeyboardRow row3 = getRow(otherService);

        List<KeyboardRow> rowList = getRowList(row1, row2, row3);
        return getMarkup(rowList);
    }


    private static KeyboardButton getButton(String demo){
        return new KeyboardButton(demo);
    }

    private static KeyboardRow getRow(KeyboardButton ... buttons){
        return new KeyboardRow(Arrays.asList(buttons));
    }

    private static List<KeyboardRow> getRowList(KeyboardRow ... rows){
        return Arrays.asList(rows);
    }

    private static ReplyKeyboardMarkup getMarkup(List<KeyboardRow> keyboard){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }
}
