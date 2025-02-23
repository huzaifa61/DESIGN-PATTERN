package LLDPaymentGateway;

public class UserController {

    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public UserDo addUser(UserDo userDo) {
        return userService.addUser(userDo);

    }

    public UserDo getUser(int userId) {
        return userService.getUser(userId);


    }

}
