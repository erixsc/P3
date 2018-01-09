import java.util.ArrayList;
import java.util.Collections;

public class Network {
	ArrayList<City> cities;

	public Network() {
		this.cities = new ArrayList<City>();
	}

	public void add(City c) {
		this.cities.add(c);
	}

	public void link(City c1, City c2, int cost) {
		c1.links.add(new Link(c1, c2, cost));
		c2.links.add(new Link(c2, c1, cost));
	}

	public void display() {
		for (City c : this.cities) {
			c.display();
		}
	}

	public void ucs(City c1, City c2) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Node> frontier = new ArrayList<Node>();
		ArrayList<City> explored = new ArrayList<City>();

		Node node0 = new Node();
		node0.state = c1;
		nodes.add(node0);
		explored.add(c1);
		Performance performance = new Performance();

		while (nodes.get(0).state.equals(c2) == false) {
			expand(nodes, frontier, explored, "ucs", performance, c2);
		}
		System.out.print("From City " + c1.name + "\tto City " + c2.name);
		System.out.println("\tUsing Uniform Cost Search, the solution is:");
		nodes.get(0).display();
		System.out.print(performance.nodesExplored + " Explored");
		System.out.print("\t" + performance.nodesExpanded + " Expanded");
		System.out.println("\t" + performance.nodesMaintained + " Maintained\n");
	}

	public void gbfs(City c1, City c2) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Node> frontier = new ArrayList<Node>();
		ArrayList<City> explored = new ArrayList<City>();

		Node node0 = new Node();
		node0.state = c1;
		nodes.add(node0);
		explored.add(c1);
		Performance performance = new Performance();

		while (nodes.get(0).state.equals(c2) == false) {
			expand(nodes, frontier, explored, "gbfs", performance, c2);
		}
		System.out.print("From City " + c1.name + "\tto City " + c2.name);
		System.out.println("\tUsing Greedy Best First Search, the solution is:");
		nodes.get(0).display();
		System.out.print(performance.nodesExplored + " Explored");
		System.out.print("\t" + performance.nodesExpanded + " Expanded");
		System.out.println("\t" + performance.nodesMaintained + " Maintained\n");
		}

	public void astar(City c1, City c2) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Node> frontier = new ArrayList<Node>();
		ArrayList<City> explored = new ArrayList<City>();

		Node node0 = new Node();
		node0.state = c1;
		nodes.add(node0);
		explored.add(c1);
		Performance performance = new Performance();

		while (nodes.get(0).state.equals(c2) == false) {
			expand(nodes, frontier, explored, "astar", performance, c2);
		}
		System.out.print("From City " + c1.name + "\tto City " + c2.name);
		System.out.println("\tUsing A Star, the solution is:");
		nodes.get(0).display();
		System.out.print(performance.nodesExplored + " Explored");
		System.out.print("\t" + performance.nodesExpanded + " Expanded");
		System.out.println("\t" + performance.nodesMaintained + " Maintained\n");
		}
	
	@SuppressWarnings("unchecked")
	public void expand(ArrayList<Node> nodes, ArrayList<Node> frontier, ArrayList<City> explored, String method,
			Performance p, City destination) {
		explored.add(nodes.get(0).state);
		for (Link l : nodes.get(0).state.links) {
			p.nodesExpanded++;
			if (explored.contains(l.c2) == false) {
				Node n = new Node();
				if (method.equals("ucs")) {
					n.f = nodes.get(0).f + l.cost;
				}
				if (method.equals("gbfs")) {
					n.f = l.c2.distance(destination);
				}
				if (method.equals("astar")) {
					n.f = nodes.get(0).pathCost + l.c2.distance(destination) + l.cost;
				}
				n.state = l.c2;
				n.actions = (ArrayList<City>) nodes.get(0).actions.clone();
				n.actions.add(l.c2);
				n.pathCost = nodes.get(0).pathCost + l.cost;

				if (sameInFrontier((l.c2), nodes) == null) {
					nodes.add(n);
					p.nodesMaintained++;
				} else {
					if (n.f < sameInFrontier((l.c2), nodes).f) {
						nodes.remove(sameInFrontier((l.c2), nodes));
						nodes.add(n);
					}
				}
			}
		}
		nodes.remove(nodes.get(0));
		Collections.sort(nodes);
		p.nodesExplored = explored.size();
		
	}

	public Node sameInFrontier(City c, ArrayList<Node> frontier) {
		Node result = null;
		for (Node node : frontier) {
			if (node.state.equals(c)) {
				result = node;
			}
		}
		return result;
	}
}
