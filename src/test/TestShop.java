package test;

/**
 * Created by DBQ on 2016/11/26.
 */
public class TestShop {
    public static void main(String[] args) {
        Shop shop = new Shop(0);
        Customer customer = new Customer(shop);
        Producer producer = new Producer(shop);
        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(producer);
        t1.start();
        t2.start();
        t3.start();
    }

}

class Shop {

    int product;

    public Shop(int product) {
        this.product = product;
    }

    synchronized void sale() throws InterruptedException { // 卖出


        if (product <= 0) {
            wait();
        }else{
            product--;
            System.out.println("卖出一个,还有" + product + "个");
            notifyAll(); // notify();
        }
    }

    synchronized void add() throws InterruptedException { // 上架


        if (product >= 20) {
            wait();
        }else{
            product++;
            System.out.println("上架一个,还有" + product + "个");
            notifyAll(); // notify();
        }
    }
}

class Customer implements Runnable {

    Shop shop;

    public Customer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep((int) (Math.random() * 1000));
                shop.sale();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {

    Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 1000));
                shop.add();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}