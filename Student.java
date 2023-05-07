
public class Student {
	private String name;
	 private String reference;
	private boolean availability;
	private String pickUpDate = "";
	Student(){
		
	}
	Student(String name,String reference ){
		this.name = name;
		this.reference = reference;

	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setReference(String name) {
		this.reference = name;
	}
	public String getReference() {
		return this.reference;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean getAvailability() {
		return this.availability;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public String getPickUpDate() {
		return this.pickUpDate;
	}
	
	
}
