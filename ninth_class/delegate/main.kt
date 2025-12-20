import SmartDevice
import DigitalCamera
import EmailMessenger
import StereoSystem


fun main(args: Array<String>) {
     

    val googlePixel: SmartDevice = SmartDevice(
        camera = DigitalCamera(), 
        messenger = EmailMessenger(), 
        musicPlayer = StereoSystem()
    )

    googlePixel.takePhoto()
    googlePixel.sendMessage(message = "Hello! I'm Ivan")
    googlePixel.playMusic()
}