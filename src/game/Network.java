package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    final private Map<String, Node> nodesMap = new HashMap<>();

    public Network addNode(Node node) {
        nodesMap.put(node.getId(), node);
        return this;
    }

    public Network connect(String id1, String id2) {
        Node n1 = nodesMap.get(id1);
        Node n2 = nodesMap.get(id2);

        if (n1 == null || n2 == null) {
            System.err.println("Erreur de connexion : ID inexistant (" + id1 + ", " + id2 + ")");
            return this;
        }

        n1.connectTo(n2);
        return this;
    }

    public Node getNode(String id) {
        return nodesMap.get(id);
    }

    public List<Node> getAllNodes() {
        return new ArrayList<>(nodesMap.values());
    }

    public void printTopology() {
        System.out.println("=== Topologie du Reseau ===");
        for (Node node : nodesMap.values()) {
            System.out.println(node);
            for (Node connected : node.getConnectedNodes()) {
                System.out.println("   |--> Connection avec : " + connected.getId() + " (" + connected.getClass().getSimpleName() + ")");
            }
        }
    }
}