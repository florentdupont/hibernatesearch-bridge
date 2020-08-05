package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.repository.SearchUserRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserRepository repository;
    final SearchUserRepository searchRepository;

    public UserController(UserRepository userRepository, SearchUserRepository searchUserRepository) {
        this.repository = userRepository;
        this.searchRepository = searchUserRepository;
    }

    @GetMapping("/users")
    public Iterable<User> users() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public Iterable<User> search() {
        return searchRepository.search();
    }

    @GetMapping("/index")
    public void index() throws InterruptedException {
        searchRepository.indexFullText();
    }

    @GetMapping("/init")
    public void init() {
        User u1 = new User("John Smith", "us");
        repository.save(u1);

        User u2 = new User("Jane Doe", "fr");
        repository.save(u2);
    }

    @GetMapping("/reset")
    public void reset() {
      repository.deleteAll();
    }

}
