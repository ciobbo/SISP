package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.UserController;
import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.security.*;
import com.SISP.server.flutter.SISP.service.UserServiceImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.*;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;
import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(USER)
public class UserControllerImpl implements UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUser() {
        return userServiceImpl.getUser();
    }

    @Override
    public String addUser(@RequestBody User NewUser){
        userServiceImpl.saveUser(NewUser);
        return "New User!";
    }

    @Override
    public Optional<User> updateUser(@RequestBody String name, @PathVariable Long id) throws Exception {
        userServiceImpl.updateuser(id, name);
        return userServiceImpl.getuserbyid(id);
    }

    @Override
    public Optional<User> getUserById (@PathVariable Long id){
        return userServiceImpl.getuserbyid(id);
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return "Deleted user!";
    }

    @Override
    public String deleteUserLogica(@PathVariable  Long id) throws Exception {
        userServiceImpl.deleteUserLogica(id);
        return "Deleted User!";
    }

    @Override
    public List<User> findAllAndFlag() {
        return userServiceImpl.findAllAndFlag();
    }

    @Override
    public List<UserDto> getAllUsersCartgetAllUsersCart() {
        return userServiceImpl.getAllUsersCart();
    }

    @Override
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/add-role/").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveRole(role));
    }
    @Override
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
         userServiceImpl.addRoleToUser(form.getUsername(), form.getRole_name()) ;
        return ResponseEntity.ok().build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                try {
                    String refresh_token = authorizationHeader.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256(("secret".getBytes()));
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(refresh_token);
                    String username = decodedJWT.getSubject();
                    User user = userRepository.findUserByName(username);
                    String access_token = JWT.create()
                            .withSubject(user.getName())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                            .withIssuer(request.getRequestURL().toString())
                            .withClaim("roles", user.getAddedRoles().stream().map(Role::getName).collect(Collectors.toList()))
                            .sign(algorithm);
                    Map<String, String> tokens = new HashMap<>();
                    tokens.put("access_token", access_token);
                    tokens.put("refresh_token", refresh_token);
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                }catch (Exception exception){
                    response.setHeader("error", exception.getMessage());
                    //response.sendError(FORBIDDEN.value());
                    Map<String, String> error = new HashMap<>();
                    error.put("error", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }
            }else {
                throw new RuntimeException("Refresh token is missing");
            }
        }
}

