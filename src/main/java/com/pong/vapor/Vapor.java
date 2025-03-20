/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pong.vapor;

/**
 *
 * @author Adriane
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import org.json.*;

public class Vapor {


   // used to read the json file into a text string
   public static StringBuffer readFile() {
      StringBuffer sb = new StringBuffer();;

      try {

         BufferedReader bReader = new BufferedReader(new FileReader(new File("steamdb.json")));

         String line = bReader.readLine();
         int i = 0;
         while (line != null) {                      
                  sb.append(line);
                  line = bReader.readLine(); // read next line
         }
         bReader.close();

      } catch (Exception e) {
         e.printStackTrace();
      } 

      return sb;
   }
   


   static void parseJsonToDb(JSONArray arr, Connection conn) {
   for (int i = 0; i < arr.length(); i++) {
      try {
         //System.out.print("\033[H\033[2J"); System.out.flush(); System.out.println("Processed " + i + " entries out of " + arr.length() + ".");
         Statement st = conn.createStatement();

            
         PreparedStatement statement = conn.prepareStatement("INSERT INTO games(game_id, name, description, release_date, price, url, developer_id, user_rating, popularity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
         //System.out.println(arr.getJSONObject(i).getString("developers"));

         //ResultSet rs = st.executeQuery("SELECT publisher_id FROM publishers WHERE publisher_name='Rockstar Games'");

         //System.out.println(rs.getInt("publisher_id"));


         if (
            ( // checks if some of the attributes of a JSONObject is not null
               !arr.getJSONObject(i).get("published_store").getClass().getSimpleName().equals("Null") &&
               !arr.getJSONObject(i).get("full_price").getClass().getSimpleName().equals("Null") &&
               !arr.getJSONObject(i).get("store_uscore").getClass().getSimpleName().equals("Null") &&
               !arr.getJSONObject(i).get("igdb_popularity").getClass().getSimpleName().equals("Null")
            ) 
            &&
            (
               (arr.getJSONObject(i).getString("publishers").equals("Rockstar Games") ||
               arr.getJSONObject(i).getString("publishers").equals("Electronic Arts") ||
               arr.getJSONObject(i).getString("publishers").equals("Ubisoft") ||
               arr.getJSONObject(i).getString("publishers").equals("Bethesda Softworks") ||
               arr.getJSONObject(i).getString("publishers").equals("Activision")) ||
                arr.getJSONObject(i).getString("publishers").equals("Valve") ||
               arr.getJSONObject(i).getString("publishers").equals("BANDAI NAMCO Entertainment") ||
                arr.getJSONObject(i).getString("publishers").equals("Xbox Game Studios") ||            
         arr.getJSONObject(i).getString("publishers").equals("SEGA") ||   
         arr.getJSONObject(i).getString("publishers").equals("CAPCOM Co., Ltd.") ||
                 arr.getJSONObject(i).getString("publishers").equals("CD PROJEKT RED") ||   
                         arr.getJSONObject(i).getString("publishers").equals("Square Enix") ||
                 arr.getJSONObject(i).getString("publishers").equals("PlayStation Publishing LLC")
            )
         ) { // checks if game publisher is either of these five publishers
             
                      String hi = arr.getJSONObject(i).getString("genres").split(",")[0];
         ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM genres WHERE genre_name='" + hi + "'");
            if(!rs.isBeforeFirst() && rs.getRow() == 0){                                             // checks if the username is in the accounts table    

                PreparedStatement sst = conn.prepareStatement("INSERT INTO genres(genre_name) VALUES (?)");    
                sst.setString(1, hi);
                    sst.executeUpdate();
                } 

            statement.setInt(1, arr.getJSONObject(i).getInt("sid"));
            statement.setString(2, arr.getJSONObject(i).getString("name"));
            statement.setString(3, arr.getJSONObject(i).getString("description"));
            statement.setString(4, arr.getJSONObject(i).getString("published_store"));
            statement.setDouble(5, arr.getJSONObject(i).getDouble("full_price"));
            statement.setString(6, arr.getJSONObject(i).getString("store_url"));

            ResultSet idkwhattocallthisvar = conn.createStatement().executeQuery("SELECT publisher_id FROM publishers WHERE publisher_name='" + arr.getJSONObject(i).getString("publishers") + "'");
            statement.setInt(7, idkwhattocallthisvar.getInt("publisher_id"));

            statement.setInt(8, arr.getJSONObject(i).getInt("store_uscore"));
            statement.setDouble(9, arr.getJSONObject(i).getDouble("igdb_popularity"));
            statement.executeUpdate();
            
                     PreparedStatement another = conn.prepareStatement("SELECT game_id FROM games WHERE name=?");
         another.setString(1, arr.getJSONObject(i).getString("name"));
         
         ResultSet sss = another.executeQuery();
         
         
         PreparedStatement another2 = conn.prepareStatement("SELECT genre_id FROM genres WHERE genre_name=?");
         another2.setString(1, arr.getJSONObject(i).getString("genres").split(",")[0]);
         ResultSet genreid = another2.executeQuery();
         
         
         
         PreparedStatement LASTGENRE = conn.prepareStatement("INSERT INTO game_genres(game_id, genre_id) VALUES (?, ?)"); 
         LASTGENRE.setInt(1, sss.getInt("game_id"));
         LASTGENRE.setInt(2, genreid.getInt("genre_id"));
         LASTGENRE.executeUpdate();
         }



            
         //  PreparedStatement statement = conn.prepareStatement("INSERT INTO songs(id, name, artist, album) VALUES (?, ?, ?, ?)");


            
      } catch (Exception e) { // This should throw if spotify_track_uri is null
         e.printStackTrace();
      }

   }
}

   public static void main(String[] args) {
//      StringBuffer jsonSB = readFile();
//      JSONObject jsonObj = new JSONObject(jsonSB);
//
//      System.out.println("Parsing JSON File...");
//      JSONArray jsonArr = new JSONArray(jsonSB.toString());
//      System.out.println("Done Parsing.");

      Connection conn = null;
      try {
         // conn = DriverManager.getConnection("jdbc:sqlite:vapordb.db");
         
         // Uncomment this to parse json file to db
         //parseJsonToDb(jsonArr, conn);
         
         new Login().setVisible(true);
//         ResultSet rs = conn.createStatement().executeQuery("SELECT publisher_id FROM publishers WHERE publisher_name='Rockstar Games'");
//         System.out.println(rs.getInt(""));

         //System.out.println(rs.getInt("publisher_id"));
         


      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}