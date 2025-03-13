package APIFrameWork.com.api.base;

import APIFrameWork.com.api.model.request.ChangePasswordRequest;
import APIFrameWork.com.api.model.request.ProfileUpdateRequest;
import APIFrameWork.com.api.model.request.UpdateUserRequest;
import io.restassured.response.Response;

public class UserManagementService extends BaseService {
    private static String BASE_PATH = "/api/users/";

    public Response getProfile(String token) {
        setAuthToken(token);
        return getRequest(BASE_PATH + "profile");
    }

    public Response changePassword(ChangePasswordRequest payload,String token) {
        setAuthToken(token);
        return putRequest(payload,BASE_PATH + "change-password");
    }

    public Response profileUpdate(ProfileUpdateRequest payload, String token) {
        setAuthToken(token);
        return patchRequest(payload,BASE_PATH + "profile");
    }

    public Response updateUser(UpdateUserRequest payload, String token) {
        setAuthToken(token);
        return putRequest(payload,BASE_PATH + "profile");
    }

}
