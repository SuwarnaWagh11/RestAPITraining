package Patterns.StrategyPattern.CameraPhoneApp;

public class CameraPlusApp extends CameraPhoneApp{
    public CameraPlusApp(){
        editBehaviour = new Edit_CameraPlusApp();
        shareBehavior = new ShareViaEmail();
    }
    @Override
    public void save() {
        System.out.println("Saving photo in CameraPlus App");
    }

    @Override
    public void take() {
        System.out.println("taking photo in CameraPlus App");
    }
}
