
import java.util.List;
import java.util.Random;
public class ColorCategory implements Category {
	 private List<String> colorWords;
	 private Random random;
	 
	 public ColorCategory() {
		 WordParser wordParser = new WordParser("color_words.txt");
	        this.colorWords = wordParser.parse();
	        this.random = new Random();
	 }
	@Override
	public String getCategoryName() {
		return "Colors";
	}
	
	@Override
	public String getRandomWord() {
		 if (this.colorWords.isEmpty()) {
	            return "";
	        } else {
	            int randomIndex = this.random.nextInt(this.colorWords.size());
	            return (String)this.colorWords.get(randomIndex);
	        }
	}

}
