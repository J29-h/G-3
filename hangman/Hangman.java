// implement necessary changes based on singleton pattern

import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        Printer printer = Printer.getInstance();
        printer.printTitle();

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        // Print word for testing
        // System.out.println(word);

        printer.printEmptyLine();

        int winningStreak = 0;

        do {

            WordPicker wordPicker = new WordPicker(words);
            String word = wordPicker.pick();
            Game game = new Game(word);
            
            Hint decoratedHint = new HintDecoratorActivate(new HintLetter());
			Hint hintWithDefinition = new HintDefinitionDecorator(decoratedHint, "definition.txt");
			game.setHint(hintWithDefinition);
			// Set the decorated hint as the hint for the game
			game.setHint(hintWithDefinition);
            if (game.play() == true) {
                winningStreak += 1;
                printer.print("Winning streak: " + winningStreak);
            } else {
                winningStreak = 0;
            }

        } while (PlayAgain.getInstance().wannaPlay() == true); //the only change to implement singleton pattern 

        printer.print("Thanks for playing!");
        
    }

}
