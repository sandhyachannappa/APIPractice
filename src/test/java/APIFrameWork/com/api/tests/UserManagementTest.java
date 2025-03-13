package APIFrameWork.com.api.tests;

import APIFrameWork.com.api.base.UserManagementService;
import APIFrameWork.com.api.model.request.ChangePasswordRequest;
import APIFrameWork.com.api.model.request.ProfileUpdateRequest;
import APIFrameWork.com.api.model.request.UpdateUserRequest;
import APIFrameWork.com.api.model.response.ProfileUpdateResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserManagementTest {
    UserManagementService userProfile = new UserManagementService();
    LoginTest loginTest = new LoginTest();


    @Test(enabled = false, description = "verify get user profile API")
    public void getUserProfile() {
        String token = loginTest.login();
        Response response = userProfile.getProfile(token);
        System.out.println(response.asPrettyString());
    }

    @Test(enabled = false, description = "verify changePassword API")
    public void changePassword() {
        ChangePasswordRequest passwordRequest = new ChangePasswordRequest();
        passwordRequest.setCurrentPassword("Test1234$");
        passwordRequest.setNewPassword("Test1234$");
        passwordRequest.setConfirmPassword("Test1234$");
        String token = loginTest.login();

        Response response = userProfile.changePassword(passwordRequest, token);
        System.out.println(response.asPrettyString());
    }

    @Test(enabled = false, description = "verify update user profile API")
    public void updateUserProfile() {
        ProfileUpdateRequest payload = new ProfileUpdateRequest();
        payload.setFirstName("sandhya85");
        payload.setLastName("srinivas");
        payload.setEmail("sandhya.channappa@gmail.com");
        payload.setMobileNumber("0987654321");
        payload.setAddress("RTNagar");

        String token = loginTest.login();

        Response response = userProfile.profileUpdate(payload, token);
        ProfileUpdateResponse res = response.as(ProfileUpdateResponse.class);
        int id = res.getId();
        System.out.println("User id: " + id);
        Assert.assertEquals(payload.getEmail(), res.getEmail());
    }

    @Test(description = "verify update user  API")
    public void updateUser() {
        UpdateUserRequest payload = new UpdateUserRequest();
        payload.setFirstName("sandhya85");
        payload.setLastName("srinivas01");
        payload.setEmail("sandhya.channappa@gmail.com");
        payload.setMobileNumber("0987654321");

        String token = loginTest.login();

        Response response = userProfile.updateUser(payload, token);
        ProfileUpdateResponse res = response.as(ProfileUpdateResponse.class);
        int id = res.getId();
        System.out.println("User id: " + id);
        Assert.assertEquals(payload.getEmail(), res.getEmail());
    }
}
