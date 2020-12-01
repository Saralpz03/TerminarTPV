/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv3;




import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alexara
 */
public class TPV3 extends Application{

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        launch(args);
 
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v=new VBox(10);
        
        TextField nombre=new TextField();
        TextField pas=new TextField();
        Button registrarse=new Button("Registrarse");
        Label texto=new Label();
        v.getChildren().addAll(nombre,pas,registrarse,texto);
        Scene escena=new Scene(v,200,200);
        stage.setScene(escena);
        stage.show();
        
        registrarse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String usuario="root";
        String clave="";
        String url="jdbc:mysql://localhost:3306/tpv";
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TPV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url,usuario,clave);
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM dependientes WHERE"+nombre+"");
            if(nombre.equals("") && pas.equals("")){
                System.out.println("Puedes pasar");
            }else{
                System.out.println("Tu contraseña o usuario son incorrectos");
            }
            //while(rs.next()){
                //System.out.println(rs.getInt("id_dependiente")+" "+rs.getString("nombre")+" "+rs.getString("password"));
                
            //}
        } catch (SQLException ex) {
            Logger.getLogger(TPV3.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        });
    }
    
    
}
