package net.jogeum.restdocs.service;

import net.jogeum.restdocs.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author jogeum
 * @since 2019-08-03
 */
@Service
public class UserService {

    public Optional<UserDTO> getOne(String userId) {
        return Optional.of(
                UserDTO.builder()
                        .id(userId)
                        .name("조금")
                        .email("jogeum81@gmail.com")
                        .build()
        );
    }

    public List<UserDTO> getList() {
        return List.of(
                UserDTO.builder()
                        .id("jogeum")
                        .name("조금")
                        .email("jogeum81@gmail.com")
                        .build(),
                UserDTO.builder()
                        .id("little")
                        .name("조금")
                        .email("jogeum81@gmail.com")
                        .build(),
                UserDTO.builder()
                        .id("bit")
                        .name("조금")
                        .email("jogeum81@gmail.com")
                        .build()
        );
    }
}
