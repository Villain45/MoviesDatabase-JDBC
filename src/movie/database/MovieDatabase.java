/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movie.database;

/**
 *
 * @author PRATEEK
 */
import java.sql.*;
import java.util.Scanner;
public class MovieDatabase {

    /**
     * @param args the command line arguments
     */
    public static void createTable() {
        String url = "jdbc:sqlite:C:\\Users\\PRATEEK\\Documents\\NetBeansProjects\\Movie Database\\movies.db";
        String query="CREATE TABLE IF NOT EXISTS MOVIES (\n"+"id integer PRIMARY KEY,\n"+"name text,\n"+"actor text,\n"+"actress text,\n"+"director text,\n"+"yor integer\n"+")";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute(query);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addTable() {
        String url = "jdbc:sqlite:C:\\Users\\PRATEEK\\Documents\\NetBeansProjects\\Movie Database\\movies.db";
        String name,actor,actress,director;
        int id,yor;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter all the details");
        id=sc.nextInt();
        name=sc.next();
        actor=sc.next();
        actress=sc.next();
        director=sc.next();
        yor=sc.nextInt();
        String sql="INSERT INTO movies(id,name,actor,actress,director,yor) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.setString(2, name);
            ps.setString(3, actor);
            ps.setString(4, actress);
            ps.setString(5, director);
            ps.setInt(6, yor);
            ps.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void show() {
     String url = "jdbc:sqlite:C:\\Users\\PRATEEK\\Documents\\NetBeansProjects\\Movie Database\\movies.db";
     String query="SELECT * from movies";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); ResultSet rs=stmt.executeQuery(query)){
            while(rs.next()) {
                System.out.println(rs.getInt("id")+"\t"+
                        rs.getString("name")+"\t"+rs.getString("actor")+"\t"+rs.getString("actress")
                +"\t"+rs.getString("director")+"\t"+rs.getString("yor"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void connectDB()
    {
        Connection conn =  null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\PRATEEK\\Documents\\NetBeansProjects\\Movie Database\\movies.db";  
            conn = DriverManager.getConnection(url);
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
      //  String url="jdbc:mysql://localhost:3000/movies";
      connectDB();
      createTable();
//      addTable();
      show();
    }
    
}
