package Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    String file_name;

    public Storage(String name) {
        this.file_name = name;
    }
    void writefile(String text) {
        try {
            Files.write(Paths.get(file_name), text.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    String readfile() {
        try {
            return Files.readString(Path.of(file_name));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}