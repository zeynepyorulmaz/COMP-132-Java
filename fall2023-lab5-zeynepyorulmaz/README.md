[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/IyadI0lK)
## IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```

## IMPORTANT NOTE 2: After you complete the PRELAB tasks, do not forget to commit your changes and push them to your repository on GitHub.
-------------------------------------------------------------------------------------------------------------------------------
## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-5 Prelab: Implementing a Smart Home Device Hierarchy #

In this programming lab, your task is to develop a Java-type hierarchy to represent various smart home devices and their functionalities using **inheritance and polymorphism-related concepts**. You will be provided with a main program code SmartHomeTest.java that will be used for testing your implementations. Note that we may use additional test cases during the evaluation. 
You need to create a new package named devices, which contains the outlined types below. Your responsibility is to determine whether each type should be an abstract class, a concrete class, a superclass, a subclass, or an interface.

- `SmartDevice:` It is an abstract class that represents the base entity for smart home devices.
- `InteractiveDevice:` A type of smart device that allows user interaction, e.g., touch or voice commands.
- `SmartLight:` A kind of interactive device.
- `SmartSpeaker:` A kind of interactive device.
- `Operable:` All SmartDevice objects should be operable. They must implement a void operate() method.
- `Configurable:` All InteractiveDevice objects are configurable. They must implement a void configure() method.

Here is the folder structure that you should have when you finish implementing the assignment:  

src\  
- control\  
-- SmartHomeTest.java  
- devices\  
-- SmartDevice.java  
-- InteractiveDevice.java  
-- SmartLight.java  
-- SmartSpeaker.java  
-- Operable.java  
-- Configurable.java  

**Important Note:** For each class implementation, you need to decide which access modifiers should be used for instance variables (e.g., private, protected or public). The fields and methods of these types are described below:

-------------------------------------------------------------------------------------------------------------------------------

#### A `SmartDevice` has the following members:
- A `static` field `deviceCount` of type `int`, initially zero, representing the total number of smart device objects created.
- A field `deviceName` of type `String`, storing the name of the smart device.
- A field `devicePrice` of type `double`, indicating the price of the smart device in USD.
- A field `deviceConnectivity` of type `String`, denoting the connectivity type (e.g., Wi-Fi, Bluetooth).
- A constructor `SmartDevice(String deviceName, double devicePrice)`, which initializes `deviceName` and `devicePrice` with input arguments and increments `deviceCount` by one. **Note:** Ensure proper validation of input values within the constructor. The `devicePrice` cannot be negative, and `deviceName` should not be empty.
- A `static` method `int getDeviceCount()` that returns the `deviceCount`.
- Getter and setter methods for the non-static fields.
- An `abstract` method `void setDeviceConnectivity()` (in addition to the plain setter) that can be implemented differently for various subtypes of `SmartDevices`.
- An `abstract` method `void operate()` that can be implemented differently for different subtypes of SmartDevices.
- An `abstract` method `String toString()` for printing information about the smart device, to be implemented differently for various subtypes of SmartDevices.

-------------------------------------------------------------------------------------------------------------------------------

#### An `InteractiveDevice` has the following members:
- A field `interactionMode` of type `String`, representing the primary interaction method (e.g., voice, touch).
**Note** that `interactionMode` should be valid and not empty.

- A field `configurationStatus` of type `boolean`, indicating whether the device is configured.
**Note** that `configurationStatus` should be initialized as false.

- The methods `void setDeviceConnectivity()`, should be implemented to update the InteractiveDevice’s connectivity.

- A constructor `InteractiveDevice(String deviceName, double devicePrice, String interactionMode)` that checks the input arguments as per the notes above and initializes the object fields with the given parameters. This constructor should also set both the device's connectivity and operation modes.

- Getter methods for the `interactionMode` and `configurationStatus` fields.

