import java.util.ArrayList;

public class Node implements Comparable<Node> {
	double f;
	City state;
	ArrayList<City> actions;
	int pathCost;

	public Node() {
		this.state = new City();
		this.actions = new ArrayList<City>();
	}

	@Override
	public int compareTo(Node node) {
		return (this.f < node.f ? -1 : (this.f == node.f ? 0 : 1));
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("(fn: ");
		sb.append(this.f);
		sb.append("\tState: ");
		sb.append(this.state.name);
		sb.append("\tActions: ");
		for (City c : this.actions) {
			sb.append(" >");
			sb.append(c.name);
		}
		sb.append("\tPathCost: ");
		sb.append(this.pathCost);
		sb.append(")");
		System.out.println(sb.toString());
	}
}
