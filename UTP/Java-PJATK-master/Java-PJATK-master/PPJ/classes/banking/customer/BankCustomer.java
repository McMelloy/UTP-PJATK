package customer;
import person.*;
import account.*;
public class BankCustomer{
    private Person a;
    private Account b;
    public BankCustomer(Person a){
        this.a = a;
        this.b = new Account(a);
    }
    
    public Account getAccount(){
        return b;
    }
    @Override
    public String toString() {
        return "Customer: " + a.getName() + ", balance: " +  b.getBalance();
    }
}