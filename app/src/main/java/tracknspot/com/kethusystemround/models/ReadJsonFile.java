package tracknspot.com.kethusystemround.models;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by sriram on 21/11/17.
 */

public class ReadJsonFile {
    public static String ReadFile() {
        String jsonStr = null;
        try {


            File path = new File(Environment.getExternalStorageDirectory(), "/SecondYear.json");
            Log.e("TAG","path "+path);

            FileInputStream stream = new FileInputStream(path);

            try {
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

                jsonStr = Charset.defaultCharset().decode(bb).toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                stream.close();
            }

        } catch (Exception e) {
            Log.e("TAG","Exception"+e.getMessage());
            e.printStackTrace();
            return null;
        }


        return jsonStr;
    }
}