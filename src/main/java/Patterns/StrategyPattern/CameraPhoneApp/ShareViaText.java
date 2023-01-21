package Patterns.StrategyPattern.CameraPhoneApp;

public class ShareViaText implements ShareBehavior{
    @Override
    public void share() {
        System.out.println("Sharing via text");
    }
}
