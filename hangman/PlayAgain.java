// applying singleton design pattern on this class

class PlayAgain {
    private static PlayAgain instance;

    private PlayAgain() {
        // Private constructor to prevent direct instantiation
    }

    public static PlayAgain getInstance() {
        if (instance == null) {
            instance = new PlayAgain();
        }
        return instance;
    }

    public boolean wannaPlay() {
        System.out.println("Do you want to play again? (y/n)");

        LetterInput letterInput = new LetterInput();
        String letter = letterInput.input().toLowerCase();

        return letter.equals("y");
    }
}
