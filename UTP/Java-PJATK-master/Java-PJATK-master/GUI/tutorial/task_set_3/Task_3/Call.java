public interface Call {
    abstract boolean can_call();

    default void call(){
        System.out.println("Calling");
    }
}