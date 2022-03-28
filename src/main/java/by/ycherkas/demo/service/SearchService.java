package by.ycherkas.demo.service;

import by.ycherkas.demo.model.User;
import by.ycherkas.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private UserRepository userRepository;

    @Autowired
    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchUsers(String param){
        return userRepository.findAll().stream().
                filter(user -> user.getName().contains(param)
                || user.getSecondName().contains(param)
                || user.getModelAuto().contains(param)
                || user.getNumberAuto().contains(param)
                || user.getProblems().contains(param)).
                collect(Collectors.toList());
    }

}
