
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Sentencias_DML extends javax.swing.JFrame {
     Controlador cone= new Controlador();       

    /**
     * Creates new form Sentencias_DML
     */
    public Sentencias_DML() {
        initComponents();
        
    }
    public void insertar(){
    // Opciones para el desplegable
        String[] opciones = {"productos", "empleados", "categorias", "clientes", "pedidos","proveedores","detallespedido","ventas"};
        // Muestra un diálogo con un desplegable y guarda la opción seleccionada
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona un dato:", "Selección de Datos", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        Insertar a=new Insertar(seleccion);
        a.setVisible(true);
    }
    public void actualizar(){
        String[] opciones = {"productos", "empleados", "categorias", "clientes", "pedidos","proveedores","detallespedido","ventas"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona un dato:", "Selección de Datos", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        String numeroStr = JOptionPane.showInputDialog("Por favor, ingrese la id del registro:");
        int numero = 0;
        try {
            // Convierte la entrada del usuario a un número entero
            numero = Integer.parseInt(numeroStr);
            // Haz algo con el número ingresado, por ejemplo, muestra un mensaje con el número
        } catch (NumberFormatException e) {
            // En caso de que la entrada no sea un número válido
            JOptionPane.showMessageDialog(null, "Entrada no válida. Debes ingresar un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(numero>0){
        Actualizar a=new Actualizar(seleccion,numero);
        a.setVisible(true);
    }
    }
    public void borrar(){
    // Opciones para el desplegable
        String[] opciones = {"productos", "empleados", "categorias", "clientes", "pedidos","proveedores","detallespedido","ventas"};
        // Muestra un diálogo con un desplegable y guarda la opción seleccionada
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona un dato:", "Selección de Datos", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        // Crear un JOptionPane para ingresar el número de ID a borrar
        String numeroStr = JOptionPane.showInputDialog("Por favor, ingrese la id del registro:");
        int numero = 0;
        try {
            // Convierte la entrada del usuario a un número entero
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            // En caso de que la entrada no sea un número válido
            JOptionPane.showMessageDialog(null, "Entrada no válida. Debes ingresar un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(numero>0){
            String consulta = "DELETE FROM "+seleccion+" WHERE id = "+numero;
            try {

                    cone.conectar();
                    cone.insert(consulta);
                    JOptionPane.showMessageDialog(null, "Se ha borrado correctamente", "Número ingresado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Sentencias_DML.class.getName()).log(Level.SEVERE, null, ex);            
                }
        }
        


            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        insertar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        insertar.setText("INSERTAR");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        actualizar.setText("ACTUALIZAR");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        borrar.setText("BORRAR");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(actualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(insertar))
                .addGap(41, 41, 41)
                .addComponent(actualizar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
      insertar();
    }//GEN-LAST:event_insertarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
       actualizar();
    }//GEN-LAST:event_actualizarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
       borrar();
    }//GEN-LAST:event_borrarActionPerformed
   
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
            java.util.logging.Logger.getLogger(Sentencias_DML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sentencias_DML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sentencias_DML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sentencias_DML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sentencias_DML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton borrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton insertar;
    // End of variables declaration//GEN-END:variables
}
