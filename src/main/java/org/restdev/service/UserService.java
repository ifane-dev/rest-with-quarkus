package org.restdev.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.restdev.domain.User;
import org.restdev.dto.UserData;
import org.restdev.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public void create(UserData request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        userRepository.persist(user);
    }

    public User getById(Long id){
        return userRepository.findByIdOptional(id).orElseThrow(() -> new IllegalArgumentException("User with Id " + id + " not found"));
    }

    public List<User> getAll(){
        return userRepository.listAll();
    }

    @Transactional
    public void update(Long id, UserData request){
        userRepository.findByIdOptional(id).ifPresent(
                user -> {
                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    userRepository.persist(user);
                }
        );
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
