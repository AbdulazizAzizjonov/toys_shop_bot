package com.company.util;


import com.company.database.Database;
import com.company.model.CartProduct;
import com.company.model.Category;
import com.company.model.Product;
import com.company.service.ProductService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.company.service.CategoryService.loadCategoryList;

public class InlineKeyboardUtil {

    public static InlineKeyboardMarkup othersService () {
        InlineKeyboardButton anons = getButton("E'lon berish \uD83D\uDCE9", "anons");
        InlineKeyboardButton branch = getButton( "Bizning Filiallar\uD83D\uDCCD", "location");
        InlineKeyboardButton call = getButton("Murojaat uchun ⁉️", "call");
        InlineKeyboardButton back = getButton("⏪ Ortga qaytish", "menu_ortga");

        List<InlineKeyboardButton> row1 = getRow(anons);
        List<InlineKeyboardButton> row2 = getRow(branch, call);
        List<InlineKeyboardButton> row3 = getRow(back);

        List<List<InlineKeyboardButton>> rowList = getRowList(row1, row2,row3);

        return new InlineKeyboardMarkup(rowList);
    }

    public static InlineKeyboardMarkup categoryForCustomer() {

        loadCategoryList();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (Category category : Database.categoryList) {
            List<InlineKeyboardButton> buttonList = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton(category.getName());
            button.setCallbackData("categoryForCustomer/" + category.getId());
            buttonList.add(button);
            rowList.add(buttonList);
        }

        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        InlineKeyboardButton button = getButton("⏪Ortga qaytish", "backButton");
        buttonList.add(button);
        rowList.add(buttonList);

        return new InlineKeyboardMarkup(rowList);
    }



    public static InlineKeyboardMarkup savatgaQoshildi() {
        InlineKeyboardButton continued = getButton("Savdoni davom ettirish \uD83D\uDD04", "continue");
        InlineKeyboardButton commit = getButton("Buyurtma Berish \uD83D\uDED2", Demo.COMMIT);

        List<InlineKeyboardButton> row1 = getRow(commit);
        List<InlineKeyboardButton> row2 = getRow(continued);
        List<List<InlineKeyboardButton>> rowList = getRowList(row1, row2);
        return new InlineKeyboardMarkup(rowList);
    }





    public static InlineKeyboardMarkup productInlineMarkupForCustomer (List<Product> productList) {

        ProductService.loadProductList();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (Product product : productList) {
            List<InlineKeyboardButton> buttonList = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton(product.getName());
            button.setCallbackData("productForUser/" + product.getId());
            buttonList.add(button);
            rowList.add(buttonList);
        }

        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton("⏪Ortga qaytish");
        button.setCallbackData("backCategory");
        buttonList.add(button);
        rowList.add(buttonList);

        return new InlineKeyboardMarkup(rowList);

    }


    public static InlineKeyboardMarkup selectCountMenu(Product product) {

        String suffix = " ta";

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (int i = 1; i <= 7; i += 3) {
            InlineKeyboardButton button1 = getButton(i + suffix, "count/" + product.getId() + "/" + i);
            InlineKeyboardButton button2 = getButton((i + 1) + suffix, "count/" + product.getId() + "/" + (i + 1));
            InlineKeyboardButton button3 = getButton((i + 2) + suffix, "count/" + product.getId() + "/" + (i + 2));

            List<InlineKeyboardButton> row = getRow(button1, button2, button3);

            rowList.add(row);
        }
        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton("⏪ Ortga qaytish");
        button.setCallbackData("backProduct");
        buttonList.add(button);
        rowList.add(buttonList);

        return new InlineKeyboardMarkup(rowList);
    }




    public static InlineKeyboardMarkup cartMenu(List<CartProduct> cartProductList) {

        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();

        for (CartProduct cartProduct : cartProductList) {

            InlineKeyboardButton button = new InlineKeyboardButton(
                    ("\uD83D\uDEAB ") + cartProduct.getProduct().getName());

            button.setCallbackData(Demo.REMOVE_CART_PRODUCT + "/" + cartProduct.getId());

            List<InlineKeyboardButton> row = getRow(button);

            rowList.add(row);
        }

        InlineKeyboardButton continueButton = getButton(("▶️") + Demo.CONTINUE_UZ, Demo.CONTINUE);
        InlineKeyboardButton commitButton = getButton(("✅") + (Demo.COMMIT_UZ), Demo.COMMIT);
        InlineKeyboardButton cancelButton = getButton(("❎") + (Demo.CANCEL_UZ), Demo.CANCEL);

        List<InlineKeyboardButton> row1 = getRow(commitButton, cancelButton);
        List<InlineKeyboardButton> row2 = getRow(continueButton);

        rowList.add(row1);
        rowList.add(row2);

        return new InlineKeyboardMarkup(rowList);
    }


    public static InlineKeyboardMarkup clear() {

        InlineKeyboardButton clear = getButton("\uD83D\uDDD1", "clear");
        List<InlineKeyboardButton> row1 = getRow(clear);
        List<List<InlineKeyboardButton>> rowList = getRowList(row1);
        return new InlineKeyboardMarkup(rowList);

    }













//    ADMIN

