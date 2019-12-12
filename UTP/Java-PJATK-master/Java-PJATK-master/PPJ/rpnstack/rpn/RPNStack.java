package rpn;
public class RPNStack {
    private Node top = null;

    /*public RPNStack(Node top) {
        this.top = top;
    }*/
    public Node getTop(){
        return top;
    }
    public void setTop(){
        top = null;
    }
    public void push(double d) {
        top = new Node(d, top);
    }

    public double pop(){
        double d = top.getVal();
        top = top.getNext();
        return d;
    }

    public boolean empty() {
        return top == null;
    }

}

