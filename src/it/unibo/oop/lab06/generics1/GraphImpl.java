package it.unibo.oop.lab06.generics1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
    private final Set<GraphNode<N>> nodes = new HashSet<>();

    public void addNode(N node) {
	nodes.add(new GraphNode<N>(node));
    }

    private GraphNode<N> getGraphNode(N node) {
	for (GraphNode<N> n : nodes) {
	    if (n.getNode().equals(node)) {
		return n;
	    }
	}
	return null;
    }

    public void addEdge(N source, N target) {
	if (nodes.contains(new GraphNode<N>(target))) {
	    GraphNode<N> n = getGraphNode(source);
	    if (n != null) {
		n.addEdge(target);
	    }
	}
    }

    public Set<N> nodeSet() {
	Set<N> vNodeSet = new HashSet<>();
	for (GraphNode<N> n : nodes) {
	    vNodeSet.add(n.getNode());
	}
	return vNodeSet;
    }

    public Set<N> linkedNodes(N node) {
	return getGraphNode(node).getAdjacents();
    }

    private void initBFS(N source) {
	for (GraphNode<N> n : nodes) {
	    if (n.getNode().equals(source)) {
		n.setDistance(0);
	    } else {
		n.setDistance(Integer.MAX_VALUE);
	    }
	    n.setFather(null);
	    n.setVisited(false);
	}
    }

    private void executeBFS(N source) {
	initBFS(source);

	Queue<GraphNode<N>> nodesToVisit = new LinkedList<>();
	nodesToVisit.add(getGraphNode(source));

	while (!nodesToVisit.isEmpty()) {
	    GraphNode<N> currentNode = nodesToVisit.poll();
	    for (N adjacent : currentNode.getAdjacents()) {
		GraphNode<N> adjacentNode = this.getGraphNode(adjacent);
		if (!nodesToVisit.contains(adjacentNode) && !adjacentNode.hasBeenVisited()) {
		    GraphNode<N> n = getGraphNode(adjacent);
		    n.setDistance(currentNode.getDistance() + 1);
		    n.setFather(currentNode);
		    nodesToVisit.add(n);
		}
	    }
	    currentNode.setVisited(true);
	}
    }

    private List<N> getFathersPath(N source, N target) {
	List<N> path = new LinkedList<>();
	GraphNode<N> temp = getGraphNode(target);
	while (temp != null && !temp.getNode().equals(source)) {
	    path.add(0, temp.getNode());
	    temp = temp.getFather();
	}
	if (temp == null) {
	    return null;
	} else {
	    path.add(0, temp.getNode());
	    return path;
	}
    }

    public List<N> getPath(N source, N target) {
	this.executeBFS(source);
	List<N> result = getFathersPath(source, target);
	return result;
    }

}