    public static InlineKeyboardMarkup productMenu() {
        InlineKeyboardButton addButton = getButton("➕ Добавить продукт ➕", "add_product");
        InlineKeyboardButton updateButton = getButton("✏️Изменить продукт ✏️", "update_product");
        InlineKeyboardButton deleteButton = getButton("❌ Удалить продукт ❌", "delete_product");
        InlineKeyboardButton listButton = getButton("✅ Посмотреть все продукты ✅", "show_product_list");

        List<InlineKeyboardButton> row1 = getRow(addButton);
        List<InlineKeyboardButton> row2 = getRow(updateButton);
        List<InlineKeyboardButton> row3 = getRow(deleteButton);
        List<InlineKeyboardButton> row4 = getRow(listButton);

        List<List<InlineKeyboardButton>> rowList = getRowList(row1, row2, row3, row4);
        return new InlineKeyboardMarkup(rowList);
    }

    private static InlineKeyboardButton getButton(String demo, String data) {
        InlineKeyboardButton button = new InlineKeyboardButton(demo);
        button.setCallbackData(data);
        return button;
    }


    private static List<InlineKeyboardButton> getRow(InlineKeyboardButton... buttons) {
        return Arrays.asList(buttons);
    }

    private static List<List<InlineKeyboardButton>> getRowList(List<InlineKeyboardButton>... rows) {
        return Arrays.asList(rows);
    }

    public static InlineKeyboardMarkup categoryInlineMarkup() {

        loadCategoryList();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        for (Category category : Database.categoryList) {
            List<InlineKeyboardButton> buttonList = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton(category.getName());
            button.setCallbackData("add_p_c_i/" + category.getId());
            buttonList.add(button);
            rowList.add(buttonList);
        }
        InlineKeyboardButton back = getButton("◀️ BACK", "back");
        List<InlineKeyboardButton> row1 = getRow(back);
        rowList.add(row1);
        return new InlineKeyboardMarkup(rowList);
    }


    public static InlineKeyboardMarkup productsNext (int step, int size) {

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        if (step != 0) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText("⏪");
            button.setCallbackData("C/" + (step - 1));
            row.add(button);
        }

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("✅");
        button.setCallbackData("CH/" + step);
        row.add(button);

        rowList.add(row);

        if (step + 1 != size) {
            InlineKeyboardButton button1 = new InlineKeyboardButton();
            button1.setCallbackData("⏩");
            button1.setCallbackData("C/" + (step + 1));
            row.add(button1);
        }

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("ORQAGA");
        button1.setCallbackData("_back");
        row1.add(button1);
        rowList.add(row1);

        markup.setKeyboard(rowList);

        return markup;
    }


    public static InlineKeyboardMarkup confirmAddProductMarkup() {

        InlineKeyboardButton commit = getButton("Ha", "add_product_commit");
        InlineKeyboardButton cancel = getButton("Yo'q", "add_product_cancel");

        return new InlineKeyboardMarkup(getRowList(getRow(commit, cancel)));
    }

    //UPDATE

    public static InlineKeyboardMarkup productUpdate () {

        InlineKeyboardButton update_name = getButton("Nomini o'zgartirish", "update_name");
        InlineKeyboardButton update_price = getButton("Narxini o'zgartirish", "update_price");

        InlineKeyboardButton back = getButton("◀ Ortga qaytish", "backProductUpdate");

        List<InlineKeyboardButton> row1 = getRow(update_name, update_price);
        List<InlineKeyboardButton> row3 = getRow(back);

        List<List<InlineKeyboardButton>> rowList = getRowList(row1, row3);
        return new InlineKeyboardMarkup(rowList);
    }

    public static InlineKeyboardMarkup updateNameProduct() {

        ProductService.loadProductList();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (Product product : Database.productList) {
            InlineKeyboardButton button = new InlineKeyboardButton(product.getName());
            List<InlineKeyboardButton> buttonList = new ArrayList<>();
            button.setCallbackData("update_name_Product/" + product.getId());
            buttonList.add(button);
            rowList.add(buttonList);
        }

        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton(" Ortga qaytish");
        button.setCallbackData("backButtonMenu");
        buttonList.add(button);
        rowList.add(buttonList);

        return new InlineKeyboardMarkup(rowList);
    }



    public static InlineKeyboardMarkup updatePriceProduct() {

        ProductService.loadProductListAll();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (Product product : Database.productList) {
            InlineKeyboardButton button = new InlineKeyboardButton(product.getName());
            List<InlineKeyboardButton> buttonList = new ArrayList<>();
            button.setCallbackData("update_price_Product/" + product.getId());
            buttonList.add(button);
            rowList.add(buttonList);
        }

        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton("Ortga qaytish");
        button.setCallbackData("backButtonSelectParametr");
        buttonList.add(button);
        rowList.add(buttonList);

        return new InlineKeyboardMarkup(rowList);
    }


}
