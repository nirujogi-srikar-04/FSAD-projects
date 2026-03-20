package klu.Spring_DI;

public class Address {
	
	String Street,city;
	
	//default constructor
	
	public Address() {
		
			
		}

	
	public Address(String street, String city) {
		super();
		Street = street;
		this.city = city;
	}


	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return " [Street=" + Street + ", city=" + city + "]";
	}
	
}