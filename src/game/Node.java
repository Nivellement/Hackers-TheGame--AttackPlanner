package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Node {
    final private String id;
    private int level;
    private int firewall;
    private int maxConnections;
    final private List<Node> connectedNodes;

    public Node(String id, int level, int firewall, int maxConnections) {
        this.id = id;
        this.level = level;
        this.firewall = firewall;
        this.maxConnections = maxConnections;
        this.connectedNodes = new ArrayList<>();
    }

    public boolean connectTo(Node other) {
        if (other == null || other == this) return false;

        if (this.connectedNodes.size() >= this.maxConnections || other.connectedNodes.size() >= other.maxConnections) {
            System.err.println("Impossible de connecter [" + this.id + "] et [" + other.id + "] : limite atteinte.");
            return false;
        }

        if (!this.connectedNodes.contains(other)) {
            this.connectedNodes.add(other);
            other.connectedNodes.add(this);
            return true;
        }
        return false;
    }

    public String getId() { return id; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getFirewall() { return firewall; }
    public void setFirewall(int firewall) { this.firewall = firewall; }

    public int getMaxConnections() { return maxConnections; }
    public void setMaxConnections(int maxConnections) { this.maxConnections = maxConnections; }

    public List<Node> getConnectedNodes() {
        return Collections.unmodifiableList(connectedNodes);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", firewall=" + firewall +
                ", connections=" + connectedNodes.size() + "/" + maxConnections +
                '}';
    }
}