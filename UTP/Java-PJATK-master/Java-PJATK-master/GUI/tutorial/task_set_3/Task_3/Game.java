public interface Game{
    abstract boolean can_play();
    default void games() {
        System.out.println("Playing");
    };
}