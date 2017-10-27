package proparaproj1;

import java.text.NumberFormat;

class Customer implements Comparable<Customer>{
    private String name;
    protected int[] orders;
    private int totalBill;
    //Customer constructor
    public Customer(){}
    public Customer(String n,int[] order_in){
       name = n;
       orders = new int[5];
       orders=order_in;
       totalBill = 0;
    }
   //method for calculate total bill
    protected void calculateBill(Product[] products){
       for(int i=0;i<5;i++){
           totalBill+=orders[i]*products[i].giveprice();
       }
    }
   
    public int compareTo(Customer other){
        if(this.totalBill>other.totalBill) return -1;
        else if(this.totalBill<other.totalBill)return 1;
        else return 0;
    }
    protected void printcorrection(){
       System.out.printf("Correction  : %-8s %-3d %-3d %-3d %-3d %-3d\n\n",name,orders[0],orders[1],orders[2],orders[3],orders[4]);
    }
    
    protected void print(){
       NumberFormat changeformat;
       changeformat = NumberFormat.getInstance();
       System.out.printf("%-8s  total bill  : %10s\n",name,changeformat.format(totalBill));
    }
}
