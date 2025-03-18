/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pong.vapor;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Adriane
 */
public class staticVar {
    
        // variables where i don't know how to transfer them towards other tabs without using global namespace
        //static Connection conn = DriverManager.getConnection("jdbc:sqlite:vapordb.db");
        static ArrayList<Game> storeResults = new ArrayList<Game>();                // stores the results of the store page queried
        static OnlineAccount userThatIsLoggedIn = new OnlineAccount();              // object that holds the user that is currently logged in
        static Game previewedGame = new Game();                                     // game previewed in store or library
        static ArrayList<Game> userCart = new ArrayList<Game>();
}
