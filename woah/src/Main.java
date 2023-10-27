public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start_game();
        while (game.playing){
            game.guess_letter();
        }
    }
}