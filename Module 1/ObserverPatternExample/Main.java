import java.util.ArrayList;
import java.util.List;

interface Stock {

    void register(Observer observer);

    void deregister(Observer observer);

    void notifyObservers();
}

interface Observer {

    void update(String stockName, double price);
}

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " Price = ₹" + price);
    }
}

class WebApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName + " Price = ₹" + price);
    }
}

public class Main {

    public static void main(String[] args) {

        StockMarket stock = new StockMarket("TCS");

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stock.register(mobile);
        stock.register(web);

        System.out.println("Stock Price Changed to 3500");
        stock.setPrice(3500);

        System.out.println();

        stock.deregister(web);

        System.out.println("Stock Price Changed to 3600");
        stock.setPrice(3600);
    }
}