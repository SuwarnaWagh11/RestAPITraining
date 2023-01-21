package Patterns.StrategyPattern.CameraPhoneApp;

public abstract class CameraPhoneApp {
    ShareBehavior shareBehavior;
    EditBehaviour editBehaviour;

    public void performEdit(){
        editBehaviour.edit();
    }
    public void performShare(){
        shareBehavior.share();
    }
    abstract public void save();
    abstract public void take();
}
