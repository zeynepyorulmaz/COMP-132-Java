package control;
import devices.*;

public class SmartHomeTest {
	/* *********** Pledge of Honor ************************************************ *

	I hereby certify that I have completed this lab assignment on my own
	without any help from anyone else. I understand that the only sources of authorized
	information in this lab assignment are (1) the course textbook, (2) the
	materials posted at the course website and (3) any study notes handwritten by myself.
	I have not used, accessed or received any information from any other unauthorized
	source in taking this lab assignment. The effort in the assignment thus belongs
	completely to me.
	READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
	SIGNATURE: <Zeynep Yorulmaz, 83684>
	********************************************************************************/
    public static void main(String[] args) {
        // Initial Counts
        System.out.println("Initial Smart Device Count: " + SmartDevice.getDeviceCount());

        // Creating Smart Devices
        SmartLight light1 = new SmartLight("Philips Hue", 50, "Voice");
        SmartSpeaker speaker1 = new SmartSpeaker("Amazon Echo", 100, "Voice");
        SmartLight light2 = new SmartLight("Xiaomi Yeelight", 40, "Touch");
        SmartSpeaker speaker2 = new SmartSpeaker("Google Home", 120, "Voice");

        // Counts after Creation
        System.out.println("\nSmart Device Count after Creation: " + SmartDevice.getDeviceCount());
        System.out.println("Number of SmartLights: " + SmartLight.getLightCount());
        System.out.println("Number of SmartSpeakers: " + SmartSpeaker.getSpeakerCount());

        // Testing each device's functionalities
        testDevice(light1);
        testDevice(speaker1);
        testDevice(light2);
        testDevice(speaker2);

        configureAndOperateDevice(light1);
        configureAndOperateDevice(speaker2);
        SmartCleaner cleaner = new SmartCleaner("Xiomi Vacoom Mop", 120, "Voice");
        cleaner.automate(2);
        cleaner.automate(4);
        testDevice(cleaner);
        configureAndOperateDevice(cleaner);

    }
    

    private static void testDevice(InteractiveDevice device) {
        System.out.println("\nTesting Device: " + device.getDeviceName());
        System.out.println(device);
        device.operate();
        device.configure();
        device.operate();
    }

    private static void configureAndOperateDevice(InteractiveDevice device) {
        System.out.println("\nConfiguring and Operating: " + device.getDeviceName());
        device.configure();
        device.operate();
    }
}

