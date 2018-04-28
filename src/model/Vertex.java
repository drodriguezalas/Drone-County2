package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/**
 *
 * @author Dani
 */
public class Vertex {
    private int id;
    private int posX;
    private int posY;
    private int counterEdge; 
    
    
    
    public Vertex(int id, int posX, int posY) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.counterEdge = 0;                
    }                    

	public int getId() {
        return id;
    }   

    public int getPosX() {
        return posX;
    }   

    public int getPosY() {
        return posY;
    }   
    
    public int getCounterEdge() {
    	return counterEdge;
    }
    
    public void incrementCounterEdge() {
    	this.counterEdge++;
    }           
}
