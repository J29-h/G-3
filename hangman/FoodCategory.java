import java.util.List;
import java.util.Random;

public class FoodCategory implements Category {
	 private List<String> foodWords;
	    private Random random;
	    
	    public FoodCategory() {
	    	WordParser wordParser = new WordParser("food_words.txt");
	        this.foodWords = wordParser.parse();
	        this.random = new Random();
	    }
	@Override
	public String getCategoryName() {
		return "Food";
	}
	
	@Override
	public String getRandomWord() {
		if (this.foodWords.isEmpty()) {
            return "";
        } else {
            int randomIndex = this.random.nextInt(this.foodWords.size());
            return (String)this.foodWords.get(randomIndex);
        }
	}
}
