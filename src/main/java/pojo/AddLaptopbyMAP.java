package pojo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddLaptopbyMAP {

	private String name;
	private String language;
	private ArrayList<HashMap<String,Object>> laptop;
	private Location location;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ArrayList<HashMap<String, Object>> getLaptop() {
		return laptop;
	}
	public void setLaptop(ArrayList<HashMap<String, Object>> laptop) {
		this.laptop = laptop;
	}
	
	
}
