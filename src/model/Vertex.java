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
    
    private List<Integer> groups;
    private List<Vertex> destinations;
    
    public Vertex(int pId, int pPosX, int pPosY) {
        this.id = pId;
        this.posX = pPosX;
        this.posY = pPosY;
        this.counterEdge = 0;
        
        this.groups = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }
    
    public void addDestination(Vertex pDestination, int pDrones)
    {
    	if(destinations.contains(pDestination))
    	{
    		int destinationIndex = destinations.indexOf(pDestination);
    		groups.set(destinationIndex, new Integer(groups.get(destinationIndex) + pDrones));
//    		System.out.println("From estation: "+this.id+" to "+destinations.get(destinationIndex).id+" with "+groups.get(destinationIndex)+" drones.");
    	}
    	else
    	{
    		destinations.add(pDestination);
    		groups.add(new Integer(pDrones));
//    		System.out.println("From estation: "+this.id+" to "+destinations.get(destinations.size() - 1).id+" with "+groups.get(groups.size() - 1)+" drones.");
    		
    	}
    }
   
    public List<Integer> getGroups() {
		return groups;
	}

	public void setGroups(List<Integer> groups) {
		this.groups = groups;
	}

	public List<Vertex> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Vertex> destinations) {
		this.destinations = destinations;
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
