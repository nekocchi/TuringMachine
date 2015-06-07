/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Driver;
import model.Rule;

/**
 *
 * @author EdwardLeonardi
 */
public class RuleTable extends AbstractTableModel{
    private ArrayList<Rule> rules = new ArrayList<>();
    
    public RuleTable()
    {
        rules = Driver.rules;
    }
    
    @Override
    public int getRowCount() {
        return rules.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class type = String.class;
        
        if(columnIndex >= 2)
        {
            type = Integer.class;
        }
        
        return type;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rule rule = rules.get(rowIndex);
        Object value = null;
        
        if(columnIndex == 0)
        {
            value = rule.getInstruction();
        }
        
        else if(columnIndex == 1)
        {
            if(rule.getCondition() == null)
            {
                value = "";
            }
            
            else
            {
                value = rule.getCondition();
            }
        }
        
        else if(columnIndex == 2)
        {
            if(rule.getCondition() != null)
            {
                if(rule.getCondition().equals("."))
                {
                    value = "";
                }
                
                else
                {
                    value = rule.getIftrue();
                }
            }
            
            else
            {
                value = rule.getIftrue();
            }
        }
        
        else if(columnIndex == 3)
        {
            if(rule.getCondition() == null)
            {
                value = "";
            }
            
            else
            {
                if(rule.getCondition().equals("."))
                {
                    value = "";
                }
                
                else
                {
                    value = rule.getIffalse();
                }
            }
        }
        
        return value;
    }
    
    @Override
    public String getColumnName(int column)
    {
        String name = "";
        
        if(column == 0)
        {
            name = "Instruction";
        }
        
        else if(column == 1)
        {
            name = "Condition";
        }
        
        else if(column == 2)
        {
            name = "True";
        }
        
        else if(column == 3)
        {
            name = "False";
        }
        
        return name;
    }
}
