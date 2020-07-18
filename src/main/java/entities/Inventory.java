package entities;


public class Inventory {
	
	
	private int id;
	
	private String item;
		
	private double price;
	
	private String type;
	
	private int available;
	

	
	public Inventory()
	{
		this(0,"bag juice",0.0,"beverage",5);
	}
	
	
	
	public Inventory(int id,  String item,  double price,  String type, int available) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
		this.type = type;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;	
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available){
		this.available = available;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", item=" + item + ", price=" + price + ", type=" + type + ", available="
				+ available + "]";
	}
}



























/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="yung_Inventory")

public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@Column(name="item_name")
	@NotBlank
	private String item;
	
	@Column(name="price")
	@NotBlank
	private double price;
	
	@Column(name="item_type")
	@NotBlank
	private String type;
	
	@Column(name="available")
	@NotBlank
	private int available;

	public Inventory(int id, @NotBlank String item, @NotBlank double price, @NotBlank String type,
			@NotBlank int available) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
		this.type = type;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available){
		this.available = available;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", item=" + item + ", price=" + price + ", type=" + type + ", available="
				+ available + "]";
	}
	

}
*/