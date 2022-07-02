//Gabriel Kenji Utiyama CB3012069
package PROVA;

public class Salesman {
	
	protected int salesman_id;
	protected String name;
    protected String city;
    protected float commission;
    
    
    public Salesman() {
	}
   
    public Salesman(int id) {
        this.salesman_id = id;
    }
 
    public Salesman(int id, String name, String city, float commission) {
        this(name, city, commission);
        this.salesman_id = id;
    }
     
    public Salesman(String name, String city, float commission) {
        this.name = name;
        this.city = city;
        this.commission = commission;
    }
    
    public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
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
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	
}
