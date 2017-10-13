package proparaproj1;

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
   
    protected void print(){
       System.out.printf("%-8s  total bill  : %8d\n",name,totalBill);
    }
}
