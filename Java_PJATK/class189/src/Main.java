import java.util.*;
class Person{
    String name;
    Person(String n){
        name = n;
    }

}
class PersonStack{
    private Person[] stack;
    private int index;
    PersonStack(int size){
        stack = new Person[size];
        index = 0;
    }
    public void push(String s){
        if(index!=stack.length) {
            stack[index] = new Person(s);
            index++;
        }
        else
            System.out.println("Stack is full");
    }
    public void pop(){
        if(index!=0) {
            index--;
            stack[index] = null;
        }
        else
            System.out.println("Stack is empty");
    }
    public void print(){
        for(int i=0;i<index;i++)
            System.out.print(stack[i].name+" ");
        System.out.println();
    }
}

class StackNumber{
    private int[] stack;
    private int index;
    private int number;
    StackNumber(){
        stack = new int[6];
        index = 0;
        number = 0;
    }
    StackNumber(int size){
        stack = new int[size];
        index = 0;
        number = 0;
    }
    public void push(int n){
        if(index!=stack.length) {
            stack[index] = n;
            index++;
            countNumber();
        }
        else
            System.out.println("Stack is full");
    }
    public void pop(){
        if(index!=0) {
            index--;
            stack[index] = 0;
            countNumber();
        }
        else
            System.out.println("Stack is empty");
    }
    public void countNumber(){
        int count=index-1;
        int i=0;
        number = 0;
        while(count >= 0){
            number+=(stack[i++]*(int)Math.pow(10,count--));
        }
    }
    public void print(){
        System.out.println(number);
    }
}
class InteractiveStack{
    private int[] stack;
    private int index;
    InteractiveStack(int size){
        stack = new int[size];
        index = 0;
        start();
    }
    public void start(){
        Scanner in = new Scanner(System.in);
        int input=0;
        while(input!=1){
            System.out.println("Input -1 for push, 0 for pop, 1 for print and end");
            input = in.nextInt();
            switch(input){
                case 1:
                    print();
                    break;
                case 0:
                    pop();
                    break;
                case -1:
                    System.out.println("Input number");
                    push(in.nextInt());
                    break;
            }
        }
    }
    public void push(int n){
        if(index!=stack.length) {
            stack[index] = n;
            index++;
        }
        else
            System.out.println("Stack is full");
    }
    public void pop(){
        if(index!=0) {
            index--;
            stack[index] = 0;
        }
        else
            System.out.println("Stack is empty");
    }
    public void print(){
        for(int i=0;i<index;i++)
            System.out.print(stack[i]+" ");
        System.out.println();
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here
        InteractiveStack st = new InteractiveStack(3);
        /*st.push(1);
        st.push(2);
        st.push(3);
        st.countNumber();
        st.print();*/
    }
}
