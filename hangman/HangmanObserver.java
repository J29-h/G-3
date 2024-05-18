public class HangmanObserver extends RemainPartsObserver {

	// create a class constructor for the subject class
	public HangmanObserver(GameSubject subject) {
		this.subject = subject;
//		this.subject.registerObserver(this);
	}

	@Override
	public void updateBodyPartsRemaining(int bodyPartsRemaining) {
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_WHITE = "\u001B[37m";
		// Display the number of body parts remaining to the user
		System.out.print(ANSI_RED + "(・ε・`*) " + ANSI_WHITE);
		System.out.println("Body parts remaining: " + bodyPartsRemaining);
	}
}
