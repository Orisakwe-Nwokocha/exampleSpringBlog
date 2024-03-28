package africa.Semicolon.exampleSpringBlog.service;

import africa.Semicolon.exampleSpringBlog.dto.requests.LoginRequest;
import africa.Semicolon.exampleSpringBlog.dto.requests.SignUpRequest;
import africa.Semicolon.exampleSpringBlog.entity.Role;
import africa.Semicolon.exampleSpringBlog.entity.User;
import africa.Semicolon.exampleSpringBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    @Override
    public void loginUser(LoginRequest loginRequest) {
        User foundUser = userRepository.findByEmail(loginRequest.getEmail());
        if (foundUser == null) throw new  IllegalArgumentException("User not found");
        validate(loginRequest.getPassword(), foundUser.getPassword());
    }

    private void validate(String rawPassword, String encodedPassword) {
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        if (!matches) throw new IllegalArgumentException("Password does not match");
    }
}
