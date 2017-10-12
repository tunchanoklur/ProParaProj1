package proparaproj1;

public class Customer {
   private String name;
   private int[] orders;
   private int totalBill;
   
   //Customer constructor
   public Customer(){}
   public Customer(String n,int or_1,int or_2,int or_3,int or_4,int or_5){
       name = n;
       orders = new int[5];
       //may change
       orders[0]=or_1;
       orders[1]=or_2;
       orders[2]=or_3;
       orders[3]=or_4;
       orders[4]=or_5;
       
       totalBill = 0;
   }
   
   //method for calculate total bill
   private void calculateBill(){
       /*
         Calculate the total bill
         Add code here
       */
   }
}
