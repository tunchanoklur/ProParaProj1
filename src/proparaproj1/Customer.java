package proparaproj1;

class Customer implements Comparable<Customer>{
    private String name;
    protected int[] orders;
    private int totalBill;
    private boolean fixed;
    //Customer constructor
    public Customer(){}
    public Customer(String n,int[] order_in){
       name = n;
       orders = new int[5];
       orders=order_in;
       totalBill = 0;
       fixed=false;
    }
    public Customer(String n,int[] order_in,boolean fix){
       name = n;
       orders = new int[5];
       orders=order_in;
       totalBill = 0;
       fixed=fix;
    }
    /*public Customer(String n,int or1,int or2,int or3,int or4,int or5){
       name = n;
       orders = new int[5];
       orders[0]= or1;
       orders[1]= or2;
       orders[2]= or3;
       orders[3]= or4;
       orders[4]= or5;
       totalBill = 0;
    }*/
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
    protected boolean checkfixed(){
        return fixed;
    }
    protected void printcorrection(){
       System.out.printf("Correction  : %-8s %-3d %-3d %-3d %-3d %-3d\n\n",name,orders[0],orders[1],orders[2],orders[3],orders[4]);
    }
    
    protected void print(){
       System.out.printf("%-8s  total bill  : %8d\n",name,totalBill);
    }
}
