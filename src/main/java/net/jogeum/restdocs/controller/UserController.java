package net.jogeum.restdocs.controller;

import net.jogeum.restdocs.dto.UserDTO;
import net.jogeum.restdocs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jogeum
 * @since 2019-08-03
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List> getList() {
        return ResponseEntity.ok(userService.getList());
    }

    @GetMapping("/{userId:.+}")
    public ResponseEntity<UserDTO> getOne(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getOne(userId).get());
    }
}
