import java.util.*;

/*
used Array List, builder pattern, followed SOLID

Time Complexity
add - O(1)
delete, update, display - O(n)


can be optimized using hashmap, for hash map

Time Complexity
add, delete, update - O(1)
display - O(n)


*/

class Product {
    int productId = 0;
    String productName = "";
    int quantity = 0;
    int price = 0;    
}

class createProduct{
    Product prod;

    createProduct(){
        prod = new Product();
    }

    createProduct setId(int id){
        prod.productId = id;
        return this;
    }

    createProduct setName(String Name){
        prod.productName = Name;
        return this;
    }

    createProduct setqty(int qty){
        prod.quantity = qty;
        return this;
    }

    createProduct setprice(int price){
        prod.price = price;
        return this;
    }

    Product build(){
        return prod;
    }
}

class lfunc {

    ArrayList<Product> list;

    lfunc(ArrayList<Product> l){
        list = l;
    }

    void add(Product prod){
        list.add(prod);
    }

    void delete(int productId){
        Iterator<Product> iterator = list.iterator();

        while(iterator.hasNext()){
            Product p = iterator.next();

            if(p.productId == productId){
                iterator.remove();
                System.out.println("Product deleted.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    void update(int productId, Product newProduct) {

    for (Product p : list) {

        if (p.productId == productId) {
            p.productName = newProduct.productName;
            p.quantity = newProduct.quantity;
            p.price = newProduct.price;

            System.out.println("Product updated.");
            return;
        }
    }

    System.out.println("Product not found.");
}

    void display(){
        if(list.isEmpty()){
            System.out.println("No products available.");
            return;
        }

        for(Product p : list){
            System.out.println("ID: " + p.productId);
            System.out.println("Name: " + p.productName);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Price: " + p.price);
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {

        lfunc lfuncCall = new lfunc(new ArrayList<>());

        Product p1 = new createProduct()
                .setId(100)
                .setName("Laptop")
                .setqty(5)
                .setprice(50000)
                .build();

        Product p2 = new createProduct()
                .setId(101)
                .setName("Mouse")
                .setqty(10)
                .setprice(500)
                .build();

        lfuncCall.add(p1);
        lfuncCall.add(p2);

        System.out.println("===== Products After Adding =====");
        lfuncCall.display();

        Product updatedProduct = new createProduct()
                .setId(100)
                .setName("Gaming Laptop")
                .setqty(3)
                .setprice(75000)
                .build();

        lfuncCall.update(100, updatedProduct);

        System.out.println("\nProducts After Updating");
        lfuncCall.display();

        lfuncCall.delete(101);

        System.out.println("\nProducts After Deleting");
        lfuncCall.display();

        lfuncCall.delete(200);

        Product p3 = new createProduct()
                .setId(200)
                .setName("Keyboard")
                .setqty(8)
                .setprice(1200)
                .build();

        lfuncCall.update(200, p3);
    }
}

