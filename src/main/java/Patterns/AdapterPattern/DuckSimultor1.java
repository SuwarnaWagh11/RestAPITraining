package Patterns.AdapterPattern;

public class DuckSimultor1 {
    public static void main(String[] args) {
        Drone sd = new SuperDrone();
        Duck1 s = new DroneAdapter(sd);
        testDuck(s);
    }

    private static void testDuck(Duck1 s) {
        s.fly();
        s.quack();
    }
}
