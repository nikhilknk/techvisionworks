package com.techvisionworks.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.techvision.common.Graph;
import com.techvision.common.Vertex;

public class BFS {

	public static void main(String[] args) {
		 Graph<Integer> graph = new Graph<Integer>(true);
		 graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 4);
	        graph.addEdge(3, 4);
	        graph.addEdge(4, 6);
	        graph.addEdge(6, 5);
	        graph.addEdge(5, 1);
	        graph.addEdge(5,3);
	        BFSTraversal(graph);
	}
	 public static void BFSTraversal(Graph<Integer> graph){
		 Set<Long> visitedSet = new HashSet<Long>();
		 Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

		 for (Vertex<Integer> currentVertex : graph.getAllVertex()) {
			 if(!visitedSet.contains(currentVertex.getId()))
			 {
				 queue.add(currentVertex);
				 visitedSet.add(currentVertex.getId());
			 }

			 while(queue.size()>0) {
				 Vertex<Integer> childVertex =  queue.poll();
				 System.out.println(childVertex.getId());
				 for (Vertex<Integer> adjecentVertex : childVertex.getAdjacentVertexes()) {
					 if(!visitedSet.contains(adjecentVertex.getId()))
					 {
						 visitedSet.add(adjecentVertex.getId());
						 queue.add(adjecentVertex);
					 }
				 }

			 }

		 }
	 }
}
