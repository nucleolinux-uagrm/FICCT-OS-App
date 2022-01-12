
package ficctos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author daniel
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public String click="";
    
    
    public MainForm() {
        initComponents();
        this.setResizable(false);
        int x =Toolkit.getDefaultToolkit().getScreenSize().width;
        int y=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize((3*x)/4, (3*y)/4);
        this.setLocation(x/2- ((3*x)/4)/2,y/2 -((3*y)/4)/2);
        this.setTitle("FICCT-OS App");   
        iniciarBotones();
        initTabbedPaneComponents();
        iniciarDescripcion();
    }
    
    private void iniciarBotones(){
        
        String nombres[]={"PseInt","Lazarus","Gambas3","Lazarus","Gambas3","Spyder","Eclipse","Netbeans","CodeBlocks","Workbench","Swi-Prolog","Rustdesk","ThunderBird","LibreOffice","Ranger","Gparted","Terminator","NL-UAGRM","NL-Facebook","NL-Telegram","NL-Github","NL-Youtube"};
        String path="recursos/imagenes/iconos/";
        int limites[]={2,6,8,10,16,nombres.length-1};
        int j=0;
        int y =this.getHeight();
        for (int i=0;i<limites.length;i++){
            int p=0;
            for (;j<=limites[i];j++){
                JButton boton=new JButton();
                javax.swing.JPanel panel = (javax.swing.JPanel)jTabbedPane1.getComponent(i);
                panel.add(boton);
               
                if (p % 2 == 0)
                iniciarBoton(boton, 10, p*(y/8)+10, nombres[j], path+nombres[j]+".png");
                else
                iniciarBoton(boton, 40+y/5, (p-1)*(y/8)+10,nombres[j], path+nombres[j]+".png");
                p++;
                addEvent(boton,nombres[j]);
                
            }
            

        }
        
    }
    
    private void iniciarBoton(javax.swing.JButton b,int posx,int posy,String nombre,String pathIcon){
        int y =this.getHeight();
        b.setBounds(posx,posy, y/4,y/4);
        b.setText(nombre);
        b.setHorizontalTextPosition(b.CENTER);
        b.setVerticalTextPosition(b.BOTTOM);
        b.setFont(new Font("Italic", Font.PLAIN, 18));
        b.setForeground(Color.WHITE);
        
       try{ 
        Image img= new ImageIcon(getClass().getClassLoader().getResource(pathIcon)).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(b.getWidth()/2,b.getHeight()/2, Image.SCALE_DEFAULT));
        b.setIcon(img2);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        img2 = new ImageIcon(img.getScaledInstance(b.getWidth()*3/4,b.getHeight()*3/4, Image.SCALE_DEFAULT));
        b.setPressedIcon(img2);
       }catch(Exception e){
           b.setBackground(Color.BLACK);
       }

    }
    
    
    private void addEvent(JButton boton,String nombre){
        boton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                click=nombre;
                String x;
                try{    //x=Description.getDescripcion(getClass().getClassLoader().getResource("recursos/imagenes/descripciones/"+nombre+".txt").toURI());
                        x=Description.darDescripcion(getClass().getClassLoader().getResourceAsStream("recursos/imagenes/descripciones/"+nombre+".txt"));
                }
                catch(Exception e){
                    x="no encontrado";
                }
                    jTextArea1.setText(x);
            try{    Image img= new ImageIcon(getClass().getClassLoader().getResource("recursos/imagenes/background/"+nombre+".png")).getImage();
                    ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_DEFAULT));
                    jLabel1.setIcon(img2);
                }catch(Exception e){
                    jLabel1.setIcon(null);
                    jLabel1.setText("Imagen no Encontrada");
                }finally{
                    jButton1.setVisible(true);
                }
              
            }
        });
    }

    private void initTabbedPaneComponents(){
        jTabbedPane1.setBounds(0,0,5*this.getWidth()/8,this.getHeight());
        int meta = jTabbedPane1.getComponentCount();
        javax.swing.JPanel panel;
        
        Image img= new ImageIcon(getClass().getClassLoader().getResource("recursos/imagenes/background/background.png")).getImage();
        
        ImageIcon img2; 
        javax.swing.JLabel label;
        
        String names[] ={"1er Semestre","2do Semestre","3er,4to Semestre","5to Semestre","Utilidades","sobre"};
        for (int i=0; i<meta;i++){
          panel = (javax.swing.JPanel)jTabbedPane1.getComponent(i);
          panel.setBounds(0,0,jTabbedPane1.getWidth(),jTabbedPane1.getHeight());
          img2 = new ImageIcon(img.getScaledInstance(panel.getWidth(),panel.getHeight(), Image.SCALE_DEFAULT));
          label = new javax.swing.JLabel();
          label.setIcon(img2);
          panel.add(label);
          label.setBounds(0,0,panel.getWidth(),panel.getHeight());
          
          jTabbedPane1.setTitleAt(i, names[i]);
           
        }

    }
    

    private void iniciarDescripcion(){
        
        jPanel5.setBounds(5*this.getWidth()/8, 0,3*this.getWidth()/8,this.getHeight());
        int a = jPanel5.getWidth()/8;
        jLabel1.setBounds(a,a,jPanel5.getWidth()-2*a,(jPanel5.getHeight()-3*a)/3);
        Image img= new ImageIcon(getClass().getClassLoader().getResource("recursos/imagenes/iconos/ficctOs.png")).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(img2);
        jScrollPane1.setBounds(a,2*a+jLabel1.getHeight(), jPanel5.getWidth()-2*a,jPanel5.getHeight()-3*a-jLabel1.getHeight());
        jButton1.setBounds(a,a+jLabel1.getHeight(), jPanel5.getWidth()-2*a,a);
        jButton1.setText("Iniciar");
        jButton1.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel5.setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(5);
        jTextArea1.setText("Esta aplicacion fue desarrollada\npor el grupo de estudiantes\nparte del Nucleo Linux UAGRM\nde la facultad de Cs de la\ncomputacion y telecomunicaciones.\nPara tener un mejor \nacceso a las aplicaciones \npreinstaladas en la distribución\nGNU/Linux FICCT-OS, y facilitar el uso a los\nestudiantes.\n\nRealizado por:\n\n- Daniel Maldonado Gutierrez.\n- Jorge Gary Fernandez Lopez.\n- Juan Vladimir Ramirez Flores.\n- Felix Fernando Apaza Caseres.");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 280, 170);

        jLabel1.setText("jLabel1");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(70, 40, 120, 50);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(70, 100, 67, 29);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(340, 20, 300, 310);

        jPanel1.setLayout(null);
        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setLayout(null);
        jTabbedPane1.addTab("tab3", jPanel3);

        jPanel2.setLayout(null);
        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel4.setLayout(null);
        jTabbedPane1.addTab("tab4", jPanel4);

        jPanel7.setLayout(null);
        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel6.setLayout(null);
        jTabbedPane1.addTab("tab5", jPanel6);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 60, 300, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String comando="";
        switch (click) {
            case "Lazarus":
                comando="/usr/bin/lazarus-ide-2.0.6 %f";
                break;
            case "PseInt":
                comando="/usr/share/pseint/bin/../wxPSeInt";
                break;    
            case "Gambas3":
                comando="/usr/bin/gambas3";
                break;
            case "Spyder":
                comando="/usr/local/bin/spyder";
                break;
            case "Eclipse":
                comando="/usr/share/eclipse/eclipse";
                break;
            case "Netbeans":
                comando="/bin/sh /usr/share/netbeans-12.6/netbeans/bin/netbeans";
                break;
            case "CodeBlocks":
                comando="/usr/bin/codeblocks %F";
                break;
            case "Workbench":
                comando="/usr/bin/mysql-workbench %f";
                break;
            case "Swi-Prolog":
                comando="/usr/bin/terminator -e swipl";
                break;
            case "Rustdesk":
                comando="/usr/bin/rustdesk";
                break;
            case "ThunderBird":
                comando="/usr/bin/thunderbird";
                break;
            case "Ranger":
                comando="/usr/bin/terminator --working-directory=/home/ -e ranger";
                break;
            case "Gparted":
                comando="/usr/sbin/gparted";
                break;
            case "LibreOffice":
                comando="/usr/bin/libreoffice";
                break;
            case "Terminator":
                comando="/usr/bin/terminator --working-directory=/home/";
                break;
            case "NL-UAGRM":
                comando="gnome-www-browser https://nucleolinux.org";
                break;
            case "NL-Facebook":
                comando="gnome-www-browser https://www.facebook.com/groups/nucleolinux.uagrm";
                break;
            case "NL-Telegram":
                comando="gnome-www-browser https://t.me/nucleolinux_uagrm";
                break;
            case "NL-Github":
                comando="gnome-www-browser https://github.com/nucleolinux-uagrm";
                break;
            case "NL-Youtube":
                comando="gnome-www-browser https://www.youtube.com/channel/UCmJaT1dpxRi0wqwP6i3dq0g";
            
                //finish
        }
        ejecutarComando(comando);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ejecutarComando(String comando){
        try {
            Process process = Runtime.getRuntime().exec(comando);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "El programa fue\neliminado o modificado", "Ups", javax.swing.JOptionPane.WARNING_MESSAGE);
            
        }  
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
   
    //private String commands={"terminator","lazarus"};

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
