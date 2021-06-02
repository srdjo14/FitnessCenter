package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.UserService;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.entity.dto.MemberDTO;
import com.classproject.FitnessCenter.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    /* Constructor-based dependency injection */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){

        User user = this.userService.findOne(id);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws Exception {
        User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword())
    }

}
