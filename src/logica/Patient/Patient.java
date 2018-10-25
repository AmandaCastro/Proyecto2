
package logica.Patient;
import logica.enums.EnumColor;

public class Patient implements Comparable<Patient> {
	//ATTRIBUTES
	private EnumColor colorPriority;
	private String id, name, surename;

	public EnumColor getColorPriority() {
		return colorPriority;
	}

	public void setColorPriority(EnumColor colorPriority) {
		this.colorPriority = colorPriority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	//CONSTRUCTOR
	public Patient(EnumColor color,String id, String name, String surename) {
		this.colorPriority = color;
		this.id = id;
		this.name = name;
		this.surename = surename;
	}

	@Override
	public String toString() {
		return "Patient [colorPriority=" + colorPriority + ", id=" + id + ", name=" + name + ", surename=" + surename
				+ "]";
	}

	//COMPARE
	@Override
	public int compareTo(Patient element) {
		if (this.getColorPriority().getIntCode()<element.getColorPriority().getIntCode()) {
			return 1;
		} else if (this.getColorPriority().getIntCode()==element.getColorPriority().getIntCode()) {
			return 0;
		} else {
			return -1;
		}
	} 
	
	
}

