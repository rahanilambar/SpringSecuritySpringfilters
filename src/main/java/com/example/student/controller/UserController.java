package com.example.student.controller;

import com.example.student.DTO.UserDto;
import com.example.student.repository.UserRepository;
import com.example.student.model.UserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired   
    UserRepository userRepo;
    
    @GetMapping("/")
    public ResponseEntity getAllData(){
        List<UserDetails> user =  userRepo.findAll();
        if(user == null) {
            return ResponseEntity.ok("No user");
        }
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity insertUser(@Valid @RequestBody UserDto userDto, BindingResult br){
        if(br.hasErrors()){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        UserDetails ud = new ObjectMapper().convertValue(userDto, UserDetails.class);
        userRepo.save(ud);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
