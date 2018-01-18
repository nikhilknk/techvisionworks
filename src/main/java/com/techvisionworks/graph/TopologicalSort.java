package com.techvisionworks.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import com.techvision.common.Graph;
import com.techvision.common.Vertex;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph<Long> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        Set<Long> visitedSet = new HashSet<>();
		Deque<Vertex<Long>> result =  new ArrayDeque<>();
		
		for (Vertex<Long> vertex : graph.getAllVertex()) {
			if(!visitedSet.contains(vertex.getId())) {
				visitedSet.add(vertex.getId());
				sort(vertex, visitedSet, result);
			}
		}
		while(!result.isEmpty()) {
			System.out.println(result.poll().getId());
		}
        
	}

	private static void sort(Vertex<Long> vertex,Set<Long> visitedSet,Deque<Vertex<Long>> result) {
		for (Vertex<Long> adjecentVertex : vertex.getAdjacentVertexes()) {
			if(!visitedSet.contains(adjecentVertex.getId())) {
				visitedSet.add(adjecentVertex.getId());
				sort(adjecentVertex, visitedSet, result);
			}
		}
		result.offerFirst(vertex);
	}
	
}
