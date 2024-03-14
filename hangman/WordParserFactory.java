

// implementing the Factory design pattern to this class... 
// the WordParserFactory is the concrete creator class for 
// the factory design pattern. the class overrides the base  
// factory method to return specific type of product.

public class WordParserFactory implements ParserFactory {

	public Parser createParser(String filePath) {

		if (filePath == null) {
			return null;
		}
		return new WordParser(filePath);
	}

}