- The method `void configure()`. As stated earlier, all `InteractiveDevice` objects are `Configurable`. Hence, the `InteractiveDevice` type should implement its own `configure()` method, which updates the device’s configuration status and prints the name of the configured device. The method first checks if the `interactionMode` is valid and then sets the `configurationStatus` to true. The method then prints the actions taken. Refer to the sample output for detailed behavior of this method.

- The method `void operate()`. As with all `SmartDevice` objects, `InteractiveDevices` are `Operable` and must implement their own operate() method. The method checks the `configurationStatus` before operating. If the device is configured, it operates according to its designated functionality. The method should then print the name of the device and its current status. Refer to the sample output for a detailed understanding of this method’s behavior.

- A `toString()` method that returns information about the InteractiveDevice’s `deviceName`, `price`, `connectivity`,`interaction mode` and `configurationStatus`.

-------------------------------------------------------------------------------------------------------------------------------

#### A `SmartLight` has the following members:
- A `static` field `id` of type `String` with the value designated as `SmartLight`. This field should be initialized once in a way that it cannot be altered.
- A constructor `SmartLight(String deviceName, double devicePrice, String interactionMode)` that initializes necessary fields with the input arguments and increments `lightCount` by one.
- A `static` field `lightCount` of type `int` with an initial value of zero. Keeps track of the total number of `SmartLight` units created.
- A `toString()` method that prints out information about the `SmartLight`, including the `id` field and other inherited information. Refer to the sample output to understand the `SmartLight’s` `toString()` method.

-------------------------------------------------------------------------------------------------------------------------------

#### A `SmartSpeaker` has the following members:
- A `static` field `id` of type `String` with the value designated as `SmartSpeaker`. This field should be initialized once in a way that it cannot be altered.
- A `static` field `speakerCount` of type `int` with an initial value of zero. Tracks the total number of `SmartSpeaker` units created.
- A constructor `SmartSpeaker(String deviceName, double devicePrice, String interactionMode)` that initializes necessary fields with the input arguments and increments `speakerCount` by one.
- A `toString()` method that prints out information about the `SmartSpeaker`, including the `id` field and other inherited information. Refer to the sample output for a detailed view of the `SmartSpeaker’s` `toString()` method.

```
------------------------------------------- Sample Output ---------------------------------------

Initial Smart Device Count: 0

Smart Device Count after Creation: 4
Number of SmartLights: 2
Number of SmartSpeakers: 2

Testing Device: Philips Hue
SmartLight [ID= SmartLight, InteractiveDevice{ deviceName= 'Philips Hue', devicePrice=50.0, deviceConnectivity='null', interactionMode='Voice', configurationStatus=false}]
Philips Hue failed to operate, requires configuration.
Philips Hue is configured
Philips Hue operated in Voice mode.

Testing Device: Amazon Echo
SmartSpeaker [ID=SmartSpeaker, InteractiveDevice{ deviceName= 'Amazon Echo', devicePrice=100.0, deviceConnectivity='null', interactionMode='Voice', configurationStatus=false}]
Amazon Echo failed to operate, requires configuration.
Amazon Echo is configured
Amazon Echo operated in Voice mode.

Testing Device: Xiaomi Yeelight
SmartLight [ID= SmartLight, InteractiveDevice{ deviceName= 'Xiaomi Yeelight', devicePrice=40.0, deviceConnectivity='null', interactionMode='Touch', configurationStatus=false}]
Xiaomi Yeelight failed to operate, requires configuration.
Xiaomi Yeelight is configured
Xiaomi Yeelight operated in Touch mode.

Testing Device: Google Home
SmartSpeaker [ID=SmartSpeaker, InteractiveDevice{ deviceName= 'Google Home', devicePrice=120.0, deviceConnectivity='null', interactionMode='Voice', configurationStatus=false}]
Google Home failed to operate, requires configuration.
Google Home is configured
Google Home operated in Voice mode.

Configuring and Operating: Philips Hue
Philips Hue is configured
Philips Hue operated in Voice mode.

Configuring and Operating: Google Home
Google Home is configured
Google Home operated in Voice mode.
-----------------------------------------------------------------------------------------------------
```
