package entities;

public class Student
{
	private int id;
	private String name;	
	private int studentId;

	public Student() 
	{
		this(0,"YungLord",1608193);	
	}

	public Student(int id, String name, int studentId) 
	{
		super();
		this.id = id;
		this.name = name;
		this.studentId = studentId;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", studentId=" + studentId + "]";
	}
	
	
}

































































/*
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="yung_Student")

public class Student
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@Column(name="student_name")
	@NotBlank
	private String name;
	
	@Column(name="location")
	@NotBlank
	private String location;

	@OneToMany(
	        mappedBy = "order",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<Order> orders = new ArrayList<>();
	
	public Student() 
	{
		this(0,"oosh","osshh");	
	}



	public Student(int id, @NotBlank String name, @NotBlank String location) 
	{
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}
*/