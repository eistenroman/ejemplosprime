package ac.bd.seu.crud.model;

import ac.bd.seu.crud.controller.UserController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <h1>User Short Description</h1>
 * Briefly describe why you created this file
 * <p>
 * Giving proper comments in your program makes it more user friendly and it is assumed as a high quality code. Describe details of this file.
 *
 * @author Asaduzzaman Noor
 * @version 1.0
 * @since 26 Oct 2017 20:50
 */

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;
    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
