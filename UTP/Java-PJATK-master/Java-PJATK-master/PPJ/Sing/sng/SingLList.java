package sng;
public class SingLList {
    private Node head = null;
    private static class Node{
        private int data;
        private Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public boolean empty(){
        if(head==null){
            return true;
        } return false;
    }
    public void addFront(int d){
        head = new Node(d, head);
    }
    public void addBack(int d){
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node(d, null);
    }
    public static SingLList arrayToList(int [] arr){
        SingLList tmp = new SingLList();
        for (int a = arr.length; a > 0; a--) {
            tmp.addFront(a);
        }
        return tmp;
    }
    public void removeOdd(){
        while(head.data % 2 != 0){
            head = head.next;
        }
        Node tmp = head;
        while(tmp !=null){
            if(tmp.next.data % 2 != 0){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
    }

    public boolean contains(int d){
        Node tmp = head.next;
        while(tmp!=null){
            if(tmp.data == d){
                return true;
            }
            tmp = tmp.next;
        }return false;
    }
    public void showList(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void clear(){
        head = null;
    }
}