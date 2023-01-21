package Patterns.StrategyPattern.CameraPhoneApp;

public class ShareViaEmail implements ShareBehavior{
    @Override
    public void share() {
        System.out.println("Sharing via email");
    }
}
