package Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    void writefile(String text, String file_name) {
        try {
            Files.write(Paths.get(file_name), text.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    String readfile(String file_name) {
        try {
            return Files.readString(Path.of(file_name));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}