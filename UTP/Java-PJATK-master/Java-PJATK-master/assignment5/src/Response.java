public class Response extends Message {

    public int result;
    public Priority pr;

    public Response(int a, int b, Requester requester, Priority pr, int id) {
        super(requester);
        this.pr = pr;
        result = addTwoNumbers(a,b);
        System.out.println("Result " + result + " ID "+ id);
    }

    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public Priority getPr(){
        return pr;
    }
}
