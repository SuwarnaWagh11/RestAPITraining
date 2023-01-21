package Patterns.StrategyPattern.Duck;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        quackBehaviour = new Mute();
        flyBehaviour = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I made up of wooden so call me Decoy!!");
    }
}
