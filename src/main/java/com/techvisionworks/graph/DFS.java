package com.techvisionworks.graph;

import java.util.HashSet;
import java.util.Set;

import com.techvision.common.Graph;
import com.techvision.common.Vertex;

public class DFS {
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
		DFSTraversal(graph);
	}

	public static void DFSTraversal(Graph<Integer> graph){
		Set<Long> visitedSet = new HashSet<Long>();
		for (Vertex<Integer> vertx : graph.getAllVertex()) {
			if(!visitedSet.contains(vertx.getId()))
				DFSUtil(vertx,visitedSet);
		}

	}

	private static void DFSUtil(Vertex<Integer> vertx,Set<Long> visitedSet) {
		visitedSet.add(vertx.getId());
		System.out.println(vertx.getId());
		for (Vertex<Integer> adjecentVertex : vertx.getAdjacentVertexes()) {
			if(!visitedSet.contains(adjecentVertex.getId()))
				DFSUtil(adjecentVertex,visitedSet);
		}
	}

}
