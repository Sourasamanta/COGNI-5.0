import java.util.Arrays;
import java.util.Comparator;


class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class Search{
    Product[] products;
    int sort = 0;

    Search(Product[] products){
        this.products = products;
    }

    void linearSearch(int id){
        for(Product p : products){
            if(p.productId == id){
                System.out.println("Product Found");
                System.out.println("ID: " + p.productId);
                System.out.println("Name: " + p.productName);
                System.out.println("Category: " + p.category);
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    void binarySearch(int id){
        if(sort == 0){
            Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
            sort = 1;
        }

        int start = 0;
        int end = products.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(products[mid].productId == id){
                System.out.println("Product Found");
                System.out.println("ID: " + products[mid].productId);
                System.out.println("Name: " + products[mid].productName);
                System.out.println("Category: " + products[mid].category);
                return;
            }
            else if(products[mid].productId < id){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println("Product Not Found");
    } 
}

public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(108, "Mouse", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(110, "Notebook", "Stationery"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(106, "Pen", "Stationery"),
            new Product(109, "Monitor", "Electronics"),
            new Product(102, "Book", "Education"),
            new Product(105, "Headphones", "Electronics"),
            new Product(107, "Calculator", "Education"),
            new Product(104, "Printer", "Electronics")
        };

        Search search = new Search(products);

        System.out.println("Linear Search:");
        search.linearSearch(105);

        System.out.println("\nBinary Search:");
        search.binarySearch(105);
    }
}