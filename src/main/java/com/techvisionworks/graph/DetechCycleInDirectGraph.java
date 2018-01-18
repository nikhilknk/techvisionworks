package com.techvisionworks.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.techvision.common.Graph;
import com.techvision.common.Vertex;

public class DetechCycleInDirectGraph {

	public static void main(String[] args) {
		  Graph<Long> graph = new Graph<>(true);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 3);
	        graph.addEdge(4, 1);
	        graph.addEdge(4, 5);
	        graph.addEdge(5, 6);
	        graph.addEdge(6, 4);
	        
	        Set<Vertex<Long>> unvisitedSet = new HashSet<>(graph.getAllVertex().stream().map(x->x).collect(Collectors.toSet()));
	        Set<Vertex<Long>> visitedSet = new HashSet<>();
	        Set<Vertex<Long>> vistingSet = new HashSet<>();
	        
	        while (unvisitedSet.size() > 0) {
	            Vertex<Long> vertex = unvisitedSet.iterator().next();
	        	if(detectUtil(vertex,vistingSet,unvisitedSet,visitedSet))
	        	{
	        		System.out.println("Yes Cycle Present");
	        		break;
	        	}
			}
	        
	}

	private static boolean detectUtil(Vertex<Long> vertex, Set<Vertex<Long>> vistingSet, Set<Vertex<Long>> unvisitedSet,
			Set<Vertex<Long>> visitedSet) {
		if(vistingSet.contains(vertex)){
			return true;
		}else {
			vistingSet.add(vertex);
			unvisitedSet.remove(vertex);
		}
		for (Vertex<Long> adjecentVertex : vertex.getAdjacentVertexes()) {
			if(visitedSet.contains(adjecentVertex))
					continue;
			
			return detectUtil(adjecentVertex,vistingSet,unvisitedSet,visitedSet);
		}
		
		visitedSet.add(vertex);
		vistingSet.remove(vertex);
		return false;
	}

}
