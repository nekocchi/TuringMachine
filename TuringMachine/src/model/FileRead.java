/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author EdwardLeonardi
 */
public class FileRead 
{
    private String fileName;
    
    public FileRead(String fileName)
    {
        this.fileName = fileName;
    }
    
    public void readFile()
    {
        //declare buffer
        BufferedReader br = null;
 
        try
        {
            //temporary line variable
            String sCurrentLine;
            
            //initialize buffer with file name
            br = new BufferedReader(new FileReader("file/" + fileName + ".txt"));
            
            //while buffer is not empty
            while ((sCurrentLine = br.readLine()) != null)
            {
                Driver.rules.add(new Rule(sCurrentLine));
            }

        }
        
        catch (IOException e)
        {
            System.out.println(e);
        } 
        
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            }
            
            catch (IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
}
