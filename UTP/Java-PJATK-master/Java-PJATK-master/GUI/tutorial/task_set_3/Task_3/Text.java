public interface Text{
    public abstract boolean can_text();
    default void text(){
        System.out.println("Texting");
    }
}