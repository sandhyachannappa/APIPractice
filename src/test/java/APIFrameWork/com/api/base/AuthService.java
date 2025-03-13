package APIFrameWork.com.api.base;

import APIFrameWork.com.api.model.request.LoginRequest;
import APIFrameWork.com.api.model.request.SignupRequest;
import io.restassured.response.Response;

public class AuthService extends BaseService {
    String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload) {
        return postRequest(payload, BASE_PATH + "login");
    }

    public Response signUp(SignupRequest payload) {
        return postRequest(payload, BASE_PATH + "signup");
    }
}
