package PROVA;

public class Customer {
	
	protected int customer_id;
	protected String name;
    protected String city;
    protected float grade;
    
    
    public Customer() {
	}
   
    public Customer(int id) {
        this.customer_id = id;
    }
 
    public Customer(int id, String name, String city, float grade) {
        this(name, city, grade);
        this.customer_id = id;
    }
     
    public Customer(String name, String city, float grade) {
        this.name = name;
        this.city = city;
        this.grade = grade;
    }
    
    
    public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

}
