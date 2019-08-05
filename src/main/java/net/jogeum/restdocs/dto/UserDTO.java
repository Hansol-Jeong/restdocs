package net.jogeum.restdocs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author jogeum
 * @since 2019-08-03
 */
@Getter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 865485772937610336L;

    private String id;
    private String name;
    private String email;

    @Builder
    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
