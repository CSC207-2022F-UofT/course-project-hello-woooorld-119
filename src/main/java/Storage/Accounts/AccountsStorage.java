package Storage.Accounts;

import Storage.Storage;

public class AccountsStorage extends Storage {
    // the storage class that provides the ability to read and write data from accounts
    public AccountsStorage() {
        super("storage/accounts.txt");
    } //this accesses the accounts.txt file

    @Override
    public void writefile(String text) {
        /**
         * This method writes text to the accounts.txt file
         *
         * @param text a string representing the raw text to write to the file
         * @return void
         */
        super.writefile(text);
    }

    @Override
    public String readfile() {
        /**
         * Returns the string that is read from the accounts.txt file
         *
         * @return string that is the raw text in the file
         */
        return super.readfile();
    }
}
