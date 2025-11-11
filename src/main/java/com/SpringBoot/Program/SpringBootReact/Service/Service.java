package com.SpringBoot.Program.SpringBootReact.Service;

import com.SpringBoot.Program.SpringBootReact.Model.UserTable;
import com.SpringBoot.Program.SpringBootReact.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repo;

    public void saveUser(UserTable user) {
        repo.save(user);
    }

    public List<UserTable> getAllData() {
        return new ArrayList<>(repo.findAll());
    }

    public UserTable getOneStudent(Integer myid) {
        return repo.findById(myid).orElse(null);
    }

    public UserTable updateUser(UserTable ust1, Integer id) {
        Optional<UserTable> ust = repo.findById(id);

        if (ust.isPresent()) {
            UserTable user = ust.get();
            user.setName(ust1.getName());
            user.setCity(ust1.getCity());
            user.setEmail(ust1.getEmail());
            user.setSub(ust1.getSub());
            return repo.save(user);
        }
        throw new RuntimeException();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }
}