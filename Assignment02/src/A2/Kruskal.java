package A2;
import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        /* Fill this method (The statement return null is here only to compile) */
    	WGraph MST = new WGraph();
    	//Starts with each vertex in its own component
    	DisjointSets components = new DisjointSets(g.getNbNodes());
    	for (Edge e: g.listOfEdgesSorted()){
    		
    		// if node is safe
    		if (IsSafe(components, e)){
    			//merge component subtended by edge
    			components.union(e.nodes[0], e.nodes[1]);
    			//add edge to MST
    			MST.addEdge(e);
    		}
    	}
    
        return MST;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        /* Fill this method (The statement return 0 is here only to compile) */
    	
    	// check if the edge is in the same component
    	if (p.find(e.nodes[0]) == p.find(e.nodes[1])){
    		return false;
    	}
    	else{
            return true;
    	}
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
