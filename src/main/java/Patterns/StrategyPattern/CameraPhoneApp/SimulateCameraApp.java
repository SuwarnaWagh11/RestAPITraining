package Patterns.StrategyPattern.CameraPhoneApp;

public class SimulateCameraApp {
    public static void main(String[] args) {
        CameraPhoneApp basicCameraApp = new BasicCameraApp();
        basicCameraApp.take();
        basicCameraApp.save();
        basicCameraApp.performEdit();
        basicCameraApp.performShare();

        CameraPhoneApp cameraPlusApp = new CameraPlusApp();
        cameraPlusApp.take();
        cameraPlusApp.save();
        cameraPlusApp.performEdit();
        cameraPlusApp.performShare();
    }
}
