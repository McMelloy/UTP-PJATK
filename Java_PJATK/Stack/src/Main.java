class IntegerStack{
    private int[] stack;
    private int index;
    IntegerStack(int size){
        stack = new int[size];
        index = 0;
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
        IntegerStack st = new IntegerStack(4);
        st.pop();
        st.push(1);
        st.print();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.print();
        st.pop();
        st.print();
    }
}
