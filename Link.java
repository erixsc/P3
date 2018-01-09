
public class Link {
	City c1;
	City c2;
	int cost;
	double estimate;

	public Link() {
	}

	public Link(City c1, City c2, int cost) {
		this.c1 = c1;
		this.c2 = c2;
		this.cost = cost;
		this.estimate = c1.distance(c2);
	}

}
