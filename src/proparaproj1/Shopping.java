package proparaproj1;

import java.io.*;
import java.util.*;

public class Shopping {
    public static void main(String[] args) throws InterruptedException {
        Scanner productScan = null,orderScan = null,get_user;
        String productfile,orderfile,line;
        String[] buf;
        boolean filenotfound = true;
        ArrayList<Customer> customers=new ArrayList<Customer>();
        Product[] products=new Product[5];
        Customer[] cus_hold = new Customer[1];
        int usr_choice;
        //get product file
        do{
            try{
                // get file name from user
                System.out.printf("Enter product name:"); get_user =new Scanner(System.in);
                productfile = get_user.next(); 
                productScan  = new Scanner(new File(productfile));
                filenotfound = false;
            }
            catch (FileNotFoundException e){
                // print exception message    
                System.err.printf("%s\n",e);
                Thread.sleep(100);
                filenotfound = true;
            }
        }while(filenotfound);
        //get order file
        do{
            try{
                System.out.printf("Enter order name:"); get_user =new Scanner(System.in);
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
        //get product info
        int k=0;
        while (productScan!=null && productScan.hasNext()){
            line = productScan.nextLine();
            buf = line.split("\\s+");
            int price = Integer.parseInt(buf[1]);
            products[k] = new Product(buf[0],price);
            k++;
        }
        //get order info + calculate each bill + set total sales
        int j=0;
        int l=0;
        while (orderScan!=null && orderScan.hasNext()){
            line = orderScan.nextLine();
            buf = line.split("\\s+");
            boolean fixed=false;
            int[] order_in = new int[5];
            for(l=0;l<5;l++){
                try{
                    order_in[l]=Integer.parseInt(buf[l+1]);
                    if(order_in[l]<0){
                        throw new NumberFormatException();
                    }
                }
                catch(NumberFormatException e){
                    fixed=true;
                    order_in[l]=0;
                }
                catch(ArrayIndexOutOfBoundsException e){
                    fixed=true;
                    //printFileError(buf);
                    for(int b=l;b<5;b++)order_in[b]=0;
                    break;
                }
            }
            cus_hold[0] = new Customer(buf[0],order_in);
            customers.add(cus_hold[0]);
            if(fixed == true){
                printFileError(buf);
                customers.get(j).printcorrection();
            }
            customers.get(j).calculateBill(products);
            j++;
        }
                if(productScan!=null)productScan.close();
                if(orderScan!=null)orderScan.close();
        //ask user to rollback or commit
        do{
            usr_choice=1;
            try{
                printcustomer(customers);
                System.out.printf("\nEnter 0 to commit OR -n to rollback n transactions :"); get_user =new Scanner(System.in);
                usr_choice = get_user.nextInt();
                get_user.nextLine(); //read left over /r
                int loop = usr_choice*(-1);
                
                //if user roll back more than existing or the 
                if(customers.isEmpty())throw new userEmptyException();
                else if(loop>customers.size())throw new userException("Rollback exceeds available order! please try again");
                else if(usr_choice>0)throw new userException("Incorrect input! please try again");
                
                for(int i=0;i<loop;i++)
                    customers.remove(customers.size()-1);
            }
            catch(userEmptyException e){
                break;
            }
            catch(userException e){
                continue;
            }
            catch(Exception e){
                System.out.println("Wrong input type! please try again");
                continue;
            }
        }while(usr_choice!=0);
        
        for(int i=0;i<customers.size();i++){
            for(int a=0;a<5;a++)
                products[a].setTotalSales(customers.get(i).orders[a]);
        }
        Arrays.sort(products);    
        Collections.sort(customers);
                System.out.printf("\nProducts Summary");
                printproduct(products);
                System.out.printf("\nCustomers Summary");
                printcustomer(customers);        
    }
    static void printproduct(Product[] products){
        System.out.printf("\n");
        for(int i=0;products.length>i;i++)
            products[i].print();
    }
    static void printcustomer(ArrayList<Customer> customers){
        System.out.printf("\n");
        for(int i=0;customers.size()>i;i++){
            customers.get(i).print();
        }
    }
    static void printFileError(String[] buf){
        System.out.printf("Input error : %-8s",buf[0]);
                for(int i=1;i<buf.length;i++)
                    System.out.printf(" %-3s",buf[i]);
                System.out.printf("\n");
    }
}
