package duri.com.template.springmoap.sevice;

import duri.com.template.springmoap.domain.dto.UserDTO;

import java.util.List;

/**
 * Created by Duri on 2014.12.10..
 */
public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> listUsers();

}
