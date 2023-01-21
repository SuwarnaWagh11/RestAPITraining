package Patterns.StrategyPattern.Duck;

public class MallardDuck extends Duck {
    //QuackBehaviour quackBehaviour;
    public MallardDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a real Mallards duck ...");
    }
}
