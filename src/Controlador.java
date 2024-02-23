
import java.io.IOException;
import java.util.TimeZone;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Usuario
 */
public class Controlador {
    //atributos
    private static final String CONTROLADOR="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/TiendaAD?useSSL=false";
    private static final String usuario="root";
    private static final String pass="1234";
    private static Connection connection;
    private Statement stm=null;
  //constructores
    public Controlador() {
    }
    public void conectar() throws ClassNotFoundException, SQLException{
        if(connection==null || connection.isClosed()){
		
		try {
			connection =DriverManager.getConnection(url,usuario,pass);
			System.out.println("Conexion ok");
			stm=connection.createStatement();
		}
		catch(SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
            
    }
    }
    public void desconectar() throws SQLException, IOException{
        if(connection!=null && !connection.isClosed()){
            connection.close();
        }
    }
    public int insert(String consulta) throws SQLException{
        int fila = stm.executeUpdate(consulta);
        return fila;
    }
     public int delete(String consulta) throws SQLException{
        int fila = stm.executeUpdate(consulta);
        return fila;
    }
    public int update(String consulta) throws SQLException{
        int fila = stm.executeUpdate(consulta);
        return fila;
    }
    public String like(String busqueda) {
        String texto = "";
        //Muestra la consulta realizada
        try {
            String consulta = "SELECT * FROM PRODUCTOS WHERE nombre LIKE "+busqueda;
            PreparedStatement stmt = connection.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                texto = texto + rs.getString("ID")+"\n"+rs.getString("Nombre")+"\n"+rs.getString("Precio")+"\n"+rs.getString("Categoria_id")+"\n"+rs.getString("Proveedor_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texto;
    }
    public String join() {
        String texto="";
        //Muestra la consulta realizada
        try {
            String consulta = "SELECT PRODUCTOS.NOMBRE, PROVEEDORES.NOMBRE FROM PRODUCTOS INNER JOIN PROVEEDORES ON PRODUCTOS.PROVEEDOR_ID = PROVEEDORES.id";
            ResultSet rs = stm.executeQuery(consulta);
            while (rs.next()) {
                texto = texto + rs.getString("Productos.nombre")+" "+rs.getString("Proveedores.nombre")+"\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texto;
    }
    public String groupby() {
        String texto="";
        //Muestra la consulta realizada
        try {
            String consulta = "SELECT proveedor_id, COUNT(*) AS CUENTA FROM Productos GROUP BY proveedor_id";           
            ResultSet rs = stm.executeQuery(consulta);
            while (rs.next()) {
                texto = texto + rs.getString("proveedor_id")+" "+rs.getString("CUENTA")+"\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texto;
    }
}
