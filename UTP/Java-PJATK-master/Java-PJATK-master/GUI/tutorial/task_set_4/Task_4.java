//Account
public class Task_4{
    public static void main(String[] args) {
        Account acc1 = new Account(10000);
        Account acc2 = new Account(10000);
        System.out.println("sum1 " + (acc1.balance + acc2.balance));

        MyThread[] arr = {
            new MyThread(acc1, acc2),
            new MyThread(acc1, acc2),
            new MyThread(acc1, acc2),
            new MyThread(acc2, acc1),
            new MyThread(acc1, acc2),
            new MyThread(acc2, acc1),
            new MyThread(acc1, acc2),
            new MyThread(acc2, acc1)
        };

        for(int i = 0; i < arr.length; i++) {
            arr[i].start();
            System.out.println(acc1.balance+ " " + acc2.balance);
        }
        
        System.out.println("sum1 " + (acc1.balance + acc2.balance));        
    }
}

class Account{ 
    public long balance;
    public Account(long b){
        balance = b;
    }
}

class MyThread extends Thread{
    public Account a;
    public Account b;

    public MyThread(Account a, Account b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        long ammount = (long)(Math.random()*100 + 1);
        a.balance +=ammount;
        b.balance -=ammount;
    }
}





