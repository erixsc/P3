import java.util.ArrayList;

public class City {
	static int N = 1;
	int serial;
	String name;
	double latitude;
	double longitude;
	ArrayList<Link> links;

	public City() {
		this.links = new ArrayList<Link>();
	}

	public City(String s) {
		this.serial = N++;
		this.links = new ArrayList<Link>();
		String[] args = s.split(" ");
		this.name = args[0];
		this.latitude = Double.parseDouble(args[1]) + Double.parseDouble(args[2]) / 60
				+ Double.parseDouble(args[3]) / 3600;
		this.longitude = Double.parseDouble(args[5]) + Double.parseDouble(args[6]) / 60
				+ Double.parseDouble(args[7]) / 3600;
		if (args[8].equals("W")) {
			this.longitude = -this.longitude;
		}
	}

	public double distance(City c) {
		double radLat1 = rad(this.latitude);
		double radLat2 = rad(c.latitude);
		double radLng1 = rad(this.longitude);
		double radLng2 = rad(c.longitude);
		double a = radLat1 - radLat2;
		double b = radLng1 - radLng2;
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378;
		return s;
	}

	public double rad(double d) {
		return d * Math.PI / 180;
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("City #" + this.serial + ": " + this.name + "\n");
		sb.append("N " + String.format("%.4f", this.latitude) + "\n");
		if (this.longitude >= 0) {
			sb.append("E " + String.format("%.4f", this.longitude) + "\n");
		} else {
			sb.append("W " + String.format("%.4f", -this.longitude) + "\n");
		}
		sb.append("Connections:\n");
		if (this.links != null) {
			for (Link l : this.links) {
				sb.append("#" + l.c2.serial + "\t" + l.c2.name + "\tCost: " + l.cost + "\tEstimate: "
						+ String.format("%.2f", l.estimate) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
