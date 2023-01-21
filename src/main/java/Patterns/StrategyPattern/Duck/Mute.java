package Patterns.StrategyPattern.Duck;

public class Mute implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("I am on mute ...");
    }
}
