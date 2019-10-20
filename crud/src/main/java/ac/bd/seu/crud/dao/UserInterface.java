package ac.bd.seu.crud.dao;

import ac.bd.seu.crud.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * <h1>UserInterface Short Description</h1>
 * Briefly describe why you created this file
 * <p>
 * Giving proper comments in your program makes it more user friendly and it is assumed as a high quality code. Describe details of this file.
 *
 * @author Asaduzzaman Noor
 * @version 1.0
 * @since 26 Oct 2017 22:55
 */

public interface UserInterface extends CrudRepository<User, Integer> {
}
