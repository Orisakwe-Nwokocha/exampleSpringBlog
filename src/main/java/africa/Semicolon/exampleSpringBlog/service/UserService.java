package africa.Semicolon.exampleSpringBlog.service;

import africa.Semicolon.exampleSpringBlog.dto.requests.LoginRequest;
import africa.Semicolon.exampleSpringBlog.dto.requests.SignUpRequest;

public interface UserService {
    void registerUser(SignUpRequest signUpRequest);
    void loginUser(LoginRequest loginRequest);
}
