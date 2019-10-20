package ac.bd.seu.crud.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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

@Entity
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    
    public User() {
    	
    }
    
    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
    
}
