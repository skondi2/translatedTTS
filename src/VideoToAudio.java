import it.sauronsoftware.jave.*;

import java.io.File;

public class VideoToAudio {

    public static void ConvertVideo(File video) {

        //System.out.println("Starting conversion");
        // ffmpeg -i /Users/shruthi/IdeaProjects/videoTranslater/src/speech.avi /Users/shruthi/Desktop/Target/audio.wav

        File audio = new File("Audio.wav");
        AudioAttributes audioAttr = new AudioAttributes();
        audioAttr.setCodec("pcm_s16le");
        audioAttr.setBitRate(128000);
        audioAttr.setChannels(2);
        audioAttr.setSamplingRate(44100);

        EncodingAttributes enc = new EncodingAttributes();
        enc.setFormat("wav");
        enc.setAudioAttributes(audioAttr);

        Encoder encode = new Encoder(new FFMPEG_extension());

        try {
            System.out.println(encode.getVideoDecoders());
        } catch(Exception e) {
            System.out.println("info failed :" + e.toString());
        }

        try {
            encode.encode(video, audio, enc);
            System.out.println("Finished conversion !");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
