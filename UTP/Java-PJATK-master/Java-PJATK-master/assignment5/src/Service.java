public class Service implements Runnable {


   public void proceedRequest(int a, int b, Requester requestor, Priority priority, int id) {
       addToResponseQueue(new Response(a, b, requestor, priority,id ), requestor);
   }

   public void addToResponseQueue(Response response, Requester requestor) {
        requestor.queueResponse.add(response);
   }

   public boolean checkIsReqEmpty() {
        return Requester.queueRequest.isEmpty();
   }

    @Override
    public void run() {
       while (true) {
           while (checkIsReqEmpty()){
               try{
                   Thread.sleep(2000);
               } catch(Exception e) {
                   System.out.println(e);
               }
           }

           Request req;
           if ((req = Requester.queueRequest.poll()) != null){
               proceedRequest(req.getValue1(), req.getValue2(), req.requestor, req.getPr(), req.getId());
           }
       }
    }
}
