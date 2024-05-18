import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hangman {

	public static void main(String[] args) {
		Printer printer = Printer.getInstance();
		printer.printTitle();

		//instance of the GameSubject class for notifying observers.
        GameSubject gameSubject = new GameSubject();

        //instance of the HangmanObserver will receive notifications from the GameSubject.
        HangmanObserver observer = new HangmanObserver(gameSubject);
        
        //adds the observer to the list of observers maintained by the gameSubject.
        gameSubject.registerObserver(observer);
		
		
		ParserFactory parserFactory = new ParserFactory();
		/*Parser wordParser = parserFactory.createParser("./wordlist.txt");
		wordParser.createFile();
		wordParser.createScanner();
		ArrayList<String> words = wordParser.parse();*/

//	   	 Print word for testing
//		 System.out.println(word);

		printer.printEmptyLine();
		
		ArrayList<String> words = chooseCategory();

		int winningStreak = 0;

		do {

			// Ensure that the words list is not empty before picking a word
			if (words.isEmpty()) {
				System.out.println("No words available. Exiting the game.");
				return;
			}
			// If the list is not empty, proceed to pick a word
			WordPicker wordPicker = new WordPicker(words);
			String word = wordPicker.pick();
			
			/*instance of the Game class
			 * passing the word and gameSubject as parameters to the constructor
			 * Instantiate the Game object with the picked word and gameSubject*/
			Game game = new Game(word, gameSubject);

			Hint decoratedHint = new HintDecoratorActivate(new HintLetter());
			Hint hintWithDefinition = new HintDefinitionDecorator(decoratedHint, "definition.txt");
			game.setHint(hintWithDefinition);
			
			// Set up the game context and initial state
			Context context = new Context();
			StopPlayingState Stop = new StopPlayingState();
			
			if (context.getState() instanceof StopPlayingState) {
				printer.print("Game stopped.");
				Stop.doAction(context);
			}
			
			if (game.play() == true) {
				winningStreak += 1;
				printer.print("Winning streak: " + winningStreak);
			} else {
				winningStreak = 0;
			}

		} while (PlayAgain.getInstance().wannaPlay() == true); // the only change to implement singleton pattern

		printer.print("Thanks for playing!");

	}
	//methods for choosing the category (composite design pattern)
	public static ArrayList<String> chooseCategory(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words;

        while(true){

        System.out.println("Welcome!");
        System.out.println("------------------------------------");
        System.out.println("Please choose a category: ");
        System.out.println("1. Animals");
        System.out.println("2. Colors");
        System.out.println("3. Food");
        System.out.println("4. Random");
        System.out.println("------------------------------------");

        int choice = sc.nextInt();

        if (choice==1) {
            words = createAnimalCategory();
            return words;
        }
        else if (choice==2) {
            words = createColorCategory();
            return words;
        }
        else if (choice==3) {
            words = createFoodCategory();
            return words;
        }
        else if (choice==4) {
            words = createCompositeCategory();
            return words;
        }
        else {
            System.out.println("Choose a correct number!!");
        }
        }
    }

    public static ArrayList<String> createAnimalCategory(){
        Category animal = new AnimalCategory();
        return animal.getRandomWord();
    }

    public static ArrayList<String> createFoodCategory(){
        Category food = new FoodCategory();
        return food.getRandomWord();
    }

    public static ArrayList<String> createColorCategory(){
        Category color = new ColorCategory();
        return color.getRandomWord();
    }
    public static ArrayList<String> createCompositeCategory(){
        CompositeCategory composite = new CompositeCategory();
        Category food = new FoodCategory();
        Category animal = new AnimalCategory();
        Category color = new ColorCategory();
        
        composite.addCategory(food);
        composite.addCategory(color);
        composite.addCategory(animal);
        
        return composite.getRandomWord();
    }

}
