

class SmartDevice (

    val messenger: Messenger, 
    val camera: Camera,
    val musicPlayer: MusicPlayer

): Messenger by messenger, Camera by camera, MusicPlayer by musicPlayer{
    
}