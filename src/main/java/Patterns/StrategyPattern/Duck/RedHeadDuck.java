package Patterns.StrategyPattern.Duck;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a real RedHead cute duck ...");
    }
}
