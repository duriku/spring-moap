package duri.com.template.springmoap.sevice.impl;

import duri.com.template.springmoap.domain.builder.UserBuilder;
import duri.com.template.springmoap.domain.dto.UserDTO;
import duri.com.template.springmoap.domain.entity.User;
import duri.com.template.springmoap.domain.repository.UserRepository;
import duri.com.template.springmoap.sevice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Duri on 2014.12.10..
 */

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDTO) {
        userRepository.save(UserBuilder.anUser().buildFromDTO(userDTO));
    }

    @Override
    public List<UserDTO> listUsers() {
        // JDBC TEMPLATE SOLUTION
        //List<Map<String, Object>> usersJdbcTemplate = jdbcTemplate.queryForList("select * from users");

        List<User> users = userRepository.findAll();
        return  users.stream()
                .map(user -> UserBuilder.anUser().buildDTO(user))
                .collect(Collectors.toList());
    }
}
