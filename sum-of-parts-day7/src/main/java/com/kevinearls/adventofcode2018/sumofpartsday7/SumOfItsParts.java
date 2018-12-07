package com.kevinearls.adventofcode2018.sumofpartsday7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SumOfItsParts {

    Map<String, Node> nodes = new HashMap<>();

    public void load(List<String> input) {
        for (String line : input) {
            String[] parts = line.split("\\s+");
            String nodeName1 = parts[1];
            String nodeName2 = parts[7];

            Node node1 = nodes.get(nodeName1);
            Node node2 = nodes.get(nodeName2);
            if (node1 == null) {
                node1 = new Node(nodeName1);
                nodes.put(nodeName1, node1);
            }

            if (node2 == null) {
                node2 = new Node(nodeName2);
                nodes.put(nodeName2, node2);
            }

            node1.addSucessors(node2);
            node2.addPredecessor(node1);
        }
    }

    public String getOrder() {
        // We can start with any node (1 or more) that has no predecessor
        List<Node> availableNodes = new LinkedList<>();
        for (String nodeName : nodes.keySet()) {
            Node n = nodes.get(nodeName);
            if (n.getPredecessors().size() == 0) {
                availableNodes.add(n);
            }
        }

        StringBuilder order = new StringBuilder();
        while(availableNodes.size() > 0) {
            Collections.sort(availableNodes);
            Node hotNode = availableNodes.get(0);
            order.append(hotNode.getName());
            for (Node sucessor : hotNode.getSucessors()) {
                sucessor.removePredecessor(hotNode);
                if (sucessor.getPredecessors().size() == 0) {
                    availableNodes.add(sucessor);
                }
            }
            availableNodes.remove(hotNode);
        }

        return order.toString();
    }
}
