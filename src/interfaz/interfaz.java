/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import javax.swing.JOptionPane;
import logica.Paciente.*;
import logica.structure.*;
/**
 *
 * @author mvene
 */
public class interfaz extends javax.swing.JFrame {
    
    //objetos para trabajar en la progra
    Patient paciente = new Patient();
    ficha xFicha = new ficha();
    //interfaz x = new interfaz();
    
    
    //objetos de estructuras a utilizar
    Heap h1 = new Heap();
    Heap h2 = new Heap();
    Heap h3 = new Heap();
    
    cola c1 = new cola();
    cola c2 = new cola();
    cola c3 = new cola();
    
    cola colaSeguridad= new cola();
    cola colaFichas = new cola();
    
    //atributos del paciente
        public EnumColor state;
	public enfermedades enfermedad;
	public String patientID;
	public String name;
        public String detalle;
        public int num;
        public String fecha;
    
    //atributos de la ficha
    public String tipoEnfermedad;
    public String tipoColor;
        
    /*
    contadores
    */
    public static int totalInfarto;
    public static int totalPartos;
    public static int totalSangre;
    public static int totalQuebradura;
    public static int totalPancita;
    public static int totalOtros;
    public static int totalRojas;
    public static int totalVerde;
    public static int totalAmarillos;
    public static int totalVentanasRojas;
    public static int totalVentanasVerdes;
    public static int totalVentanasAmarillo;
    
    /*
    los tipos que van a ser las ventanas de perecedero y no perecedero
    */
    public static String tipoRojas;
    public static String tipoVerdes;
    public static String tipoAmarillo;
    
    /*
    tiempo minimo y maximo de atencion
    */
    public static int tiempoMinimo;
    public static int tiempoMaximo;
    public static int cantidadColaSeguridad;
    public static int tiempoTotal=0;
    
    
    /**
     * Creates new form interfaz
     */
    public interfaz() {
        initComponents();
    }
    
       public interfaz(String tipoAmarillo, String tipoVerdes, int contadorVerdes, int contadorAmarillas,String MinimoTiempo,String MaximoTiempo) {
        initComponents();
        totalVentanasVerdes=contadorVerdes;
        totalVentanasAmarillo=contadorAmarillas;
        tipoColor=tipoVerdes;
        tipoColor=tipoAmarillo;
        tiempoMinimo= Integer.parseInt(MinimoTiempo);
        tiempoMaximo= Integer.parseInt(MaximoTiempo);
        /**
         * los botones se muestran dependiendo de cuantas ventanas se hayan solicitado
         */
        if(contadorVerdes>=1){
            BotonVentana1.setVisible(true);
        }
        else{
            BotonVentana1.setVisible(false);
        }
        if(contadorVerdes>=2){
            BotonVentana2.setVisible(true);
        }
        else{
            BotonVentana2.setVisible(false);
        }
        if(contadorVerdes>=3){
            BotonVentana3.setVisible(true);
        }
        else{
            BotonVentana3.setVisible(false);
        }
        
        if(contadorAmarillas>=1){
            BotonVentana1A.setVisible(true);
        }
        else{
            BotonVentana1A.setVisible(false);
        }
        if(contadorAmarillas>=2){
            BotonVentana2A.setVisible(true);
        }
        else{
            BotonVentana2A.setVisible(false);
        }
        if(contadorAmarillas>=3){
            BotonVentana3A.setVisible(true);
        }
        else{
            BotonVentana3A.setVisible(false);
        }
    } 
                    
   
    
