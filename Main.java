import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		City c1 = new City("Paris 48 51 0 N 2 20 0 E");
		City c2 = new City("Caen 49 15 0 N 0 20 0 W");
		City c3 = new City("Calais 50 57 36 N 1 57 0 E");
		City c4 = new City("Dijon 47 21 0 N 5 02 0 E");
		City c5 = new City("Lyon 45 44 0 N 4 52 0 E");
		City c6 = new City("Grenoble 45 21 36 N 5 19 12 E");
		City c7 = new City("Avignon 43 50 0 N 4 45 0 E");
		City c8 = new City("Marseille 43 18 0 N 5 25 0 E");
		City c9 = new City("Nice 43 42 0 N 7 21 0 E");
		City c10 = new City("Montpellier 43 38 0 N 3 53 0 E");
		City c11 = new City("Toulouse 43 37 0 N 1 27 0 E");
		City c12 = new City("Bordeaux 44 50 0 N 0 37 0 W");
		City c13 = new City("Limoges 45 30 0 N 1 10 0 E");
		City c14 = new City("Rennes 48 07 0 N 1 02 0 W");
		City c15 = new City("Brest 48 24 0 N 4 30 0 W");
		City c16 = new City("Strasbourg 48 32 24 N 7 37 34 E");
		City c17 = new City("Nancy 48 50 0 N 6 10 0 E");
		City c18 = new City("Nantes 47 15 0 N 1 30 0 W");

		Network bn = new Network();
		bn.add(c1);
		bn.add(c2);
		bn.add(c3);
		bn.add(c4);
		bn.add(c5);
		bn.add(c6);
		bn.add(c7);
		bn.add(c8);
		bn.add(c9);
		bn.add(c10);
		bn.add(c11);
		bn.add(c12);
		bn.add(c13);
		bn.add(c14);
		bn.add(c15);
		bn.add(c16);
		bn.add(c17);
		bn.add(c18);

		bn.link(c15, c14, 244);
		bn.link(c14, c2, 176);
		bn.link(c14, c1, 348);
		bn.link(c14, c18, 107);
		bn.link(c2, c3, 120);
		bn.link(c2, c1, 241);
		bn.link(c3, c17, 534);
		bn.link(c3, c1, 297);
		bn.link(c17, c16, 145);
		bn.link(c17, c4, 201);
		bn.link(c17, c1, 372);
		bn.link(c16, c4, 335);
		bn.link(c4, c5, 192);
		bn.link(c4, c1, 313);
		bn.link(c5, c6, 104);
		bn.link(c5, c7, 216);
		bn.link(c5, c13, 389);
		bn.link(c6, c7, 227);
		bn.link(c7, c8, 99);
		bn.link(c7, c10, 121);
		bn.link(c8, c9, 188);
		bn.link(c10, c11, 240);
		bn.link(c11, c12, 253);
		bn.link(c11, c13, 313);
		bn.link(c12, c13, 220);
		bn.link(c12, c18, 329);
		bn.link(c13, c18, 329);
		bn.link(c13, c1, 396);

		bn.ucs(c15, c8);
		bn.gbfs(c15, c8);
		bn.astar(c15, c8);

		bn.ucs(c10, c3);
		bn.gbfs(c10, c3);
		bn.astar(c10, c3);

		bn.ucs(c16, c12);
		bn.gbfs(c16, c12);
		bn.astar(c16, c12);

		bn.ucs(c1, c6);
		bn.gbfs(c1, c6);
		bn.astar(c1, c6);

		bn.ucs(c6, c1);
		bn.gbfs(c6, c1);
		bn.astar(c6, c1);

		bn.ucs(c15, c6);
		bn.gbfs(c15, c6);
		bn.astar(c15, c6);

		bn.ucs(c6, c15);
		bn.gbfs(c6, c15);
		bn.astar(c6, c15);


	}

}
