import it.sauronsoftware.jave.*;
import java.io.DataOutputStream;

public class FFMPEG_extension extends it.sauronsoftware.jave.FFMPEGLocator {

    public java.lang.String getFFMPEGExecutablePath() {
        /*Process process = null;
        DataOutputStream dataOutputStream = null;

        try {
            process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            dataOutputStream.writeBytes("chmod 0755 /usr/local/bin/ffmpeg\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
        } catch (Exception e) {

        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                process.destroy();
            } catch (Exception e) {
            }
        }*/
        return "/usr/local/bin/ffmpeg";
    }
}
