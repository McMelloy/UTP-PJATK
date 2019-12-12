public class Impl_isGame {
    public static void main(String[] args) {
        IsGame game = new IsGame() {
            public void play(){
                System.out.println("An object of anonymous class");
            }
        };
        game.play();
    }

}