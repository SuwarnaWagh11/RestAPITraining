package Patterns.StrategyPattern.CameraPhoneApp;

public class BasicCameraApp extends CameraPhoneApp{

    public BasicCameraApp(){
        shareBehavior = new ShareViaText();
        editBehaviour = new Edit_BasicCameraApp();
    }
    @Override
    public void save() {
        System.out.println("Saving photo in Basic Camera App");
    }

    @Override
    public void take() {
        System.out.println("taking photo in BasicCamera App");
    }
}
