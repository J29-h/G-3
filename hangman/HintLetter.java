import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Concrete Component
public class HintLetter implements Hint {

	@Override
	public String ApplyHint(String hint, ArrayList<String> foundLetters) {
        StringBuilder hintBuilder = new StringBuilder();
        List<Character> hiddenLetters = new ArrayList<>();

        for (char c : hint.toCharArray()) {
            String letter = Character.toString(c);

            if (foundLetters.contains(letter)) {
                hintBuilder.append(letter);
            } else {
                hintBuilder.append("_");
                hiddenLetters.add(c);
            }
        }

        Random random = new Random();
        if (!hiddenLetters.isEmpty()) {
            char randomLetter = hiddenLetters.get(random.nextInt(hiddenLetters.size()));
            hintBuilder.setCharAt(hiddenLetters.indexOf(randomLetter), randomLetter);
        }

        return hintBuilder.toString();
    }

}
