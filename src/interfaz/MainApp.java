
package interfaz;


import logica.Paciente.EnumColor;
import logica.Paciente.Patient;
import logica.servicio.ServiceManagement;
import logica.Paciente.enfermedades;
import logica.structure.Heap;


public class MainApp {
    public static void main(String[] args) {
//        graficinterface interfazGrafica = new graficinterface();
//        
//        Heap<Patient> heapVector = new Heap<>();
//
//        heapVector.create(new Patient(EnumColor.RED, enfermedades.quebradura, "QAZ123456", "person1"));
//        heapVector.create(new Patient(EnumColor.GREEN, enfermedades.Infarto, "YTV98161", "person2"));
//        heapVector.create(new Patient(EnumColor.YELLOW, enfermedades.dolorE, "OKN216488", "person3"));
//        heapVector.create(new Patient(EnumColor.RED, enfermedades.perdidaSangre, "UUIS19181", "person4"));
//        heapVector.create(new Patient(EnumColor.GREEN, enfermedades.otro, "UIS1681185", "person5"));
//
//        System.out.println("\n\nCREATES");
//        System.out.println(heapVector.toString());		
//    }
    

        //DatosCliente ventana = new DatosCliente();
        //ventana.setVisible(true);
        ventanaInicio v1 = new ventanaInicio();
        v1.setTitle("Configuración del usuario");  
        v1.setVisible(true);
    }
}


   

