// implement necessary changes based on singleton pattern

import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        Printer printer = Printer.getInstance();
        printer.printTitle();

        System.out.println("Choose a category:");
        System.out.println("1. Food");
        System.out.println("2. Colors");
        System.out.println("3. Animals");
        System.out.println("4. Random");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Category selectedCategory;

        switch (choice) {
            case 1:
                selectedCategory = new FoodCategory();
                break;
            case 2:
                selectedCategory = new ColorCategory();
                break;
            case 3:
                selectedCategory = new AnimalCategory();
                break;
            case 4:
            	selectedCategory = new CompositeCategory("wordlist", List.of(new FoodCategory(), new ColorCategory(), new AnimalCategory()));
            default:
                System.out.println("Invalid choice. Exiting the game.");
                return;
        }
if(choice <4) {
        String categoryFileName = selectedCategory.getCategoryName().toLowerCase() + "_words.txt";
        WordParser wordParser = new WordParser(categoryFileName);
        wordParser.createFile();
        wordParser.createScanner();
        List<String> words = wordParser.parse();}
else {
	 String categoryFileName = selectedCategory.getCategoryName().toLowerCase() + "_words.txt";
     WordParser wordParser = new WordParser(categoryFileName);
     wordParser.createFile();
     wordParser.createScanner();
     List<String> words = wordParser.parse();}

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
