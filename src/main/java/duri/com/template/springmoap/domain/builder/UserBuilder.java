package duri.com.template.springmoap.domain.builder;


import duri.com.template.springmoap.domain.dto.UserDTO;
import duri.com.template.springmoap.domain.entity.User;

import java.util.Date;

/**
 * Created by Duri on 12/24/2014.
 */
public class UserBuilder {

    protected String userName;
    protected String emailAddress;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected Date birthDate;

    protected UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User buildFromDTO(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBirthDate(userDTO.getBirthDate());
        return user;
    }

    public UserDTO buildDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    public User build() {
        User user = new User();
        user.setUserName(userName);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        return user;
    }

    public UserDTO buildDTO() {
        UserDTO user = new UserDTO();
        user.setUserName(userName);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        return user;
    }

}
