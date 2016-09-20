import fx.domain.*;
import fx.service.*;

import java.util.HashMap;

/**
 * Simple demo class for presentation of http-server
 */
public class Runner {
    public static void main(String[] args) {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/prices");
        Response resp = hb.parameter("instruments", "EUR_USD")
                .authorization()
                .get()
                .execute();
        System.out.println(resp);

        AccountsService accServ = new AccountsService();
        Accounts domAccs;
        try {

            domAccs = accServ.getAll(); // obtain Accounts object
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }

        for (Account i : domAccs.getAccounts()) { // Accounts is a List of AccountsService objects
            System.out.println("List of accounts:");
            System.out.println(i.getAccountName() + " " + i.getAccountId());
        }

        /* AccountsService.getAccountInformation method */
        int accId = domAccs.getAccounts().get(0).getAccountId();
        AccountInformation accInfo;
        try {
            accInfo = accServ.getAccountInformation(accId);
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        System.out.println(accInfo.getAccountName() + " " +
                accInfo.getAccountId() + " " +
                accInfo.getBalance() + " " +
                accInfo.getAccountCurrency() + " " +
                accInfo.getOpenOrders() + " " +
                accInfo.getOpenTrades() + " " +
                accInfo.getMarginAvail() + " " +
                accInfo.getMarginUsed() + " " +
                accInfo.getMarginRate());

        /* OrdersServise */
        OrdersService ordServ = new OrdersService();

        /* OrdersService.create method */
        NewOrder newOrder;
        try {
            newOrder = ordServ.create(accId, "EUR_USD", 1, "sell", "market", null);
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        System.out.println("Create order");
        System.out.println(newOrder.getInstrument() + " " +
                newOrder.getPrice() + " " +
                newOrder.getTime() + " " +
                newOrder.getTradeOpened() + " " +
                newOrder.getTradeReduced() + " " +
                newOrder.getTradesClosed());


        /* OrdersService.getAll method */
        HashMap<String, String> params = new HashMap<>();
        params.put("count", "15");
        params.put("instrument", "EUR_USD");
        Orders orders;
        try {
            orders = ordServ.getAll(accId, params); // obtain Orders object
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        System.out.println("Get orders");
        for (Order order : orders.getOrders()) { // Orders is a List of Order objects
            System.out.println(order.getId() + " " +
                    order.getInstrument() + " " +
                    order.getUnits() + " " +
                    order.getPrice() + " " +
                    order.getType()
            );
        }

        int orderID = orders.getOrders().get(0).getId();

        /* OrdersService.getInformation method */
        Order order;
        try {
            order = ordServ.getInformation(accId, orderID);
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        System.out.println("Information about order id " + orderID);
        System.out.println(order.getId() + " " +
                order.getType() + " " +
                order.getPrice() + " " +
                order.getUnits() + " " +
                order.getInstrument() + " " +
                order.getLowerBound() + " " +
                order.getStopLoss() + " " +
                order.getTakeProfit() + " " +
                order.getUpperBound() + " " +
                order.getExpiry() + " " +
                order.getTime() + " " +
                order.getType() + " " +
                order.getSide()
        );
    }
}
