package by.ycherkas.demo.service;

import by.ycherkas.demo.model.User;
import by.ycherkas.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow
                (()-> new IllegalArgumentException("user not found"));
    }

    public List<User> findAll(){
    return userRepository.findAll();
    }
}
