package entities;

public class Rider 
{
		
	private int id;
	private String name;
	private String username;
	private String password;
	
	public Rider() {
		this(0,"barry","barry101","gg");
	}
	
	public Rider(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Rider [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

}


















//
//
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import javax.validation.constraints.NotBlank;
//
//@Entity
//@Table(name="yung_Rider")
//public class Rider {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	
//	@Column(name="rider_name")
//	@NotBlank
//	private String name;
//	
//	@Transient
//	private String username;
//	
//	@Transient
//	private String password;
//
//	public Rider() {
//		this(0,"barry","barry101","gg");
//	}
//
//	public Rider(int id, @NotBlank String name, String username, String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.username = username;
//		this.password = password;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "Rider [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
//	}
//	
//	
//
//}
