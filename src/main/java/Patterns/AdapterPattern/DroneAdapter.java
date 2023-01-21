package Patterns.AdapterPattern;

import Patterns.StrategyPattern.Duck.Duck;

public class DroneAdapter implements Duck1 {
    Drone drone;

    public DroneAdapter(Drone drone){
        this.drone = drone;
    }
    @Override
    public void fly() {
        drone.spin_rotors();
        drone.take_off();
    }

    @Override
    public void quack() {
        drone.beep();
    }
}
