
// implementing the Factory design pattern to this class...  
// the ParserFactory is the creator class of the factory design
// pattern. it is responsible for declaring the factory method 
// that will return the new (same type as product interface) 
// product obj 

public interface ParserFactory {

	  Parser createParser(String filePath);
}
