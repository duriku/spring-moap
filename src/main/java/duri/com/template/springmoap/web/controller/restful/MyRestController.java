package duri.com.template.springmoap.web.controller.restful;

import duri.com.template.springmoap.domain.dto.UserDTO;
import duri.com.template.springmoap.sevice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Duri on 2014.12.10..
 */
@RestController
@RequestMapping(value = "/rest")
public class MyRestController {

    private static Logger logger = LoggerFactory.getLogger(MyRestController.class);


    /*
    Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
    Support for serving static resources, including support for WebJars (see below).
    Automatic registration of Converter, GenericConverter, Formatter beans.
    Support for HttpMessageConverters (see below).
    Automatic registration of MessageCodeResolver (see below)
    Static index.html support.
    Custom Favicon support.
     */

    @Autowired
    private UserService userService;

    @RequestMapping(value = "currentDate", method = RequestMethod.GET)
    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
    }

    @RequestMapping(value = "listUsers", method = RequestMethod.GET)
    public String listUsers(){
        logger.error("listUsers CONTROLLER INVOKED");
        return userService.listUsers().toString();
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST,
    headers = "Accept=application/json")
    public void addUser(@RequestBody UserDTO userDTO) {
        logger.error("addUser CONTROLLER INVOKED");
        userService.addUser(userDTO);
    }


}
