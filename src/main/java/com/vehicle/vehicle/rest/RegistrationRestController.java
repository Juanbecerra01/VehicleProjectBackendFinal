package com.vehicle.vehicle.rest;

import com.vehicle.vehicle.domain.Response;
import com.vehicle.vehicle.security.model.User;
import com.vehicle.vehicle.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationRestController {

    @Autowired private UserServiceImpl userService;

    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody User user){
        User dbUser = userService.save(user);
        if(dbUser != null){
            return new ResponseEntity<Response>(new Response("User was saved successfully"), HttpStatus.OK);
        }
        return null;
    }

}