import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CompositeCategory implements Category {
    private String categoryName= "Random";
    private List<Category> categories;

    public CompositeCategory(){
        this.categories= new ArrayList<>();
    }

    public void addCategory (Category category){
    categories.add(category);
    }

    public void removeCategory (Category category){
    categories.remove(category);
    }
    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public ArrayList<String> getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(categories.size());
        Category randomCategory = categories.get(index);
        return randomCategory.getRandomWord();
    }
}

