public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot; 
	
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.plot = new Plot(0,0,1, 1);
	}
	
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(0,0,1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x,y,width, depth);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public Plot getPlot() {
		return new Plot(this.plot);
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x,y,width,depth);
		return new Plot(this.plot);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		return     "Property Name: " + this.propertyName 
				 + "\nLocated in " + this.city
				 + "\nBelonging to: " + this.owner
				 + "\nRent Amount $" + String.format("%,.2f", this.rentAmount);
		
		
	}
}