    //método agregar
    public void agregar(){
        Patient data = new Patient();
        this.name = TextPaciente.getText();
        this.fecha = TextFechaNac.getText();
        this.detalle = TextDetalle.getText();
        this.num = Integer.parseInt(TextNum.getText());
        
        data.setDetalle(detalle);
        data.setFecha(fecha);
        data.setNum(num);
        data.setName(name);
        
        if("Rojo".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                c1.create(data);
            }else{
                h1.create(data);
            }
        }
        if("Verde".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                c2.create(data);
            }else{
                h2.create(data);
            }
        }
        
         if("Amarillo".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                c3.create(data);
            }else{
                h3.create(data);
            }
        }
    }
    
    public void generarficha(){
        ficha f =new ficha(tipoColor, tipoEnfermedad);
        f.setTipoEnfermedad(tipoEnfermedad);
        f.setTipoColor(tipoColor);
        f.getFichasRoja();
        f.getFichasVerde();
        f.getFichasAmarilla();
        f.getCodigoFicha();
        
        ventanaFicha vf = new ventanaFicha(tipoColor, tipoEnfermedad);
        vf.setVisible(true);
        vf.setTitle("Ventanilla de fichas");
        colaFichas.create(f);
    }
    
     /*
    Este método determina el tiempo que se va a tomar atendiendo un paquete en la cola de seguridad
    */
    public void tiempoEspera(){
        int num;
        num=(int)(Math.random()*(tiempoMaximo-tiempoMinimo+1)+tiempoMinimo);
        int tiempo=num*100;
        /**
         * Se suma el tiempo que se va a durar atendiendo al cliente al total para sacar el promedio y se suma uno a la cantidadColaSeguridad
         */
        tiempoTotal=tiempoTotal+tiempo;
        cantidadColaSeguridad++;
        try{
            if(colaSeguridad.isEmpty()==false){
                Patient info=(Patient) colaSeguridad.extract();
                JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getName());
                /**
                 * Se hace un sleep por el tiempo generado en el random 
                 */
                Thread.sleep(tiempo);
                JOptionPane.showMessageDialog(null,"Atendido");
            }
        }
        catch(Exception e){
            
        }
    }
    
    /**
     * Metodo que calcula el tiempo promedio que se dura en la cola seguridad
     * @return 
     */
    public int tiempoPromedio(){
        int promedio=tiempoTotal/cantidadColaSeguridad;
        return promedio;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonInfarto = new javax.swing.JButton();
        ButtonSangre = new javax.swing.JButton();
        ButtonParto = new javax.swing.JButton();
        ButtonPancita = new javax.swing.JButton();
        ButtonHuesito = new javax.swing.JButton();
        ButtonOtro = new javax.swing.JButton();
        TextPaciente = new javax.swing.JTextField();
        TextFechaNac = new javax.swing.JTextField();
        TextDetalle = new javax.swing.JTextField();
        LabelTítulo1 = new javax.swing.JLabel();
        LabelPacient = new javax.swing.JLabel();
        LabelNacim = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LabNum = new javax.swing.JLabel();
        LabelSeleccion = new javax.swing.JLabel();
        TextNum = new javax.swing.JTextField();
        ButtonFicha = new javax.swing.JButton();
        LabelTítulo2 = new javax.swing.JLabel();
        LabelCons2 = new javax.swing.JLabel();
        LabelCons1 = new javax.swing.JLabel();
        LabelCons3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        BotonVentana2 = new javax.swing.JButton();
        BotonVentana3 = new javax.swing.JButton();
        LabelValoración = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonRojo = new javax.swing.JButton();
        jButtonAmarillo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LabelCons4 = new javax.swing.JLabel();
        LabelCons5 = new javax.swing.JLabel();
        LabelCons6 = new javax.swing.JLabel();
        BotonVentana1 = new javax.swing.JButton();
        BotonVentana3A = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BotonVentana1A = new javax.swing.JButton();
        BotonVentana2A = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonInfarto.setText("Infarto (I)");
        ButtonInfarto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonInfartoMouseClicked(evt);
            }
        });
        ButtonInfarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInfartoActionPerformed(evt);
            }
        });

        ButtonSangre.setText("Pérdida de Sangre (H)");
        ButtonSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSangreActionPerformed(evt);
            }
        });

        ButtonParto.setText("Parto (P)");
        ButtonParto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPartoActionPerformed(evt);
            }
        });

        ButtonPancita.setText("Dolor Estomacal (D)");
        ButtonPancita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPancitaActionPerformed(evt);
            }
        });

        ButtonHuesito.setText("Quebradura (Q)");
        ButtonHuesito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHuesitoActionPerformed(evt);
            }
        });

        ButtonOtro.setText("Otro (O)");
        ButtonOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOtroActionPerformed(evt);
            }
        });

        TextPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPacienteActionPerformed(evt);
            }
        });

        TextDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDetalleActionPerformed(evt);
            }
        });

        LabelTítulo1.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        LabelTítulo1.setText("Registro de ingresos");

        LabelPacient.setText("Nombre del paciente");

        LabelNacim.setText("Fecha de Nacimiento");

        jLabel14.setText("Detalles de Padecimiento");

        LabNum.setText("Número de Teléfono");

        LabelSeleccion.setText("Seleccione su padecimiento");

        ButtonFicha.setText("Generar Ficha");
        ButtonFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFichaActionPerformed(evt);
            }
        });

        LabelTítulo2.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        LabelTítulo2.setText("Pacientes de Urgencias");

        LabelCons2.setText("   Consultorio 2");

        LabelCons1.setText("   Consultorio 1");

        LabelCons3.setText("   Consultorio 3");

        jLabel15.setFont(new java.awt.Font("Leelawadee", 0, 10)); // NOI18N
        jLabel15.setForeground(java.awt.Color.magenta);
        jLabel15.setText("No entiendo esta picha, DONDE ESTA MI DILDO ");

        BotonVentana2.setText("Atender");
        BotonVentana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana2ActionPerformed(evt);
            }
        });

        BotonVentana3.setText("Atender");
        BotonVentana3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana3ActionPerformed(evt);
            }
        });

        LabelValoración.setText("Valoración del Paciente");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel6.setText("Te encanta la verga hija de tu puta madre c:");

        jButtonRojo.setText("Rojo (R)");
        jButtonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRojoActionPerformed(evt);
            }
        });

        jButtonAmarillo.setText("Amarillo (A)");
        jButtonAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAmarilloActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Puta madre");

        LabelCons4.setText("   Consultorio 1");

        LabelCons5.setText("   Consultorio 2");

        LabelCons6.setText("   Consultorio 3");

        BotonVentana1.setText("Atender");
        BotonVentana1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana1ActionPerformed(evt);
            }
        });

        BotonVentana3A.setText("Atender");
        BotonVentana3A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana3AActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Amarillo");

        BotonVentana1A.setText("Atender");
        BotonVentana1A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana1AActionPerformed(evt);
            }
        });

        BotonVentana2A.setText("Atender");
        BotonVentana2A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana2AActionPerformed(evt);
            }
        });

        jButton1.setText("Verde (V)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelTítulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonParto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonOtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelValoración, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(LabNum)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextNum))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextDetalle))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(LabelNacim)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextFechaNac))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(LabelPacient)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(LabelSeleccion)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ButtonInfarto, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(ButtonPancita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ButtonHuesito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ButtonSangre)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButtonRojo)
                                        .addGap(14, 14, 14)
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAmarillo)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelTítulo2)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BotonVentana1A)
                                            .addComponent(LabelCons4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BotonVentana1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelCons1))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelCons2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BotonVentana2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LabelCons3)
                                            .addComponent(BotonVentana3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 144, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelCons5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonVentana2A))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonVentana3A)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(LabelCons6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(63, 63, 63))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(ButtonFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCons2)
                            .addComponent(LabelCons1)
                            .addComponent(LabelCons3))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonVentana1)
                            .addComponent(BotonVentana2)
                            .addComponent(BotonVentana3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCons4)
                            .addComponent(LabelCons5)
                            .addComponent(LabelCons6))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTítulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTítulo2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelPacient)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TextPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNacim)
                            .addComponent(TextFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TextDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabNum)
                            .addComponent(TextNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSeleccion)
                            .addComponent(jLabel4))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVentana3A)
                            .addComponent(BotonVentana1A)
                            .addComponent(BotonVentana2A))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonInfarto)
                            .addComponent(ButtonSangre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonPancita)
                            .addComponent(ButtonHuesito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonParto)
                            .addComponent(ButtonOtro))
                        .addGap(18, 18, 18)
                        .addComponent(LabelValoración)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRojo)
                            .addComponent(jButtonAmarillo)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonFicha)
                        .addGap(0, 124, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonInfartoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonInfartoMouseClicked

    }//GEN-LAST:event_ButtonInfartoMouseClicked

    private void ButtonInfartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInfartoActionPerformed
        tipoEnfermedad="Infarto";
        totalInfarto++;
    }//GEN-LAST:event_ButtonInfartoActionPerformed

    private void ButtonSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSangreActionPerformed
         tipoEnfermedad="Perdida de sangre";
        totalSangre++;
    }//GEN-LAST:event_ButtonSangreActionPerformed

    private void TextPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPacienteActionPerformed

    }//GEN-LAST:event_TextPacienteActionPerformed

    private void TextDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDetalleActionPerformed

    private void ButtonFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFichaActionPerformed
        agregar();
        generarficha();
    }//GEN-LAST:event_ButtonFichaActionPerformed

    private void ButtonPancitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPancitaActionPerformed
        tipoEnfermedad="Dolor de estomago";
        totalPancita++;
    }//GEN-LAST:event_ButtonPancitaActionPerformed

    private void ButtonPartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPartoActionPerformed
        tipoEnfermedad="Parto";
        totalPartos++;
    }//GEN-LAST:event_ButtonPartoActionPerformed

    private void ButtonHuesitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHuesitoActionPerformed
         tipoEnfermedad="Quebradura";
        totalQuebradura++;
    }//GEN-LAST:event_ButtonHuesitoActionPerformed

    private void ButtonOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOtroActionPerformed
         tipoEnfermedad="Otros";
        totalOtros++;
    }//GEN-LAST:event_ButtonOtroActionPerformed

    private void jButtonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRojoActionPerformed
        tipoColor="Rojo";
        totalRojas++;
    }//GEN-LAST:event_jButtonRojoActionPerformed

    private void jButtonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAmarilloActionPerformed
       tipoColor="Amarillo";
       totalAmarillos++;
    }//GEN-LAST:event_jButtonAmarilloActionPerformed

    private void BotonVentana1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1ActionPerformed
        // TODO add your handling code here:
         /**
         * Se hacen los cambios del boton de atender en la ventana, se extrae al cliente de la cola o el heap
         * dependiendo de lo que se haya configurado y se agrega el cliente a la cola de seguridad
         */
        if("Verde".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c2.isEmpty()==false){
                    BotonVentana1.setText("Liberar y atender");
                    Patient data=(Patient) c2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana1.setText("Atender");
                }
            }
            else{
                if(h2.isEmpty()==false){
                    BotonVentana1.setText("Liberar y atender");
                    Patient data=(Patient) h2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana1.setText("Atender");
                }
            }
        }       
    }//GEN-LAST:event_BotonVentana1ActionPerformed

    private void BotonVentana2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana2ActionPerformed
        if("Verde".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c2.isEmpty()==false){
                    BotonVentana2.setText("Liberar y atender");
                    Patient data=(Patient) c2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana2.setText("Atender");
                }
            }
            else{
                if(h2.isEmpty()==false){
                    BotonVentana2.setText("Liberar y atender");
                    Patient data=(Patient) h2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana2.setText("Atender");
                }
            }
        }
        
    }//GEN-LAST:event_BotonVentana2ActionPerformed

    private void BotonVentana3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3ActionPerformed
        if("Verde".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c2.isEmpty()==false){
                    BotonVentana3.setText("Liberar y atender");
                    Patient data=(Patient) c2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana3.setText("Atender");
                }
            }
            else{
                if(h2.isEmpty()==false){
                    BotonVentana3.setText("Liberar y atender");
                    Patient data=(Patient) h2.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana3.setText("Atender");
                }
            }
    }//GEN-LAST:event_BotonVentana3ActionPerformed
    }
        
    private void BotonVentana3AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3AActionPerformed
         if("Amarillo".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c3.isEmpty()==false){
                    BotonVentana3A.setText("Liberar y atender");
                    Patient data=(Patient) c3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana3A.setText("Atender");
                }
            }
            else{
                if(h3.isEmpty()==false){
                    BotonVentana3A.setText("Liberar y atender");
                    Patient data=(Patient) h3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana3A.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana3AActionPerformed

    private void BotonVentana1AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1AActionPerformed
         if("Amarillo".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c3.isEmpty()==false){
                    BotonVentana1A.setText("Liberar y atender");
                    Patient data=(Patient) c3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana1A.setText("Atender");
                }
            }
            else{
                if(h3.isEmpty()==false){
                    BotonVentana1A.setText("Liberar y atender");
                    Patient data=(Patient) h3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana1A.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana1AActionPerformed

    private void BotonVentana2AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana2AActionPerformed
           if("Amarillo".equals(tipoColor)){
            if("cola".equals(tipoEnfermedad)){
                if(c3.isEmpty()==false){
                    BotonVentana2A.setText("Liberar y atender");
                    Patient data=(Patient) c3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana2A.setText("Atender");
                }
            }
            else{
                if(h3.isEmpty()==false){
                    BotonVentana2A.setText("Liberar y atender");
                    Patient data=(Patient) h3.extract();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+data.getName()+" en Ventana 1");
                    //int prioridad=1;
                    colaSeguridad.create(data);
                }
                else{
                    BotonVentana2A.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana2AActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tipoColor="Verde";
        totalVerde++;
    }//GEN-LAST:event_jButton1ActionPerformed
    

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new interfaz().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVentana1;
    private javax.swing.JButton BotonVentana1A;
    private javax.swing.JButton BotonVentana2;
    private javax.swing.JButton BotonVentana2A;
    private javax.swing.JButton BotonVentana3;
    private javax.swing.JButton BotonVentana3A;
    private javax.swing.JButton ButtonFicha;
    private javax.swing.JButton ButtonHuesito;
    private javax.swing.JButton ButtonInfarto;
    private javax.swing.JButton ButtonOtro;
    private javax.swing.JButton ButtonPancita;
    private javax.swing.JButton ButtonParto;
    private javax.swing.JButton ButtonSangre;
    private javax.swing.JLabel LabNum;
    private javax.swing.JLabel LabelCons1;
    private javax.swing.JLabel LabelCons2;
    private javax.swing.JLabel LabelCons3;
    private javax.swing.JLabel LabelCons4;
    private javax.swing.JLabel LabelCons5;
    private javax.swing.JLabel LabelCons6;
    private javax.swing.JLabel LabelNacim;
    private javax.swing.JLabel LabelPacient;
    private javax.swing.JLabel LabelSeleccion;
    private javax.swing.JLabel LabelTítulo1;
    private javax.swing.JLabel LabelTítulo2;
    private javax.swing.JLabel LabelValoración;
    private javax.swing.JTextField TextDetalle;
    private javax.swing.JTextField TextFechaNac;
    private javax.swing.JTextField TextNum;
    private javax.swing.JTextField TextPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAmarillo;
    private javax.swing.JButton jButtonRojo;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
