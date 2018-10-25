
package interfaz;


import logica.enums.EnumColor;
import logica.Patient.Patient;
import logica.servicio.ServiceManagement;

public class MainApp {
	public static void main(String[] args) {
		
		
		
		ServiceManagement<Patient> patientManagement = new ServiceManagement<>(false);
		
		patientManagement.create(new Patient(EnumColor.RED,"301251248589", "Aaron", "Castro"));
		patientManagement.create(new Patient(EnumColor.YELLOW,"301251248589", "Alfredo", "Monge"));
		patientManagement.create(new Patient(EnumColor.GREEN,"301251248589", "Miranda", "Venegas"));
		patientManagement.create(new Patient(EnumColor.RED,"301251248589", "Amanda", "Castro"));
		patientManagement.create(new Patient(EnumColor.GREEN,"301251248589", "Alexander", "Venegas"));


		System.out.println(patientManagement.toString());
	}
}

