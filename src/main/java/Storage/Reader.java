package Storage;
import com.google.gson.Gson;

public class Reader<T> {
    public Object Understand(String path, T obj) {
        Gson gson = new Gson();
//        return gson.fromJson(path, (T) obj.class);
        return new Object();
    }
}
