package logica.Paciente;

public enum enfermedades{
	Infarto(0,"I", "Infarto"), perdidaSangre(1,"H","perdidaS"), parto(2,"P","Parto"), dolorE(3,"D","DEstomacal"), quebradura(4, "Q","quebradura"), otro(5,"O","otro");
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

	private enfermedades(int intCode, String charCode, String description) {
		this.intCode = intCode;
		this.charCode = charCode;
		this.description = description;
	}
}

