/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EdwardLeonardi
 */
public class Driver {
    //Global variable rules to store all rules
    public static ArrayList<Rule> rules;
    
    //main class
    public static void main(String[] args)
    {
        rules = new ArrayList<>(); //Initialize rules
        
        ArrayList<Character> chars = new ArrayList<>();
        String in, filename;
        int start; //starting point of the tape
        
        Scanner sc = new Scanner(System.in); //Scanner to get user input
        
        System.out.println("Input tape with <space> as empty");
        in = sc.nextLine(); //get string from user, store in variable named "in". uses nextLine() instead of next() to get spaces in the string
        
        System.out.println("Where is the pointer located at the tape (index starts with 0)?");
        start = sc.nextInt();
        
        Tape tp = new Tape(in, start); //Create new object named tape, and initialize by passing the argument in
        
        chars = tp.getTape();
        
        System.out.println("What rules do you want to use?");
        filename = sc.next();
        
        FileRead fr = new FileRead(filename);
        fr.readFile();
        
        int rCounter = 0;
        String tempInstruction;
        ArrayList<String> inst;
        
        //while condition is not end (rCounter is positive or 0)
        while(rCounter >= 0)
        {
            int cond = 1;
            
            //understand the rules
            tempInstruction = rules.get(rCounter).getInstruction();
            
            inst = getRules(tempInstruction);
            
            //while instruction is not finish
            for(String e : inst)
            {
                System.out.println(e);
                System.out.println(tp.getTape());
                System.out.println("Pointer : " + tp.getPointer());
                System.out.println("Last Char : " + tp.getLastChar());
                System.out.println();
                
                //check instruction group (by instruction length)
                if(e.length() == 2)
                {
                    //go right instruction
                    if(e.equals("GR"))
                    {
                        tp.goRight();
                    }
                    
                    //go left instruction
                    else if(e.equals("GL"))
                    {
                        tp.goLeft();
                    }
                    
                    //write empty instruction
                    else if(e.equals("WE"))
                    {
                        tp.writeChar(' ');
                    }
                }
                
                //check instruction group (by instruction length)
                else if(e.length() == 3)
                {
                    //write last char
                    if(e.equals("WLC"))
                    {
                        tp.writeChar(tp.getLastChar());
                    }
                    
                    //go right until empty
                    else if(e.equals("RuE"))
                    {
                        tp.goRight();
                        
                        //while it hasn't found empty, or it is not at the end of the tape
                        while(tp.getCurr() != ' ' && tp.getPointer() + 1 < tp.getTape().size())
                        {
                            tp.goRight();
                        }
                        
                        //if it's at the end of the tape and it is not empty
                        if(tp.getPointer() + 1 >= tp.getTape().size() && tp.getCurr() != ' ')
                        {
                            tp.getTape().add(' '); //add empty at end
                            tp.goRight(); //move pointer forward
                        }
                    }
                    
                    //go left until empty
                    else if(e.equals("LuE"))
                    {
                        tp.goLeft();
                        
                         //while it hasn't found empty, or it is not at the beginning of the tape
                        while(tp.getCurr() != ' ' && tp.getPointer() > 0)
                        {
                            tp.goLeft();
                        }
                        
                        //if it's at the beginning of the tape and it is not empty
                        if(tp.getPointer() <= 0 && tp.getCurr() != ' ')
                        {
                            tp.getTape().add(0, ' '); //add empty at beginning
                        }
                    }
                }
                
                //check instruction group (by instruction length)
                else if(e.length() == 4)
                {
                    //get number of times
                    int time = Integer.parseInt("" + e.charAt(2));
                    int counter = 0; //to check how many times have encountered empty
                    
                    //go right until x empties
                    if(e.charAt(0) == 'R')
                    {
                        tp.goRight();
                        
                        //add counter if empty is found
                        if(tp.getCurr() == ' ')
                        {
                            counter++;
                        }
                        
                        //while it hasn't encountered empty as much as it is stated, and it has not reach the end of the tape
                        while(counter != time && tp.getPointer() + 1 < tp.getTape().size())
                        {
                            tp.goRight();
                            
                            //add counter if empty is found
                            if(tp.getCurr() == ' ')
                            {
                                counter++;
                            }
                        }
                        
                        //if it reached the end of the tape and still hasn't encountered enough empties
                        while(counter != time)
                        {
                            tp.getTape().add(' '); //create empties as much as times
                            tp.goRight();
                            counter++;
                        }
                    }
                    
                    //go left until x empties
                    else if(e.charAt(0) == 'L')
                    {
                        tp.goLeft();
                        
                        if(tp.getCurr() == ' ')
                        {
                            counter++;
                        }
                        
                        //while it hasn't encountered empty as much as it is stated, and it has not reach the beginning of the tape
                        while(counter != time && tp.getPointer() > 0)
                        {
                            tp.goLeft();
                            
                            if(tp.getCurr() == ' ')
                            {
                                counter++;
                            }
                        }
                        
                        //if it reached the beginning of the tape and still hasn't encountered enough empties
                        while(counter != time)
                        {
                            tp.getTape().add(0, ' '); //create empties as much as times
                            counter++;
                        }
                    }
                }
            }
            
            if(tp.getCurr() != ' ')
            {
                tp.setLastChar(tp.getCurr());
            }
            
            //if condition exist, or end
            if(rules.get(rCounter).getCondition() != null)
            {
                //current char is not empty
                if(rules.get(rCounter).getCondition().equals("a!=#"))
                {
                    if(tp.getCurr() == ' ')
                    {
                        cond = 0;
                    }
                }
                
                //current char is empty
                else if(rules.get(rCounter).getCondition().equals("a=#"))
                {
                    if(tp.getCurr() != ' ')
                    {
                        cond = 0;
                    }
                }
                
                //end of instruction
                else if(rules.get(rCounter).getCondition().equals("."))
                {
                    cond = 2;
                }
            }
            
            //condition is true
            if(cond == 1)
            {
                rCounter = rules.get(rCounter).getIftrue();
            }
            
            //condition is false
            else if(cond == 0)
            {
                rCounter = rules.get(rCounter).getIffalse();
                cond = 1;
            }
            
            //end of instruction
            else if(cond == 2)
            {
                rCounter = -1;
            }
        }
        
        System.out.println(tp.getTape());
        System.out.println("Pointer : " + tp.getPointer());
    }
    
