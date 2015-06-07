/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.TableModelEvent;
import model.Driver;
import model.Result;
import model.Rule;
import model.Tape;

/**
 *
 * @author EdwardLeonardi
 */
public class MachineFrame extends JFrame{
    private JLabel tmLabel, tapeLabel, instLabel, condLabel, trueLabel, falseLabel, rulesLabel, indexLabel;
    private JButton LeBtn, ReBtn, aBtn, LBtn, RBtn, eBtn, insBtn, runBtn, popBtn;
    private JTextField tapeField, ruleField, indexField, trueField, falseField;
    private RuleTable ruleMdl;
    private JTable ruleTbl;
    private JScrollPane ruleScr;
    private JPanel topPane, centerPane, bottomPane, btnPane, condPane, runPane, tfPane, indexPane;
    private Container contain;
    private GridBagConstraints gc;
    private JComboBox condCB;
    String[] condCombo = {"", "α!=#", "α=#"};
    
    public MachineFrame()
    {
        super("Turing Machine");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        initcomponents();
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void initcomponents()
    {
        //Creating Panel
        contain = getContentPane();
        contain.setLayout(new BorderLayout());
        
        //Adding Panel
        topPane = new JPanel();
        topPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPane.setLayout(new FlowLayout());
        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        condPane = new JPanel();
        condPane.setBorder(new EmptyBorder(10, -3, 10, 10));
        condPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnPane = new JPanel();
        btnPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnPane.setLayout(new FlowLayout());
        runPane = new JPanel();
        runPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        runPane.setLayout(new FlowLayout());
        indexPane = new JPanel();
        indexPane.setBorder(new EmptyBorder(10, -5, 10, 10));
        indexPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Initialize labels
        tmLabel = new JLabel("TURING MACHINE");
        tmLabel.setFont(tmLabel.getFont().deriveFont(24.0f));
        tapeLabel = new JLabel("Tape :");
        instLabel = new JLabel("Instruction :");
        condLabel = new JLabel("Condition :");
        trueLabel = new JLabel("    True :");
        falseLabel = new JLabel("   False :");
        rulesLabel = new JLabel("Rules :");
        indexLabel = new JLabel("Index :");
        
        //Initialize buttons
        LeBtn = new JButton("L#");
        LeBtn.setPreferredSize(new Dimension(50, 30));
        ReBtn = new JButton("R#");
        ReBtn.setPreferredSize(new Dimension(50, 30));
        aBtn = new JButton("α");
        aBtn.setPreferredSize(new Dimension(50, 30));
        LBtn = new JButton("L");
        LBtn.setPreferredSize(new Dimension(50, 30));
        RBtn = new JButton("R");
        RBtn.setPreferredSize(new Dimension(50, 30));
        eBtn = new JButton("#");
        eBtn.setPreferredSize(new Dimension(50, 30));
        insBtn = new JButton("Insert");
        insBtn.setPreferredSize(new Dimension(90, 30));
        runBtn = new JButton("Run");
        runBtn.setPreferredSize(new Dimension(90, 30));
        popBtn = new JButton("Pop");
        popBtn.setPreferredSize(new Dimension(90, 30));
        
        //Initialize textfields
        tapeField = new JTextField();
        tapeField.setPreferredSize(new Dimension(300, 30));
        ruleField = new JTextField();
        ruleField.setPreferredSize(new Dimension(300, 30));
        indexField = new JTextField();
        indexField.setPreferredSize(new Dimension(50, 30));
        trueField = new JTextField();
        trueField.setPreferredSize(new Dimension(50, 30));
        falseField = new JTextField();
        falseField.setPreferredSize(new Dimension(50, 30));
        
        condCB = new JComboBox(condCombo);
        condCB.setPreferredSize(new Dimension(70, 30));
        
        //Initialize tables
        ruleMdl = new RuleTable();
        ruleTbl = new JTable(ruleMdl);
        ruleScr = new JScrollPane(ruleTbl);
        ruleScr.setPreferredSize(new Dimension(500, 150));
        
        //Initialize Grid Bag Constraints
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 25, 10, 25);
        
        btnPane.add(LeBtn);
        btnPane.add(ReBtn);
        btnPane.add(aBtn);
        btnPane.add(LBtn);
        btnPane.add(RBtn);
        btnPane.add(eBtn);
        
        condPane.add(condCB);
        condPane.add(trueLabel);
        condPane.add(trueField);
        
        runPane.add(runBtn);
        
        indexPane.add(indexField);
        
        topPane.add(tmLabel);
        
        gc.gridx = 0;
        gc.gridy = 0;
        centerPane.add(tapeLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        centerPane.add(tapeField, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        centerPane.add(indexLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        centerPane.add(indexPane, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        centerPane.add(instLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        centerPane.add(ruleField, gc);
        
        gc.gridx = 2;
        gc.gridy = 2;
        centerPane.add(insBtn, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        centerPane.add(btnPane, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        centerPane.add(condLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        centerPane.add(condPane, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        centerPane.add(rulesLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        centerPane.add(ruleScr, gc);
        
        gc.gridx = 2;
        gc.gridy = 5;
        centerPane.add(popBtn, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        centerPane.add(runPane, gc);
        
        //Adding Panel to Container
        contain.add(topPane, BorderLayout.NORTH);
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        addListener(new handler());
    }
    
    public void addListener(ActionListener listenForBtn)
    {
        LeBtn.addActionListener(listenForBtn);
        ReBtn.addActionListener(listenForBtn);
        aBtn.addActionListener(listenForBtn);
        LBtn.addActionListener(listenForBtn);
        RBtn.addActionListener(listenForBtn);
        eBtn.addActionListener(listenForBtn);
        insBtn.addActionListener(listenForBtn);
        popBtn.addActionListener(listenForBtn);
        condCB.addActionListener(listenForBtn);
        runBtn.addActionListener(listenForBtn);
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            String etimes;
            
            if(evt.getSource() == LeBtn)
            {
                etimes = JOptionPane.showInputDialog("How many empties?");
                
                try
                {
                    if(Integer.parseInt(etimes) == 1)
                    {
                        ruleField.setText(ruleField.getText() + "L^#");
                    }

                    else if(Integer.parseInt(etimes) > 1)
                    {
                        ruleField.setText(ruleField.getText() + "L^" + Integer.parseInt(etimes) + "#");
                    }
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            else if(evt.getSource() == ReBtn)
            {
                etimes = JOptionPane.showInputDialog("How many empties?");
                
                try
                {
                    if(Integer.parseInt(etimes) == 1)
                    {
                        ruleField.setText(ruleField.getText() + "R^#");
                    }

                    else if(Integer.parseInt(etimes) > 1)
                    {
                        ruleField.setText(ruleField.getText() + "R^" + Integer.parseInt(etimes) + "#");
                    }
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            else if(evt.getSource() == aBtn)
            {
                ruleField.setText(ruleField.getText() + "a");
            }
            
            else if(evt.getSource() == RBtn)
            {
                ruleField.setText(ruleField.getText() + "R");
            }
            
            else if(evt.getSource() == LBtn)
            {
                ruleField.setText(ruleField.getText() + "L");
            }
            
            else if(evt.getSource() == eBtn)
            {
                ruleField.setText(ruleField.getText() + "#");
            }
            
            else if(evt.getSource() == insBtn)
            {
                String r;
                String i = ruleField.getText().replaceAll("\\s","");
                String c = (String) condCB.getSelectedItem();
                int t = 0, f = 0;
                
                if(c.equals("") && !trueField.getText().equals("") && falseField.getText().equals(""))
                {
                    c = "~";
                    
                    try
                    {
                        t = Integer.parseInt(trueField.getText());
                    }
                    
                    catch(Exception ex)
                    {
                        
                    }
                    
                    r = i + " " + c + " " + t;
                }
                
                else if(c.equals("") && trueField.getText().isEmpty() && falseField.getText().isEmpty())
                {
                    c = ".";
                    
                    r = i + " " + c;
                }
                
                else
                {
                    try
                    {
                        t = Integer.parseInt(trueField.getText());
                        f = Integer.parseInt(falseField.getText());
                        c = c.replaceAll("α", "a");
                    }

                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(centerPane, "Please input a valid integer in true/false fields.");
                    }
                    
                    r = i + " " + c + " " + t + " " + f;
                }
                
                Driver.rules.add(new Rule(r));
                
                ruleField.setText("");
                condCB.setSelectedIndex(0);
                trueField.setText("");
                falseField.setText("");
                
                ruleTbl.tableChanged(new TableModelEvent(ruleTbl.getModel()));
            }
            
            else if(evt.getSource() == runBtn)
            {
                Tape tp = null;
                
                try
                {
                    tp = new Tape(tapeField.getText(), Integer.parseInt(indexField.getText()));
                }
                
                catch(Exception ex)
                {
                    
                }
                
                calculate(tp);
                
                dispose();
                new ResultFrame();
            }
            
            else if(evt.getSource() == popBtn)
            {
                try
                {
                    Driver.rules.remove(Driver.rules.size() - 1);
                    ruleTbl.tableChanged(new TableModelEvent(ruleTbl.getModel()));
                }
                
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(centerPane, "No rules to remove");
                }
            }
            
            else if(evt.getSource() == condCB)
            {
                int sel = condCB.getSelectedIndex();
                
                if(sel == 0)
                {
                    condPane.remove(falseLabel);
                    condPane.remove(falseField);
                    
                    revalidate();
                    repaint();
                }
                
                else
                {
                    condPane.add(falseLabel);
                    condPane.add(falseField);
                    
                    revalidate();
                    repaint();
                }
            }
        }
    }
    
    public void calculate(Tape tp)
    {
        int rCounter = 0, icounter = 0;
        String tempInstruction;
        ArrayList<String> inst;
        ArrayList<Result> res = null;
        String ntape;
        
        //while condition is not end (rCounter is positive or 0)
        while(rCounter >= 0)
        {
            int cond = 1;
            
            //understand the rules
            tempInstruction = Driver.rules.get(rCounter).getInstruction();
            
            inst = getRules(tempInstruction);
            
            //while instruction is not finish
            for(String e : inst)
            {
                ntape = "";
                
                //get tape to String
                for(int t = 0; t < tp.getTape().size(); t++)
                {
                   if(t < tp.getTape().size() - 1)
                   {
                       ntape = ntape + tp.getTape().get(t) + ",";
                   }
                   
                   else
                   {
                       ntape = ntape + tp.getTape().get(t);
                   }
                }
                
                Driver.results.add(new Result(icounter, ntape, tp.getPointer()));
                
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
                icounter++;
            }
            
            if(tp.getCurr() != ' ')
            {
                tp.setLastChar(tp.getCurr());
            }
            
            //if condition exist, or end
            if(Driver.rules.get(rCounter).getCondition() != null)
            {
                //current char is not empty
                if(Driver.rules.get(rCounter).getCondition().equals("a!=#"))
                {
                    if(tp.getCurr() == ' ')
                    {
                        cond = 0;
                    }
                }
                
                //current char is empty
                else if(Driver.rules.get(rCounter).getCondition().equals("a=#"))
                {
                    if(tp.getCurr() != ' ')
                    {
                        cond = 0;
                    }
                }
                
                //end of instruction
                else if(Driver.rules.get(rCounter).getCondition().equals("."))
                {
                    cond = 2;
                }
            }
            
            //condition is true
            if(cond == 1)
            {
                rCounter = Driver.rules.get(rCounter).getIftrue();
            }
            
            //condition is false
            else if(cond == 0)
            {
                rCounter = Driver.rules.get(rCounter).getIffalse();
                cond = 1;
            }
            
            //end of instruction
            else if(cond == 2)
            {
                rCounter = -1;
            }
        }
        
        ntape = "";

        //get tape to String
        for(int t = 0; t < tp.getTape().size(); t++)
        {
           if(t < tp.getTape().size() - 1)
           {
               ntape = ntape + tp.getTape().get(t) + ",";
           }

           else
           {
               ntape = ntape + tp.getTape().get(t);
           }
        }
        
        Driver.results.add(new Result(icounter, ntape, tp.getPointer()));
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
