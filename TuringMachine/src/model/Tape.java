/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author EdwardLeonardi
 */

//User input in turing machine tape
public class Tape {
    private int pointer;
    private ArrayList<Character> tape = new ArrayList<>();
    private char lastChar;
    
    public Tape(String input, int pointer)
    {
        //Splits String into ArrayList of characters
        for(int a = 0; a < input.length(); a++) //while the counter is smaller than the length of the string, keep traversing
        {
            tape.add(input.charAt(a)); //get the character at the pointer (counter) of the string and put it into the arraylist
        }
        
        this.pointer = pointer;
    }

    //tape getter
    public ArrayList<Character> getTape()
    {
        return tape;
    }
    
    public char getCurr()
    {
        return tape.get(pointer);
    }

    public int getPointer() {
        return pointer;
    }

    public void goLeft() {
        pointer = pointer - 1;
    }
    
    public void goRight()
    {
        pointer = pointer + 1;
    }
    
    public void setPointer(int pointer)
    {
        this.pointer = pointer;
    }
    
    public void setLastChar(char lastChar)
    {
        this.lastChar = lastChar;
    }
    
    public char getLastChar()
    {
        return lastChar;
    }
    
    public void writeChar(char write)
    {
        tape.set(pointer, write);
    }
}
