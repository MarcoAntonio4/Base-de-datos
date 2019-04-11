/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Datos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class Metodos {
    static Datos dulces = new Datos();
    static  String sql,numreg; //este string es la consulta
    static ResultSet resultado,resultadoNum; //creamos una variable tipo ResultSet 
    static int totReg;
    
    public static Datos CargarRegistros(){

sql="select * from inventario";
//Intentamos consultar las base de datos concatenando el string de sql mas el nombre de la variable
try{
resultado=Conexion.ejecutarSQLSelect(sql);
if(resultado.first()) //primero sin if y sin el else ;)
{
dulces.barcode=resultado.getInt("barcode");
dulces.nombproduct=resultado.getString("nombproduct");
dulces.pmayoreo=resultado.getString("pmayoreo");
dulces.pindiv=resultado.getString("pindiv");
dulces.undis=resultado.getInt("undis");
dulces.marca=resultado.getString("marca");
}
else
{
JOptionPane.showMessageDialog(null, "No hay ningún registro :P");
dulces.barcode=0;
dulces.nombproduct="";
dulces.pmayoreo="";
dulces.pindiv="";
dulces.undis=0;
dulces.marca="";
}
}
catch (Exception e)
{

e.printStackTrace();
}
return dulces;
}
    
    //este es el metodo para guardar los datos
    
    public static void GuardarRegistro(Datos dulces){

        
        String numreg="";
numreg="select barcode from inventario order by barcode desc";
  
totReg=dulces.barcode;
/*
try{
resultadoNum=Conexion.ejecutarSQLSelect(numreg);



if (resultadoNum.first())
{    
totReg = Integer.parseInt(resultadoNum.getString("barcode")); //pasamos a entero el texto

    System.out.println("DESPUES");
totReg++;
}

}catch (Exception e)
{

e.printStackTrace();
}
*/
//con este codigo es el que se guarda el registro
sql="insert into inventario values(\'"+totReg+"\',\'"+dulces.nombproduct+"\',\'"+dulces.pmayoreo+"\',\'"+dulces.pindiv+"\',\'"+dulces.undis+"\',\'"+dulces.marca+"\')";
//la comilla simple es para poder poner una comilla doble enfrente, para que no se modifique la forma en que el programa lee las comillas
if(Conexion.ejecutarSQL(sql)){
JOptionPane.showMessageDialog(null, "Se ha agregado correctamente");
    }
}
public static void BorrarRegistro(){
    
    sql="delete from inventario where barcode =\'"+dulces.barcode+"\'and nombproduct=\'"+dulces.nombproduct+"\'and pmayoreo=\'"+dulces.pmayoreo+"\'and pindiv=\'"+dulces.pindiv+"\'";
    if(Conexion.ejecutarSQL(sql)){
    JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
    }
}    




public static Datos Siguiente(){
try{
if (resultado.isLast())
{
JOptionPane.showMessageDialog(null, "Último registro de la base");
}
else
{
resultado.next();
dulces.barcode=resultado.getInt("barcode");
dulces.nombproduct=resultado.getString("nombproduct");
dulces.pmayoreo=resultado.getString("pmayoreo");
dulces.pindiv=resultado.getString("pindiv");
dulces.undis=resultado.getInt("undis");
dulces.marca=resultado.getString("marca");
}

}
catch (Exception e)
{
e.printStackTrace();
}
return dulces;
}
public static Datos Anterior(){
try{
if (resultado.isFirst())
{
JOptionPane.showMessageDialog(null, "Primer registro de la base");
}
else
{
resultado.previous();
dulces.barcode=resultado.getInt("barcode");
dulces.nombproduct=resultado.getString("nombproduct");
dulces.pmayoreo=resultado.getString("pmayoreo");
dulces.pindiv=resultado.getString("pindiv");
dulces.undis=resultado.getInt("undis");
dulces.marca=resultado.getString("marca");;
}

}
catch (Exception e)
{
e.printStackTrace();
}
return dulces;
}



    
    
    
}
