/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entrymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Stefan
 */
public class Database
{
   final String url;
   final String user;
   final String pw;
   
   private Connection connection = null;
   private Statement statement = null;
   private PreparedStatement preparedStatement = null;
   private ResultSet resultSet = null;

   public Database() throws SQLException
   {
      url = "jdbc:mysql://ramen.cs.man.ac.uk:3306";
      user = "user=11_COMP10120_D1";
      pw = "ztDsBWSMqDny80BR";
   }

   private void testdbconnection()
   {
      try
      {
         connection = DriverManager.getConnection(url, user, pw);
         
         statement = connection.createStatement();
         
         String s = "SELECT *";

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (statement != null)
         {
            try
            {
               statement.close();
            } catch (SQLException e) {
            } // nothing we can do
         }//if
         if (connection != null)
         {
            try
            {
               connection.close();
            } catch (SQLException e) {
            } // nothing we can do
         }//if
      }//finally
   } //testdbconnection
   
   
   //public String
   
   public static void main(String args[]) throws SQLException
   {
      Database db = new Database();
      
      db.testdbconnection();
      
   }//main
}//class DB
