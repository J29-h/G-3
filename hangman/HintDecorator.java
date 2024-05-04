import java.util.ArrayList;

//Decorator Class
public class HintDecorator implements Hint {// هنا لازم يكون implements Hint

	protected Hint decoratedHint;

	public HintDecorator(Hint decoratedHint) {
		this.decoratedHint = decoratedHint;
	}

	@Override
	public String ApplyHint(String hint, ArrayList<String> foundLetters) {
		return decoratedHint.ApplyHint(hint, foundLetters);
	}
}
