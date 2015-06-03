/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author EdwardLeonardi
 */
public class Rule
{
    private String instruction, condition;
    private int iftrue, iffalse;

    public Rule(String input)
    {
        String parts[] = input.split(" ");
        
        instruction = parts[0];
        
        if(parts[1].equals("~"))
        {
            condition = null;
            iftrue = Integer.parseInt(parts[2]);
        }
        
        else if(parts[1].equals("."))
        {
            condition = ".";
        }
        
        else
        {
            condition = parts[1];
            iftrue = Integer.parseInt(parts[2]);
            iffalse = Integer.parseInt(parts[3]);
        }
    }

    public String getInstruction() {
        return instruction;
    }

    public String getCondition() {
        return condition;
    }

    public int getIftrue() {
        return iftrue;
    }

    public int getIffalse() {
        return iffalse;
    }
}
