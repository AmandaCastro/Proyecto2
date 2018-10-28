package logica.Paciente;

public class Patient implements Comparable<Patient> {

	private EnumColor state;
	private enfermedades enfermedad;
	private String patientID;
	private String name;
        private String fecha;
        private String detalle;
        private int num;

        public Patient(){
        }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public enfermedades getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(enfermedades enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    
        
	public EnumColor getState() {
		return state;      

	}

	public void setState(EnumColor state) {
		this.state = state;
	}

	public enfermedades getSickness() {
		return enfermedad;
	}

	public void setSickness(enfermedades enfermedad) {
		this.enfermedad=enfermedad;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	

	public Patient(EnumColor state, enfermedades enfermedad, String patientID, String name) {
		this.state = state;
		this.enfermedad = enfermedad;
		this.patientID = patientID;
		this.name = name;
	}

    public Patient(EnumColor state, enfermedades enfermedad, String patientID, String name, String fecha, String detalle, int num) {
        this.state = state;
        this.enfermedad = enfermedad;
        this.patientID = patientID;
        this.name = name;
        this.fecha = fecha;
        this.detalle = detalle;
        this.num = num;
    }

	@Override
	public String toString() {
		return "Patient [state=" + state + ", sickness=" + enfermedad + ", patientID=" + patientID + ", name=" + name
				+ "]";
	}

	@Override
	public int compareTo(Patient element) {
		if (this.getState().getIntCode()<element.getState().getIntCode()) {
			return -1;
		} else if (this.getState().getIntCode()==element.getState().getIntCode()) {
			return 0;
		} else {
			return 1;
		}
	}
        

}
        

