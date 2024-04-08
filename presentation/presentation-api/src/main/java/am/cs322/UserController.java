package am.cs322;

import am.cs322.model.CreateUserRequest;
import am.cs322.model.UserDTO;

public interface UserController {

    public UserDTO createUser(CreateUserRequest request);

    public UserDTO getUser(Long id);//todo

}
