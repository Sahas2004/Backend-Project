package com.SpringBoot.Program.SpringBootReact.Controller;

import com.SpringBoot.Program.SpringBootReact.Model.UserTable;
import com.SpringBoot.Program.SpringBootReact.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
@CrossOrigin("*")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/saveData")
    public String saveUser(UserTable user){
        service.saveUser(user);
        return "UserSaved Successfully";
    }

    @GetMapping("getAllData")
    public List<UserTable>  getAllUsers(){
        return service.getAllData();
    }

    @GetMapping("getOneStudent/{myid}")
    public UserTable getOneStudent(@PathVariable Integer myid){
    return service.getOneStudent(myid);
    }


    @PutMapping("updateUser/{id}")
    public  UserTable updateUser(@RequestBody UserTable ust,@PathVariable Integer id){
        return service.updateUser(ust,id);
    }

    @DeleteMapping("deleteUser/{id}")
    public boolean deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return true;
    }
}
