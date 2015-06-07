/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import view.MachineFrame;
import view.Synthetica;

/**
 *
 * @author EdwardLeonardi
 */
public class Driver {
    //Global variable rules to store all rules
    public static ArrayList<Rule> rules;
    public static ArrayList<Result> results;
    
    //main class
    public static void main(String[] args)
    {
        new Synthetica();
        rules = new ArrayList<>(); //Initialize rules
        results = new ArrayList<>();
        new MachineFrame();
    }
}
