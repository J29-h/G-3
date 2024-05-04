import java.util.ArrayList;

//Concrete Decorator 
public class HintDecoratorActivate extends HintDecorator {

	public HintDecoratorActivate(Hint decoratedHint) {
		super(decoratedHint);
	}

	@Override
	public String ApplyHint(String word, ArrayList<String> foundLetters) {
		if (ActivateHint()) {
			String hint = super.ApplyHint(word, foundLetters);
			return "Hint: " + hint;
		} else {
			return "";
		}
	}

	// determine if the hint should be activated based on player input
	private boolean ActivateHint() {
		return RequestsHint();
	}

	// determine if the player requests a hint
	private boolean RequestsHint() {
		return true;
	}
}
