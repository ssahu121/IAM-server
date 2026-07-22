package com.iam.iam_server.service.impl;

import com.iam.iam_server.dto.ForgotPasswordRequest;
import com.iam.iam_server.dto.LoginRequest;
import com.iam.iam_server.dto.LoginResponse;
import com.iam.iam_server.dto.ResetPasswordRequest;
import com.iam.iam_server.entity.PasswordResetToken;
import com.iam.iam_server.entity.User;
import com.iam.iam_server.repository.PasswordResetTokenRepository;
import com.iam.iam_server.repository.UserRepository;
import com.iam.iam_server.security.JwtService;
import com.iam.iam_server.service.AuthService;
import com.iam.iam_server.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Override
    public LoginResponse login(LoginRequest request) {

        System.out.println("===================================");
        System.out.println("LOGIN API HIT");
        System.out.println("USERNAME = " + request.getUsername());
        System.out.println("PASSWORD = " + request.getPassword());
        System.out.println("===================================");

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            System.out.println("AUTHENTICATION SUCCESS");

            UserDetails user =
                    customUserDetailsService.loadUserByUsername(request.getUsername());

            String token = jwtService.generateToken(user);

            System.out.println("JWT GENERATED");

            return LoginResponse.builder()
                    .accessToken(token)
                    .tokenType("Bearer")
                    .expiresIn(expiration)
                    .build();

        } catch (BadCredentialsException e) {

            System.out.println("BAD CREDENTIALS");
            throw new RuntimeException("Invalid username or password");

        } catch (Exception e) {

            System.out.println("LOGIN ERROR");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();

        PasswordResetToken resetToken = PasswordResetToken.builder()
                .token(token)
                .user(user)
                .expiryDate(LocalDateTime.now().plusMinutes(30))
                .build();

        passwordResetTokenRepository.save(resetToken);

        System.out.println("=================================");
        System.out.println("RESET TOKEN = " + token);
        System.out.println("=================================");
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {

        PasswordResetToken resetToken = passwordResetTokenRepository
                .findByToken(request.getToken())
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }

        User user = resetToken.getUser();

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);

        passwordResetTokenRepository.delete(resetToken);
    }
}