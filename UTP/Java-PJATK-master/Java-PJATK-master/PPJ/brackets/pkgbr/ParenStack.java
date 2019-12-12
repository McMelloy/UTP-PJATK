package pkgbr;
public class ParenStack {
    private Node top;

    public void push(char p){
        top = new Node(p, top);
    }

    public char pop(){
        char tmp = top.getData();
        top = top.getNext();
        return tmp;
    }

    public boolean empty(){
        if(top==null){
            return true;
        }
        return false;
    }
}