import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Concrete Decorator 
public class HintDefinitionDecorator extends HintDecorator {

	private String definitionFilePath;

    public HintDefinitionDecorator(Hint decoratedHint, String definitionFilePath) {
        super(decoratedHint);
        this.definitionFilePath = definitionFilePath;
    }

    @Override
    public String ApplyHint(String hint, ArrayList<String> foundLetters) {
        String hintWithDefinition = super.ApplyHint(hint, foundLetters);

        // Read word definition from file
        String definition = readHintDefinitionFromFile(hint);

        // Append word definition to the hint string
        hintWithDefinition += " (Definition: " + definition + ")";

        return hintWithDefinition;
    }

	// Helper method to read the hint definition from file
	private String readHintDefinitionFromFile(String word) {
		try {
            File file = new File(definitionFilePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Find the ":" symbol in the line
                int separatorIndex = line.indexOf(":");

                if (separatorIndex != -1) {
                    // Extract the word before the ":" symbol
                    String lineWord = line.substring(0, separatorIndex).trim();

                    // Check if the line contains the desired word
                    if (lineWord.equalsIgnoreCase(word)) {
                        // Extract the definition after the ":" symbol
                        String definition = line.substring(separatorIndex + 1).trim();
                        scanner.close();
                        return definition;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }
}
