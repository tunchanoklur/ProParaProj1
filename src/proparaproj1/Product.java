package proparaproj1;

public class Product {
    //read from file
   private String name;
   private int price;
   //keep the total sales amount of this product
   private int totalSales;
   
   //Product constructor
   public Product(){}
   public Product(String n,int p){
       name = n;
       price = p;
       totalSales = 0;
   }
}
