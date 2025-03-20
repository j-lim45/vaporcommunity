/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pong.vapor;

/**
 *
 * @author Adriane
 */
public class Game {
        int id; String name; String description; double price; String releaseDate; int publisherId; int userRating; double popularity;
    
    // placeholder for a null object before initializing
    Game(){}
    
    // who needs set or get methods?
    Game(int id, String name, String description, double price, String releaseDate, int publisherId, int userRating, double popularity) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.price = price;
        this.releaseDate = releaseDate;
        this.publisherId = publisherId;
        this.userRating = userRating;
        this.popularity = popularity;
    }
}
