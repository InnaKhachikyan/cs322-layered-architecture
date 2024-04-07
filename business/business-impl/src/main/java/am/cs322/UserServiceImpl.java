package am.cs322;

import am.cs322.model.User;
import am.cs322.model.UserDTO;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createUser(String firstName, String lastName) {
        User createdUser = userRepository.save(new User(firstName, lastName));
        return new UserDTO(createdUser.getFirstName() + " " + createdUser.getLastName());
    }

    public UserDTO getUser(Long id) {
        Optional<User>  user = userRepository.findById(id);

        if (user.isPresent()) {
            User actualUser = user.get();
            return new UserDTO(actualUser.getFirstName() + " " + actualUser.getLastName());
        } else {
            throw new RuntimeException("User not found");
        }
    }


}