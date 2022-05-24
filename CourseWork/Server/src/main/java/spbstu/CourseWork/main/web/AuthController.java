package spbstu.CourseWork.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spbstu.CourseWork.main.entity.User;
import spbstu.CourseWork.main.repository.UserRepository;
import spbstu.CourseWork.main.security.jwt.JwtTokenProvider;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signIn", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> signIn(@RequestBody AuthRequest request) {
        try{
            String name = request.getUserName();
            String password = request.getPassword();
            Optional<User> user = userRepository.findUserByName(name);
            boolean passwordMatch = false;
            if (user.isPresent()) {
                User us = user.get();
                passwordMatch = passwordEncoder.matches(password, us.getPassword());
            }

            if (!passwordMatch)
                throw new BadCredentialsException("Invalid username or password");

            String token = jwtTokenProvider.createToken(
                    name,
                    user.orElseThrow(() -> new UsernameNotFoundException("User not found")).getRoles()
            );

            return ResponseEntity.ok(token);
        } catch (AuthenticationException ex) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
