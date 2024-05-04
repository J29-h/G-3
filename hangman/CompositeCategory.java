import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeCategory implements Category{
	
	String categoryName;
	private List<Category> categories;
	
	public CompositeCategory(String categoryName, List<Category> categories) {
		this.categoryName=categoryName;
		this.categories = categories;
	}
	
	@Override
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@Override
	public String getRandomWord() {
		 StringBuilder sb = new StringBuilder();
	        Iterator var3 = this.categories.iterator();

	        while(var3.hasNext()) {
	            Category category = (Category)var3.next();
	            sb.append(category.getRandomWord());
	        }

	        return sb.toString();
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
	}
}
