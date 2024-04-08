package am.cs322;

import am.cs322.model.CreateUserRequest;
import am.cs322.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserRequest request) {
        //System.out.println(request.toString());
        return userService.createUser(request.firstName(), request.lastName());
    }

    @Override
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUser(id);
    }


}
