package ru.job4j.ex.users;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User expectedUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
               expectedUser = user;
            }
        }
        if (expectedUser == null) {
            throw new UserNotFoundException("User not found!");
        } 
        return expectedUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid user!");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", false)
        };
        User user;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
