package tutorial;
import tutorial.User;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

/*
 * This UseCase class is responsible for storing all the data from the user regarding the login information.
 * Responsible for user creation.
 * Checks whether a user already exists in the system.
 * Modifies the user list by adding or removing existing users.
 */
public class LoginUseCase {
    private ArrayList<User> users = new ArrayList<>();

    public LoginUseCase(HashMap<String, String> userdata, HashMap<String, ArrayList<Timestamp>> userLoginTracker){
        for (String username: userdata.keySet()){
            String password = userdata.get(username);
            ArrayList<Timestamp> loginTracker = userLoginTracker.get(username);
            User user = new User(username, password, loginTracker);
            users.add(user);
        }
    }
/*
 * Getter and setter methods for the users list.
 * The getter method returns a list of users.
 * The setter method sets up the user list and returns null.
 */

    protected void setUsers(ArrayList<User> users){
        this.users = users;
    }

    protected ArrayList<User> getUsers(){
        return users;
    }

/*
 * Checks whether the current user exists with the given username and password.
 * @param username
 * @param password
 * @return a dictionary of weather a user exists
 */
    public HashMap<String, Boolean> checkUser(String username, String password){
        HashMap<String, Boolean> output = new HashMap<>();
        output.put("Valid", false);

        for (User user: users){
            if ((Objects.equals(username, user.getUsername())) && (Objects.equals(user.getPassword(), password))){
                output.replace("Valid", true);
                updateLoginData(user);
            }
        }
    return output;
    }
// Method to update the login data.

    private void updateLoginData(User user){
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        user.updateLoginTracker(time);
    }

//Locates the user given the username

    public User locateUser(String username){
        for (User user: users){
            if (Objects.equals(user.getUsername(), username)){
                return user;
            }
        }
        return null;
    }

//Checks if the user with the given username exists.

    public boolean valid(String username){
        for (User user: users){
            if (Objects.equals(user.getUsername(), username)){
                return true;
            }
        }
        return false;
    }

//Initiates a new user with the given username and password.

    public void createUser(String username, String password){
        User newUser = new User(username, password);
        updateLoginData(newUser);
        users.add(newUser);
    }

// Deletes the user with given username from users.

    public boolean remove(String username){
        if (this.valid(username)){
            users.remove(this.locateUser(username));
            return true;
        }
        return false;
    }

// Returns the private information of users.

    public HashMap<String, String> UserInfo(){
        HashMap<String, String> dataOfUsers = new HashMap<>();
        for (User user: getUsers()){
            String username = user.getUsername();
            String password = user.getPassword();
            dataOfUsers.put(username, password);

        }
        return dataOfUsers;
    }

// Returns the Login Tracker for each user.

    public HashMap<String, ArrayList<Timestamp>> usersLoginTracker(){
        HashMap<String, ArrayList<Timestamp>> loginMap = new HashMap<>();
        for (User user: users){
            loginMap.put(user.getUsername(), user.getLoginTracker());
        }
        return loginMap;
    }

    public ArrayList<String> getLoginHistory(String username){
        User user = locateUser(username);
        ArrayList<Timestamp> historyLogin = user.getLoginTracker();
        ArrayList<String> stringHistoryLogin = new ArrayList<>();
        for (Timestamp time: historyLogin){
            String timestamp = time.toString();
            stringHistoryLogin.add(timestamp);
        }
        return stringHistoryLogin;
    }
}
