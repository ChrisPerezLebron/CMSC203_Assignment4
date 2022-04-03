public class ManagementCompany {
	private final int MAX_PROPERTY = 5;
	private final int MGMT_DEPTH = 10;
	private final int MGMT_WIDTH = 10; 
	private double mgmFeePer;
	private String name;
	private Property[] properties; 
	private String taxID; 
	private Plot plot; 
	
	
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0,0,this.MGMT_WIDTH,this.MGMT_DEPTH);
		this.properties = new Property[this.MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,this.MGMT_WIDTH,this.MGMT_DEPTH);
		this.properties = new Property[this.MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		this.properties = new Property[this.MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
		this.properties = new Property[otherCompany.properties.length];
		
		for(int count = 0; count < otherCompany.properties.length; count++) {
			this.properties[count] = new Property(otherCompany.properties[count]);
		}
	}
	
	
	public int addProperty(Property property) {
		if (property == null) 
			return -2;
		else if (!this.plot.encompasses(property.getPlot())) 
			return -3; 
		
		for(int count = 0; count < this.properties.length; count++) {
			if (this.properties[count] == null) {
				this.properties[count] = new Property(property);
				return count;
			}
			else if (property.getPlot().overlaps(this.properties[count].getPlot())) {
				return -4;
			}
		}
		
		return -1; //since it got to the end of the array and didn’t find any empty position or any over laps 
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner); 
		//don’t need to check null because we just created the object
		//don't need to check encompasses because we dictate the object location since it wasn't given
		
		for(int count = 0; count < this.properties.length; count++) {
			if (this.properties[count] == null) {
				this.properties[count] = property; //refrence copy is okay because other ref var will die upon method completion
				return count;
			}
			else if (property.getPlot().overlaps(this.properties[count].getPlot())) {
				return -4;
			}
		}
		
		return -1; //since it got to the end of the array and didn’t find any empty position or any over laps 
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		//dont need to check for null case because we just created the object
		
		if (!this.plot.encompasses(property.getPlot()))
			return -3; 
		
		for(int count = 0; count < this.properties.length; count++) {
			if (this.properties[count] == null) {
				this.properties[count] = property; //refrence copy is okay because other ref var will die upon method completion
				return count;
			}
			else if (property.getPlot().overlaps(this.properties[count].getPlot())) {
				return -4;
			}
		}
		
		return -1; //since it got to the end of the array and didn’t find any empty position or any over laps 
	}
	
	public String displayPropertyAtIndex(int i) {
		return this.properties[i].toString(); 
	}
	
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}
	
	public double maxRentProp() {
		if (this.properties[0] == null)
			return -1;
			
		double max = this.properties[0].getRentAmount();
		
		for(int count = 1; count < this.properties.length; count++) {
			if (this.properties[count] == null)
				return max;
			else if (this.properties[count].getRentAmount() > max)
				max = this.properties[count].getRentAmount();
		}
		
		return max; //this will only execute if it gets to the end of the array ie there isnt a null object in its path to the end of the array
	}
	
	public int maxRentPropertyIndex() {
		
		if (this.properties[0] == null)
			return -1;
			
		double max = this.properties[0].getRentAmount();
		int index = 0;
		
		for(int count = 1; count < this.properties.length; count++) {
			if (this.properties[count] == null)
				return index;
			else if (this.properties[count].getRentAmount() > max) {
				max = this.properties[count].getRentAmount();
				index = count; 
			}
		}
		return index; 
	}
	
	
	public String toString() {
		String str =   "List of properties for " + this.name
					 + ", taxID: " + this.taxID
					 + "\n_________________________________________________"
					 + "\n"; 
		int count = 0; 
		while (count < this.properties.length && this.properties[count] != null) {
			str += this.properties[count].toString() + "\n";
			count++;	
		}
		str +=    "_________________________________________________"
				+ String.format("\ntotal management fee: $%,.2f", (this.totalRent() * (this.mgmFeePer/100.0)));
		return str;
	}
	
	public double totalRent() {
		double total = 0;
		int count = 0;
		
		while (count < this.properties.length && this.properties[count] != null) {
			total += this.properties[count].getRentAmount();
			count++;	
		}
		return total; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public Plot getPlot() {
		return new Plot(this.plot);
	}
}