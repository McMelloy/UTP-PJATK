import java.util.*;

class StringStack{
    private String[] stack;
    private int index;
    StringStack(int size){
        stack = new String[size];
        index = 0;
    }
    public void push(String s){
        if(index!=stack.length) {
            stack[index] = s;
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
            System.out.print(stack[i]+" ");
        System.out.println();
    }
}

class Browser{
    String name;
    String[] history;
    int current;
    int index;
    Browser(String n){
        name = n;
        history = new String[100];
        index=0;
        System.out.println("Welcome to "+name);
    }
    public void navigateTo(String web){
        if(index!=history.length) {
            history[index] = web;
            current = index;
            index++;
        }
        else
            System.out.println("History is full");
    }
    public void back(){
        if(current!=0) {
            current--;
            history[index] = history[current];
            index++;
        }
        else
            System.out.println("You are already at the bottom of a history");
    }
    public void forward(){
        if (current<index-1){
            current++;
            history[index] = history[current];
            index++;
        }
        else
            System.out.println("You are already at the top of a history");
    }
    public void displayCurrent(){
        System.out.println("You're here -> "+history[current]);
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
        while(input!=-1){
            System.out.println("Input 0 for push, 1 for pop, -1 for print and end");
            input = in.nextInt();
            switch(input){
                case -1:
                    print();
                    break;
                case 1:
                    pop();
                    break;
                case 0:
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
        System.out.println("Task 0");
        StringStack st1 = new StringStack(3);
        st1.pop();
        st1.push("This");
        st1.push("is");
        st1.push("A CHECK");
        st1.push("this shouldn't be displayed");
        st1.print();

        System.out.println("Task 1");
        Browser chrome = new Browser("Chrome");
        chrome.navigateTo("wikipedia");
        chrome.navigateTo("kaboom");
        chrome.navigateTo("deviantart");
        chrome.displayCurrent();
        chrome.back();
        chrome.back();
        chrome.back();
        chrome.displayCurrent();
        chrome.forward();
        chrome.displayCurrent();
        chrome.navigateTo("pewdiepie subscription link ;)");
        chrome.displayCurrent();
        chrome.forward();
        chrome.back();
        chrome.displayCurrent();


        System.out.println("Task 2");
        InteractiveStack st2 = new InteractiveStack(6);
    }
}
