import java.util.List;
import java.util.Random;

public class AnimalCategory implements Category {
	private List<String> animalWords;
    private Random random;
    
    public AnimalCategory() {
        WordParser wordParser = new WordParser("animal_words.txt");
        this.animalWords = wordParser.parse();
        this.random = new Random();
    }
    
	@Override
	public String getCategoryName() {
		return "Animal";
	}
	
	@Override
	public String getRandomWord() {
		 if (this.animalWords.isEmpty()) {
	            return "";
	        } else {
	            int randomIndex = this.random.nextInt(this.animalWords.size());
	            return (String)this.animalWords.get(randomIndex);
	        }
	}

}
