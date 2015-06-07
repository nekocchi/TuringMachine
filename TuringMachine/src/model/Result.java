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
public class Result {
    private int step;
    private String tape;
    private int index;

    public Result(int step, String tape, int index) {
        this.step = step;
        this.tape = tape;
        this.index = index;
    }

    public int getStep() {
        return step;
    }

    public String getTape() {
        return tape;
    }

    public int getIndex() {
        return index;
    }
    
    
}
