package Entities;

public class Customers {

	private static int id;
	 
	private static  String name;
    
	private static  String last_name;
    
	private static  String job_title;
    
	private static  String adress;
    
	private static  String city;
    
	private static  Long zip_postal_code;
	
	private static String company;

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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZip_postal_code() {
		return zip_postal_code;
	}

	public void setZip_postal_code(Long zip_postal_code) {
		this.zip_postal_code = zip_postal_code;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
