package com.example.student.controller;

import com.example.student.repository.UserRepository;
import com.example.student.model.UserDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("deleted");
        return ResponseEntity.ok(id);
    }
    
    @PostMapping("/")
    public ResponseEntity insertUser(@RequestParam String name, @RequestParam String section){
        UserDetails ud = new UserDetails();
        ud.setName(name);
        ud.setSection(section);
        userRepo.save(ud);
        return ResponseEntity.ok("Created");
    }
}
