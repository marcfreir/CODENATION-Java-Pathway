package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(this.userService.findById(id).orElse(new User()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationName(@RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName, @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId) {

        List<User> userList = new ArrayList<>();

        if (!accelerationName.isEmpty()) {
            userList.addAll(this.userService.findByAccelerationName(accelerationName));
        }

        if (companyId != 0) {
            userList.addAll(this.userService.findByCompanyId(companyId));
        }

        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
}
