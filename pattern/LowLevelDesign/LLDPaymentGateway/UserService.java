package LLDPaymentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {

    public List<User> userList = new ArrayList<>();

    public UserDo addUser(UserDo user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setUserId((int) new Random().nextInt(100-10)+10);
        userList.add(newUser);

        return ConvertUserToNewUser(newUser);

    }

    public UserDo getUser(int userId) {
        for(User i : userList){
            if(i.getUserId() == userId){
               return ConvertUserToNewUser(i);
            }
        }
        return null;
    }

    private UserDo ConvertUserToNewUser(User newUser) {
        UserDo newUserDo = new UserDo();
        newUserDo.setName(newUser.getName());
        newUserDo.setEmail(newUser.getEmail());
        newUserDo.setUserId(newUser.getUserId());
        return newUserDo;

    }
}
