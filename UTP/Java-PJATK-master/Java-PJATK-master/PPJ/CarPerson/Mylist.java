// BGU-SingList/MyList.java
 
public class MyList {
    private Node head;

    public MyList() {
        head = null;
    }

    public void addFront(Car a) {
        head = a;
    }

    public void addBack(int data) {
        if (head == null) {
            addFront(data);
            return;
        }
        Node tmp = head;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = new Node(data);
    }
    /*public void showList() {
        System.out.print("[ ");
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("]");
    }*/
    
   
}
