package africa.Semicolon.exampleSpringBlog.service;

import africa.Semicolon.exampleSpringBlog.dto.SignUpRequest;

public interface UserService {
    void registerUser(SignUpRequest signUpRequest);
}
