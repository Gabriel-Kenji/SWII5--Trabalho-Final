package PROVA;



public class Orders {
	
	protected int ord_no;
	protected float purch_amt;
    protected String ord_date;
    protected int salesman_id;
    protected int customer_id;
    
    public Orders() {
	}
   
    public Orders(int id) {
        this.ord_no = id;
    }
 
    public Orders(int id, float purch_amt, String ord_date, int salesman_id, int customer_id) {
        this(purch_amt, ord_date, salesman_id, customer_id);
        this.ord_no = id;
    }
     
    public Orders(float purch_amt, String ord_date, int salesman_id, int customer_id) {
        this.purch_amt = purch_amt;
        this.ord_date = ord_date;
        this.salesman_id = salesman_id;
        this.customer_id = customer_id;
    }
    
    public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public float getPurch_amt() {
		return purch_amt;
	}
	public void setPurch_amt(float purch_amt) {
		this.purch_amt = purch_amt;
	}
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
}
