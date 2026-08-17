package game;

import game.subnode.*;

public class Main {
    public static void main(String[] args) {
        Network net = new Network();

        // Paramètres-> (ID, Level, Firewall, MaxConn)
        net.addNode(new Core("Core_1", 5, 100, 3))
           .addNode(new NetConnection("Net_1", 1, 10, 4))
           .addNode(new CodeGate("Gate_A", 2, 50, 2))
           .addNode(new BCoinMine("Mine_1", 3, 20, 2))
           .addNode(new Turret("Turret_1", 4, 80, 2));

        // Peu importe le sensI
        net.connect("Net_1", "Gate_A")
           .connect("Gate_A", "Core_1")
           .connect("Core_1", "Mine_1")
           .connect("Core_1", "Turret_1");

        net.printTopology();
    }
}