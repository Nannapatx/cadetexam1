package odds.saturn.starbucks.services;

import odds.saturn.starbucks.entities.Users;
import odds.saturn.starbucks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(Users newUser) {
        return userRepository.saveAndFlush(newUser);
    }

    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users updateUser(Users user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
