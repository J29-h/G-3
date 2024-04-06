// implementing the Factory design pattern to this class...  
// the ParserFactory is the creator class of the factory design
// pattern. it is responsible for declaring the factory method 
// that will return the new (same type as product interface) 
// product obj

public class ParserFactory {

	public Parser createParser(String fileType) {

		if (fileType.equals(null)) {
			return null;
		}

		if (fileType.equals("./wordlist.txt")) {
			return new WordParser(fileType);
		}
		// When wanting to add new different parser types add more conditions if needed
		return null;
	}
}
