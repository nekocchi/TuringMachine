/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Driver;
import model.Result;
import model.Tape;

/**
 *
 * @author EdwardLeonardi
 */
public class ResultTable extends AbstractTableModel
{
    private ArrayList<Result> results;
    
    public ResultTable()
    {
        this.results = Driver.results;
    }

    @Override
    public int getRowCount() {
        return results.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column)
    {
        String name = "";
        
        if(column == 0)
        {
            name = "Step";
        }
        
        else if(column == 1)
        {
            name = "Tape";
        }
        
        else if(column == 2)
        {
            name = "Index";
        }
        
        return name;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class type = String.class;
        
        if(columnIndex == 0 && columnIndex == 2)
        {
            type = Integer.class;
        }
        
        return type;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result res = results.get(rowIndex);
        
        Object value = null;
        
        if(columnIndex == 0)
        {
            value = res.getStep();
        }
        
        else if(columnIndex == 1)
        {
            value = res.getTape();
        }
        
        else if(columnIndex == 2)
        {
            value = res.getIndex();
        }
        
        return value;
    } 
}
