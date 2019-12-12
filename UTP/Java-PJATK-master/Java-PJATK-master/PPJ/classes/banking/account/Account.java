package account; 
import customer.*;
import person.*;
public class Account{
    private double balance = 0; 
    private Person a;
    private static double interest;
    public Account(Person a){
        this.a = a;
    }

    public double getBalance(){
        return balance;
    }

    public double deposit(double d){
        return balance += d;
    }

    public double withdraw(double d){
        return  balance -= d;
    }

    public void transfer( Account a, double d){
        a.deposit(d);
        withdraw(d);
    }
    
    public static void setInterestRate(double b){
        interest = b;
    }



    public void addInterest(){
       deposit(balance * interest);
    }
}