import java.util.ArrayList;
import java.util.List;

public class GameSubject {
	
	//list will be notified of changes in the number of body parts remaining
    private List<RemainPartsObserver> observers = new ArrayList<>();
    private int bodyPartsRemaining;//stores the current number.
    
    //returns the current value of bodyPartsRemaining.
    public int getBodyPartsRemaining() {
        return bodyPartsRemaining;
    }
    //sets the value of bodyPartsRemaining,
    public void setBodyPartsRemaining(int bodyPartsRemaining) {
        this.bodyPartsRemaining = bodyPartsRemaining;
        notifyObservers();
    }

    public void registerObserver(RemainPartsObserver observer) {
        observers.add(observer);
    }
    
    public void notifyObservers() {
        for (RemainPartsObserver observer : observers) {
            observer.updateBodyPartsRemaining(bodyPartsRemaining);
        }
    }
}
