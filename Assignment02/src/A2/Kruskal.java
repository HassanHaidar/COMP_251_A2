package A2;
import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        /* Fill this method (The statement return null is here only to compile) */
    	
    	//Starts with each vertex in its own component
    	DisjointSets components = new DisjointSets(g.getNbNodes());
    	for (Edge e: g.listOfEdgesSorted()){
    		//if (IsSafe())
    	}
    	
    	
        
        return null;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        /* Fill this method (The statement return 0 is here only to compile) */
 
        return true;
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
