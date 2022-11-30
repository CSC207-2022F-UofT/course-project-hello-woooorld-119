import Login.LoginUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tutorial.HelloWorld;

public class LoginTest {
    @Test
    void LoginUser() {
        LoginUseCase sam = new LoginUseCase("evan", "chan");
        boolean check = sam.checkUser("evan", "chan");
        Assertions.assertEquals(false, sam.checkUser("evan", "chan"));
    }
}
