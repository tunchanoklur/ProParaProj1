package proparaproj1;

class userEmptyException extends Exception{
    public userEmptyException(){
        System.out.println("Customer's order is empty, cannot be rollback\n");
    }
}

class userException extends Exception{
    public userException(String message){
        System.out.println(message);
    }
}
