package Metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class BienestarInf {
    public String NumeroRegis[];
    public String Nombre[];
    public int Años[];
    public float Talla[];
    public float Peso[];
    public String Municipio[];
    
    public BienestarInf(JTextField jtfNInfor){
        int i;
        
        NumeroRegis = new String[Integer.parseInt(jtfNInfor.getText())];
        Nombre = new String[Integer.parseInt(jtfNInfor.getText())];
        Años = new int[Integer.parseInt(jtfNInfor.getText())];
        Talla = new float[Integer.parseInt(jtfNInfor.getText())];
        Peso = new float[Integer.parseInt(jtfNInfor.getText())];
        Municipio = new String[Integer.parseInt(jtfNInfor.getText())];
        
        //Inicializamos los vectores vacíos:
        for(i=0; i<NumeroRegis.length; i++){
            NumeroRegis[i]= "";
            Nombre[i] = "";
            Años[i]= 0;
            Talla[i] = 0;
            Peso[i] = 0;
            Municipio[i] = "";
        }
        JOptionPane.showMessageDialog(null, "Vectores Inicializados!");
    }
    
     public int getBuscarP(String numeroRgis){
        int i;
        for(i=0; i<NumeroRegis.length; i++){
            if(NumeroRegis[i].equals(numeroRgis)==true)
                return i;
        }
        return -1;
    }
      public void Mostrar(String vecRes[]) {
        int i;
        String informacion = "";
            for (i = 0; i < vecRes.length; i++) {
                informacion += "La informacion del niño   " + i + " es :"
                        + vecRes[i] + "\n";
            }
            JOptionPane.showMessageDialog(null,
                    "El registro es: \n" + informacion);
        }
      
      

      
      public boolean setAddInfo( JTextField  jtfNumeroReg,JTextField jtfnombre,      
       JTextField jtfaños, JTextField jtftalla, JTextField jtfpeso, JTextField jtfmunicipio, int indice        
    ){        
       if(getBuscarP(jtfNumeroReg.getText())!=-1){
            JOptionPane.showMessageDialog(null,
                "El registro del niño ya se encuentra "
                + "registrado!  Intente nuevamente.");
            jtfNumeroReg.setText("");
            jtfNumeroReg.requestFocus(); 
            return false;
        }else{                                                      
            NumeroRegis[indice] = jtfNumeroReg.getText();
            Nombre[indice]= (jtfnombre.getText());
            Años[indice]=Integer.parseInt(jtfaños.getText());
            Talla[indice] = Float.parseFloat(jtftalla.getText());
            Peso[indice] = Float.parseFloat(jtfpeso.getText());
            Municipio[indice] = jtfmunicipio.getText();
            jtfNumeroReg.setText("");
            jtfnombre.setText("");
            jtfaños.setText("");
            jtftalla.setText("");
            jtfpeso.setText("");
            jtfmunicipio.setText("");
            jtfNumeroReg.requestFocus(); 
            return true;           
        }
    }
      
       public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, int indiceArray){
        
        miModelo.setValueAt(NumeroRegis[indiceArray], Fila, 0);
        miModelo.setValueAt(Nombre[indiceArray], Fila, 1);
        miModelo.setValueAt(Años[indiceArray], Fila, 2); 
        miModelo.setValueAt(Talla[indiceArray], Fila,3);
        miModelo.setValueAt(Peso[indiceArray], Fila, 4);
        miModelo.setValueAt(Municipio[indiceArray], Fila, 5);
    }   
        public void setLlenarJTable(JTable tab){
        int indice=0; //Este índice recorre los elementos del ArrayList
        int i=0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Numero de registro ");
        miModelo.addColumn("Nombre del niño");
        miModelo.addColumn("Edad del niño");
        miModelo.addColumn("Talla del niño");
        miModelo.addColumn("Peso del niño");
        miModelo.addColumn("Municipio");
        while(indice<NumeroRegis.length){                        
            miModelo.addRow(new Object[]{"", "","","","",""});              
            setRegistrarFilaJTable(miModelo,i,indice);            
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }    

  
     
}
