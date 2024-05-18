import java.util.ArrayList;

public class AnimalCategory implements Category{
    private String categoryName = "Animal";
    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public ArrayList<String> getRandomWord() {
        ParserFactory parserFactory = new ParserFactory();
        Parser wordParser = parserFactory.createParser("./animal_words.txt");

        wordParser.createFile();
        wordParser.createScanner();

        return wordParser.parse();
}
}
