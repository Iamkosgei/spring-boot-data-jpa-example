package me.kosgei.springJpa.service;

import me.kosgei.springJpa.model.User;
import me.kosgei.springJpa.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public List<User> getUsers(){
       List<User> users = new ArrayList<>();

       for (User user: userRepo.findAll()){
           users.add(user);
       }
       return  users;

    }

    public void updateUser(User us){
        for (User usr: userRepo.findAll()){
            if(usr.getId()== us.getId()){
               usr=us;
               addUser(usr);
            }
        }
    }

    public User findUserById(int id){
       return userRepo.findUserById(id);
    }

    public  void deleteUser(User user){
        userRepo.delete(user);
    }
}
