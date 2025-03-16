/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pong.vapor;

/**
 *
 * @author Adriane
 */
public class OnlineAccount {
    int id; String username; double balance;
    
    OnlineAccount(){};
    
    OnlineAccount(int id, String username, double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }
}
