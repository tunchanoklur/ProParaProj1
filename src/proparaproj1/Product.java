package proparaproj1;

class Product implements Comparable<Product>{
    //read from file
   private String name;
   private int price;
   //keep the total sales amount of this product
   private int totalSales;
   private int quantity;
   //Product constructor
   public Product(){}
   public Product(String n,int p){
       name = n;
       price = p;
       quantity = 0;
       totalSales = 0;
   }
   protected int giveprice(){
       return this.price;
   }
   protected void setTotalSales(int sales){
       quantity+=sales;
       totalSales = quantity*price;
   }
   public int compareTo(Product other){
        if(this.totalSales>other.totalSales) return -1;
        else if(this.totalSales<other.totalSales)return 1;
        else return 0;
    }
   protected void print(){
       System.out.printf("%-8s  total sales : %8d\n",name,totalSales);
   }
}
