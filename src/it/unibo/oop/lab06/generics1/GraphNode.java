package it.unibo.oop.lab06.generics1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode<N> {
    private final N node;
    private final Set<N> adjacents;
    private int distance;
    private boolean visited;
    private GraphNode<N> father;

    public GraphNode(N node, int distance, GraphNode<N> father) {
	super();
	this.adjacents = new HashSet<>();
	this.node = node;
	this.distance = distance;
	this.father = father;
	this.visited = false;
    }

    public boolean hasBeenVisited() {
	return visited;
    }

    public void setVisited(boolean visited) {
	this.visited = visited;
    }

    public GraphNode(N node) {
	this(node, 0, null);
    }

    public int getDistance() {
	return distance;
    }

    public void setDistance(int distance) {
	this.distance = distance;
    }

    public GraphNode<N> getFather() {
	return father;
    }

    public void setFather(GraphNode<N> father) {
	this.father = father;
    }

    public N getNode() {
	return node;
    }

    public void addEdge(N target) {
	adjacents.add(target);
    }

    public Set<N> getAdjacents() {
	return Set.copyOf(adjacents);
    }

    @Override
    public int hashCode() {
	return Objects.hash(node);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	GraphNode<N> other = (GraphNode<N>) obj;
	return Objects.equals(node, other.node);
    }

}
