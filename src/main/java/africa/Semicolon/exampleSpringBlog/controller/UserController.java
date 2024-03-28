package africa.Semicolon.exampleSpringBlog.controller;

import africa.Semicolon.exampleSpringBlog.dto.requests.LoginRequest;
import africa.Semicolon.exampleSpringBlog.dto.requests.SignUpRequest;
import africa.Semicolon.exampleSpringBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        try {
            userService.registerUser(signUpRequest);
            return ResponseEntity.created(URI.create("/users")).body("Registered successfully");
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/login")
    public ResponseEntity<?> registerUser(@RequestBody LoginRequest loginRequest) {
        try {
            userService.loginUser(loginRequest);
//            return ResponseEntity.status(OK).body("Login successful");
            return new ResponseEntity<>("Login successful", OK);
        }
        catch (RuntimeException e) {
//            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }
}
