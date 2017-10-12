package proparaproj1;

import java.io.*;
import java.util.*;

public class Shopping {
    public static void main(String[] args) throws InterruptedException {
        Scanner productScan = null,orderScan = null,get_user;
        String productfile,orderfile,line;
        String[] buf;
        boolean filenotfound = true;
        ArrayList <Customer> customers=new ArrayList <Customer>();
        ArrayList <Product> products=new ArrayList <Product>();
        Customer[] cus_hold = new Customer[1];
        Product[] pro_hold= new Product[1];
        //get product file
        do{
            try{
                // get file name from user
                System.out.println("Enter product name:"); get_user =new Scanner(System.in);
                productfile = get_user.next(); 
                productScan  = new Scanner(new File(productfile));
                filenotfound = false;
            }
            catch (FileNotFoundException e){
                // print exception message    
                System.err.printf("%s\n",e);
                Thread.sleep(250);
                filenotfound = true;
            }
        }while(filenotfound);
        //get order file
        do{
            try{
                System.out.println("Enter order name:"); get_user =new Scanner(System.in);
                orderfile = get_user.next(); 
                orderScan  = new Scanner(new File(orderfile));
                filenotfound = false;
            }
            catch (FileNotFoundException e){
                // print exception message    
                System.err.printf("%s\n",e);
                Thread.sleep(500);
                filenotfound = true;
            }
        }while(filenotfound);
        
        while (productScan!=null && productScan.hasNext()) {
            line = productScan.nextLine();
            buf = line.split("\\s+"); //split by space and trimautomatically
            int price = Integer.parseInt(buf[1]);
            pro_hold[0] = new Product(buf[0],price);
            products.add(pro_hold[0]);
        }
        
        while (orderScan!=null && orderScan.hasNext()){
            line = orderScan.nextLine();
            buf = line.split("\\s+"); //split by space and trimautomatically
            try{
                int or1 = Integer.parseInt(buf[1]);
                int or2 = Integer.parseInt(buf[2]);
                int or3 = Integer.parseInt(buf[3]);
                int or4 = Integer.parseInt(buf[4]);
                int or5 = Integer.parseInt(buf[5]);
                cus_hold[0] = new Customer(buf[0],or1,or2,or3,or4,or5);
                customers.add(cus_hold[0]);
            }
            catch(RuntimeException e){
                //System.out.printf("Input error : %-8s %-2s %-3s %-3s %-3s %-3s\n",buf[0],buf[1],buf[2],buf[3],buf[4],buf[5]);
                //System.out.printf("Correction  : %-8s %-2s %-3s %-3s %-3s %-3s\n\n",buf[0],buf[1],buf[2],buf[3],buf[4],buf[5]);
                System.out.printf("ERROR! Input error : %-8s\n",buf[0]);
                e.printStackTrace();
                Thread.sleep(250);
                //System.out.printf("%s\n",e);
                continue;
            }   
        }
                productScan.close();
                orderScan.close();
            
                /*Collections.sort(Countries);

                System.out.printf("Enter file name: %s\n",filename);
                System.out.println("=======================================================================");
                System.out.printf("%47s","All time Olympic medals\n");
                System.out.println("=======================================================================");
                for(int i=0;Countries.size()>i;i++){
                    Countries.get(i).report();
                }*/     
    }  
}