    //getRules function
    public static ArrayList<String> getRules(String instruction)
    {
        ArrayList<String> instruct = new ArrayList<>();
        
        for(int c = 0; c < instruction.length(); c++)
        {
            boolean subs = false;
            
            try
            {
                //if there is subscript
                if(instruction.charAt(c + 1) == '^')
                {
                    subs = true;
                }
            }
            
            catch(Exception ex)
            {
                
            }
            
            //if no subscript
            if(!subs)
            {
                //go right
                if(instruction.charAt(c) == 'R')
                {
                    instruct.add("GR");
                }

                //go left
                else if(instruction.charAt(c) == 'L')
                {
                    instruct.add("GL");
                }

                //write last char
                else if(instruction.charAt(c) == 'a')
                {
                    instruct.add("WLC");
                }

                //write empty
                else if(instruction.charAt(c) == '#')
                {
                    instruct.add("WE");
                }
            }
            
            //if there is subscript
            else
            {
                boolean once = false;
                
                try
                {
                    //if only one time empty
                    if(instruction.charAt(c + 2) == '#')
                    {
                        once = true;
                    }
                }
                
                catch(Exception ex)
                {
                    
                }
                
                //one time empty
                if(once)
                {
                    //go right until empty
                    if(instruction.charAt(c) == 'R')
                    {
                        instruct.add("RuE");
                    }
                    
                    //go left until empty
                    else if(instruction.charAt(c) == 'L')
                    {
                        instruct.add("LuE");
                    }
                    
                    c = c + 2;
                }
                
                //x times empty
                else
                {
                    //go right until x times empty
                    if(instruction.charAt(c) == 'R')
                    {
                        instruct.add("Ru" + instruction.charAt(c + 2) + "E");
                    }
                    
                    //go left until x times empty
                    else if(instruction.charAt(c) == 'L')
                    {
                        instruct.add("Lu" + instruction.charAt(c + 2) + "E");
                    }
                    
                    c = c + 3;
                }
                
                //reset boolean value
                subs = false;
            }
        }
        
        return instruct;
    }
}
