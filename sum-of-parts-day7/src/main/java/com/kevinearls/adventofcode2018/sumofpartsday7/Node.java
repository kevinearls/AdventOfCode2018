package com.kevinearls.adventofcode2018.sumofpartsday7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements Comparable<Node> {
    private String name;
    private List<Node> predecessors = new ArrayList<>();
    private List<Node> sucessors = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Node> getPredecessors() {
        return predecessors;
    }

    public void addPredecessor(Node node) {
        predecessors.add(node);
    }

    public void removePredecessor(Node node) {
        predecessors.remove(node);
    }

    public void setPredecessors(List<Node> predecessors) {
        this.predecessors = predecessors;
    }

    public List<Node> getSucessors() {
        return sucessors;
    }

    public void addSucessors(Node node) {
        sucessors.add(node);
    }

    public void setSucessors(List<Node> sucessors) {
        this.sucessors = sucessors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }
}
