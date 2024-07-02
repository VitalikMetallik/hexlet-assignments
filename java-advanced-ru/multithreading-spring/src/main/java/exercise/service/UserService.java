package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> show(int id) {
        return userRepository.findById(id);
    }

    public Mono<User> update(int id, User userData) {
        userData.setId(id);
        return userRepository.save(userData);
    }

    public Mono<Void> delete(int id) {
        return userRepository.deleteById(id);
    }
    // END
}