
public class Edge implements Comparable<Edge> {
	Element a, b;
	int weight;
	
	public Edge(Element a, Element b, int weight){
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public String toString(){
		return "Krawêdz z " + a.index + " do " + b.index + " waga: " + weight;
	}

	@Override
	public int compareTo(Edge o) {
		int com;
		if (this.weight > o.weight) com = 1;
		else if (this.weight < o.weight) com = -1;
		else com = 0;
		return com;
	}

}
