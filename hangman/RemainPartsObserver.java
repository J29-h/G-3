public abstract class RemainPartsObserver {
	// make an obj of the subject class in the observer abstract class
	protected GameSubject subject;
    abstract void updateBodyPartsRemaining(int bodyPartsRemaining);
}