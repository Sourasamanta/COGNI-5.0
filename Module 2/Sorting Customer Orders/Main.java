/*
wORST CASR for both bubble and quick sort is O(n^2), whereas avg and best case for quick sort is O(nlogn) and for bubble sort is O(n^2)
*/

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

class Sort {

    Order[] orders;

    Sort(Order[] orders) {
        this.orders = orders;
    }

    void bubbleSort() {
        int flag = 0;
        for(int i = 0; i < orders.length; i++){
            flag = 0;
            for(int j = 1; j < orders.length - i; j++){
                if(orders[j].totalPrice < orders[j-1].totalPrice){
                    Order temp = orders[j];
                    orders[j] = orders[j-1];
                    orders[j-1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0)break;
        }
    }

    void quickSort(int low, int high) {
        if(low < high){
            int pi = partition(low, high);

            quickSort(low, pi-1);
            quickSort(pi+1, high);
        }
    }

    int partition(int low, int high) {

        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    void display() {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId);
            System.out.println("Customer Name: " + order.customerName);
            System.out.println("Total Price: " + order.totalPrice);
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Order[] orders = {
            new Order(101, "Alice", 4500),
            new Order(102, "Bob", 1200),
            new Order(103, "Charlie", 6700),
            new Order(104, "David", 2900),
            new Order(105, "Eva", 5100),
            new Order(106, "Frank", 800),
            new Order(107, "Grace", 9500),
            new Order(108, "Helen", 3600),
            new Order(109, "Ian", 7200),
            new Order(110, "Jack", 1800)
        };

        Sort sort = new Sort(orders);

        System.out.println("Before Sorting:");
        sort.display();

        sort.bubbleSort();

        System.out.println("After Bubble Sort:");
        sort.display();

        sort.quickSort(0, orders.length - 1);

        System.out.println("After Quick Sort:");
        sort.display();
    }
}