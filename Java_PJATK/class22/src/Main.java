public class Main {
    public static void main(String[] args)
    {
        ListStructure list = new ListStructure();
        list.add(3);
        list.add(5);
        list.add(10);
        list.pushFront(new ListNode(5));
        System.out.println(list.intAt(2));
        System.out.println(list.length());
    }
}

class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    void setNext(ListNode next) {
        this.next = next;
    }

    ListNode getNext() {
        return next;
    }

    int getValue(){
        return value;
    }

    public String toString() {
        return value + "";
    }
}

class ListStructure {

    private ListNode head;

    public void add(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(new ListNode(value));
    }

    public void pushFront(ListNode ln){
        ln.setNext(head);
        head = ln;
    }

    public int intAt(int index){
        int i=1;
        ListNode tail = head;
        while(i!=index){
            tail = tail.getNext();
            i++;
        }
        return tail.getValue();
    }

    public void removeAt(int index){
        int i=1;
        if(head.getNext()==null)
            head=null;
        else {
            ListNode tail = head;
            ListNode beforeTail = head;
            while (i != index) {
                beforeTail = tail;
                tail = tail.getNext();
                i++;
            }
            beforeTail.setNext(tail.getNext());
        }
    }

    public int length(){
        int i=1;
        ListNode tail = head;
        while(tail.getNext()!=null){
            tail = tail.getNext();
            if(tail.getValue()>=0)
                i++;
        }
        return i;
    }

    public void println() {
        ListNode tail = head;
        do {
            System.out.println(tail);
            tail = tail.getNext();
        } while (tail.getNext() != null);
        System.out.println(tail);
    }

}