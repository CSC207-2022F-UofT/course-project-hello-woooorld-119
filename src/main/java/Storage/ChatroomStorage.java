package Storage;

public class ChatroomStorage extends Storage {
    @Override
    public void writefile(String text, String file_name) {
        super.writefile(text, "");
    }

    @Override
    public String readfile(String file_name) {
        return null;
    }
}
