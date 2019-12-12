public class SingLList {
    private Node head = null;

    public static class Node {
        private int data;
        Node next;
        public Node(int d, Node h){
            data = d;
            next = h;
        }
        
    }
    public void addFront(int d){
        head = new Node(d, head);
    }

    public void addBack(int d){
        if (head == null) {
            addFront(d);
        }else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node(d, null);
        }        
           
        
    }

    public static SingLList arrayToList(int[] arr) {
        SingLList sing = new SingLList();
        for (int i = 0; i < arr.length; i++) {
            sing.addBack(arr[i]);
        }
        return sing;
    }

    public void removeOdd() {
        while(head.data % 2 != 0){
            head = head.next;
        }
        Node curr = head;
        while (curr.next != null){
            if (curr.next.data % 2 != 0){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
    }

    public boolean empty(){
       return head == null;
        
    }

    public void showList(){
        if (head == null){
            System.out.println("Empty list");
        }else {
            Node a = head;
            while(a!=null){
                System.out.print(a.data+" ");
                a = a.next;
            }
            System.out.println();
        }
        
    }

    public boolean contains(int d) {
        boolean con = false;
        Node a = head;
        while(a!=null){
            if(a.data == d){
                con = true;
            }
            a = a.next;
        }
            System.out.println();
            return con;
        }
    

    public void clear() {
        head = null;
    }
}