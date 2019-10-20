package ac.bd.seu.crud.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import ac.bd.seu.crud.dao.UserInterface;
import ac.bd.seu.crud.model.User;

@ManagedBean
@RequestScope
public class HelloWorld {
	@Autowired
    private UserInterface userInterface;
		
	private String firstName = "John";
	private String lastName = "Doe";
	private List<User> themes;
	private User theme;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getTheme() {
		return theme;
	}

	public void setTheme(User theme) {
		this.theme = theme;
	}
			
	public List<User> getThemes() {
		return themes;
	}

	public void setThemes(List<User> themes) {
		this.themes = themes;
	}
	
	public String showGreeting() {
		User user = new User(firstName, lastName);
		return "Hello " + user + "!";
	}
	
	@PostConstruct
    public void init() {
		themes = new ArrayList<User>();
        for(User user: userInterface.findAll()) {
        	System.out.println(user);
        	themes.add(user);
        }
    }
}
