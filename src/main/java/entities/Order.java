package entities;

public class Order {
	
	private int id;
	private String itemName;		
	private double amtDue;
	private String location;
	private String name;
	private int studentId;
	private boolean completed;
	
	
	public Order()
	{				
		this(1,"juice",80.0,"right here","bob marley",1,false);
	}
	

	public Order(int id, String itemName, double amtDue, String location, String name, int studentId, boolean completed) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.amtDue = amtDue;
		this.location = location;
		this.name = name;
		this.studentId = studentId;
		this.completed = completed;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getAmtDue() {
		return amtDue;
	}


	public void setAmtDue(double amtDue) {
		this.amtDue = amtDue;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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


	
	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", amtDue=" + amtDue + ", location=" + location
				+ ", name=" + name + ", studentId=" + studentId + ", completed=" + completed + "]";
	}

	
}


























/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="yung_Order")

 public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;

	@Column(name="item_name")
	@NotBlank
	private String itemName;
	
	@Column(name="amount_due")
	@NotBlank
	private double amtDue;
	
	@ManyToOne(
	        fetch = FetchType.LAZY
	    )
	    @JoinColumn(name = "student_id")
	    private Student student;
	
	public Order()
	{
	//	this(1,"juice",80.0,student);
		super();
	}
	

	public Order(Integer id, @NotBlank String itemName, @NotBlank double amtDue, Student student) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.amtDue = amtDue;
		this.student = student;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
	this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getAmtDue() {
		return amtDue;
	}


	public void setAmtDue(double amtDue) {
		this.amtDue = amtDue;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", amtDue=" + amtDue + ", student=" + student + "]";
	}


	@Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	             
	        if (!(o instanceof Order))
	            return false;
	             
	        return
	            id != null &&
	           id.equals(((Order) o).id);
	    }
	    @Override
	    public int hashCode() {
	        return 31;
	    }
}
*/