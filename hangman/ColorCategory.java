import java.util.ArrayList;

public class ColorCategory implements Category {
    private String categoryName = "Color";
    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public ArrayList<String> getRandomWord() {
        ParserFactory parserFactory = new ParserFactory();
        Parser wordParser = parserFactory.createParser("./color_words.txt");

        wordParser.createFile();
        wordParser.createScanner();

        return wordParser.parse();

    }
}
