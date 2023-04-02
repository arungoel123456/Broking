import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.services.*;

import javax.sound.sampled.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService= new UserServiceImpl();
        User a= userService.createUser("a");
        userService.addMoney(a, 1000);

        StockServiceImpl stockService= StockServiceImpl.getInstance();
        Stock s1= stockService.addStock("a", 32);
        Stock s2= stockService.addStock("b", 432);

        a.getWatchList().add(s1);
        a.getWatchList().add(s2);


        OrderServiceImpl orderService=  OrderServiceImpl.getInstance();
        orderService.placeMarketOrder("a", 1, OrderType.BUY, a);


        Map<Stock, PortfolioStock> aPortfolio= userService.getPortfolio(a).getPortfolio();
        System.out.println(aPortfolio);

        aPortfolio.forEach((k,v) -> System.out.println("stock = "
                + k.id + ", portfolioStock = " + v.getQuantity() + " " + v.getAveragePrice() ));

        orderService.createLimitOrder("a", 34, 2,OrderType.BUY, a);

        stockService.setStockPrice("a", 34);



        orderService.placeMarketOrder("a", 1, OrderType.SELL, a);

        aPortfolio.forEach((k,v) -> System.out.println("stock = "
                + k.id + ", portfolioStock = " + v.getQuantity() + " " + v.getAveragePrice() ));

        System.out.println(a.getFund());


        orderService.updateLimitOrders("a", 34);
        aPortfolio.forEach((k,v) -> System.out.println("stock = "
                + k.id + ", portfolioStock = " + v.getQuantity() + " " + v.getAveragePrice() ));

    }
}