package Patterns.StrategyPattern.Duck;

public class Quack implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("I am quacking ...");
    }
}
