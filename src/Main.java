import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Graph g = new Graph("da7");
		g.display(g.edgeList);
		g.MST_kruskal("output.txt");
		System.out.println("---------------------");
		System.out.println("MST");
		g.display(g.minimal);
	}

}
