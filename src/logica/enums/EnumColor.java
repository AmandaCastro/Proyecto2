
package logica.enums;
public enum EnumColor {
	RED(0, "R", "Red"), YELLOW(1, "Y", "Yellow"), GREEN(2, "G", "Green");

	private int intCode;
	private String charCode;
	private String description;

	public int getIntCode() {
		return intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private EnumColor(int intCode, String charCode, String description) {
		this.intCode = intCode;
		this.charCode = charCode;
		this.description = description;
	}

}
