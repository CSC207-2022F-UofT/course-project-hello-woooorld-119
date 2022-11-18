package Storage;
//use case layer

public interface AccountsStorageGateway {
    boolean usernameExists(String username);

    void save(String username, String password);
}
