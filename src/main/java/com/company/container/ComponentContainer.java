package com.company.container;

import com.company.ToysShop;
import com.company.enums.AdminStatus;
import com.company.model.Customer;
import com.company.model.Order;
import com.company.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ComponentContainer {

//    public static final String BOT_TOKEN = "5305104361:AAEt0nfNQq0U-f4S99X2Q7fx1fP1tR_Xu9A";
//    public static final String BOT_NAME = "toys_city_bot";

    public static final String BOT_TOKEN = "5305104361:AAEt0nfNQq0U-f4S99X2Q7fx1fP1tR_Xu9A";
    public static final String BOT_NAME = "toys_city_bot";

    public static final String ADMIN_ID = "1870514088";

    public static ToysShop TOYS_BOT;

    public static Map<String, Product> productMap = new HashMap<>();
    public static Map<String, Product> crudStepMap = new HashMap<>();
    public static Map<String, AdminStatus> productStepMap = new HashMap<>();

    public static Map<String, Order> orderMap = new HashMap<>();

    public static Map <String, Customer> giveAdmin = new HashMap<>();

    public static int generalId = 0;
}
