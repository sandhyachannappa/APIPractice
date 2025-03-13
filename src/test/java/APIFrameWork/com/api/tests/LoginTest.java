package APIFrameWork.com.api.tests;

import APIFrameWork.com.api.base.AuthService;
import APIFrameWork.com.api.model.request.LoginRequest;
import APIFrameWork.com.api.model.request.SignupRequest;
import APIFrameWork.com.api.model.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    AuthService authService = new AuthService();
    String token;

    @Test(priority=1,enabled = true, description = "verify if Login API is working ")
    public String login() {
        LoginRequest login_payload = new LoginRequest();
        login_payload.setUsername("sandhya85");
        login_payload.setPassword("Test1234$");
        LoginResponse loginRes = authService.login(login_payload).as(LoginResponse.class);
        token = loginRes.getToken();
        System.out.println("Token:" + token);
        Assert.assertNotNull(token);
        return token;
    }

    @Test(priority = 2,enabled = true, description = "verify if SignUp API is working ")
    public void signUp() {
        SignupRequest payload = new SignupRequest();
        payload.setUsername("nishchal02");
        payload.setPassword("Password@1");
        payload.setEmail("c.sandhyac2@gmail.com");
        payload.setFirstName("nishchal");
        payload.setLastName("srinivas");
        payload.setMobileNumber("1234567890");
        Response res= authService.signUp(payload);
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.asPrettyString(),"User registered successfully!");
    }
}
