package ac.bd.seu.crud.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.bd.seu.crud.dao.UserInterface;
import ac.bd.seu.crud.model.User;

/**
 * <h1>UserController Short Description</h1>
 * Briefly describe why you created this file
 * <p>
 * Giving proper comments in your program makes it more user friendly and it is assumed as a high quality code. Describe details of this file.
 *
 * @author Anonimo
 * @version 1.0
 * @since 26 Oct 2017 20:47
 */
@Controller
public class UserController {

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

    @Autowired
    private UserInterface userInterface;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getUsers() {
        Iterable<User> userIterable = userInterface.findAll();
        Collection<User> users = new ArrayList<>();
        userIterable.forEach(users::add);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        Optional<User> user = userInterface.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userInterface.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userInterface.save(user);
        if (updatedUser == null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id, @RequestBody User user) {
        userInterface.delete(user);
        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }

}
