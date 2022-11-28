package Storage.Accounts;

import Storage.Storage;

import java.util.Map;
import java.util.Objects;

import Storage.Reader;

public class AccountsStorageUseCase implements AccountsStorageGateway {
    Storage accountsStorage;
    Reader reader;

    public AccountsStorageUseCase() {
        this.accountsStorage = new AccountsStorage();
        this.reader = new Reader();
    }

    @Override
    public boolean usernameExists(String username) {
        Map<String, String> info = (Map<String, String>) this.reader.Read(accountsStorage.readfile(), Map.class);

        return info.containsKey(username);
    }

    @Override
    public boolean passwordExists(String username, String password) {
        // username must exist
        Map<String, String> info = (Map<String, String>) this.reader.Read(accountsStorage.readfile(), Map.class);
        return Objects.equals(info.get(username), password);
    }

    @Override
    public void save(String username, String password) {
        Map<String, String> map = (Map<String, String>) reader.Read(accountsStorage.readfile(), Map.class);
        map.put(username, password);

        accountsStorage.writefile(reader.ToString(map));
    }
}
