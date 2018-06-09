package Modelo;

/**
 *
 * @author David Prados
 */
import java.sql.*;

public class Conexion {
 
    static String bd = "cristotube";
    //static String login = "testpsp";
    //static String password = "@,2,golfoPSP123abcd!";
    //static String url = "jdbc:mysql://52.19.19.65:3306/cristotube" ;
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/cristotube" ;
    

    public static Connection conn = null;
    
    public Conexion() {
        try{
        //obtenemos el driver de para mysql
        Class.forName("com.mysql.jdbc.Driver");
        //obtenemos la conexion
        conn = DriverManager.getConnection(url,login,password);

        if (conn!=null)
            System.out.println("Conexion a base de datos " + bd + " realizada con exito");
        }catch(SQLException e){
        System.out.println(e);
        }catch(ClassNotFoundException e){
        System.out.println(e);
        }catch(Exception e){
        System.out.println(e);
        }
    }
 
    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn = null;
    }
    
    /*******GETS*********/
    public String getBD(){
        return this.bd;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getPassword(){
        return this.password;
    }
        
    public String getUrl(){
        return this.url;
    }
    
    /******SETS******/
    public void setBD(String bd){
        this.bd = bd;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
}