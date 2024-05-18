import java.util.ArrayList;

public class FoodCategory implements Category {
    private String categoryName="Food";
    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public ArrayList<String> getRandomWord() {
        ParserFactory parserFactory = new ParserFactory();
        Parser wordParser = parserFactory.createParser("./food_words.txt");

        wordParser.createFile();
        wordParser.createScanner();

        return wordParser.parse();
    }
}
