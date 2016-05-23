import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
//	int index;
	int numOfVertices;
	int numOfEdges;
	ArrayList<Element> vertices;
	ArrayList<Edge> edgeList;
	ArrayList<Edge> minimal;
	
	public Graph(String fileName) throws FileNotFoundException{
//		index = 0;
		vertices = new ArrayList<>();
		edgeList = new ArrayList<>();
		minimal = new ArrayList<>();
		read(fileName);
	}
	
	public void read(String fileName) throws FileNotFoundException{
		Scanner fileScanner = new Scanner(new FileReader(fileName));
		numOfVertices = fileScanner.nextInt();
		numOfEdges = fileScanner.nextInt();
		
		while(fileScanner.hasNext()){
				int i = fileScanner.nextInt();
				int j = fileScanner.nextInt();
				int k = fileScanner.nextInt();
				addEdge(i, j, k);
		}
		fileScanner.close();
	}
	
	
	public void addVertex(int i){
//		if (i > numOfVertices - 1) throw new Exception("Nie mo¿na dodaæ wiêcej wierzcho³ków");
		Element e = new Element(i);
		vertices.add(e);
	}
	
	public void addEdge(int i1, int i2, int weight){
		if( search(i1, vertices) == null ) addVertex(i1);
		if( search(i2, vertices) == null ) addVertex(i2);;
		
		Element a = search(i1, vertices);
		Element b = search(i2, vertices);
		
//		link(a,b);
		Edge e = new Edge(a, b, weight);
		edgeList.add(e);
	}
	
	public void MST_kruskal(String fileName) throws IOException{
		makeSets();
		Queue<Edge> queue = makeQueue();
		int suma = 0;
		for (Edge e: queue){
			if (find(e.a) != find(e.b)){
				minimal.add(e);
				union(e.a, e.b);
				suma += e.weight;
			}
		}
		FileWriter fr = new FileWriter(fileName);
		fr.write("Suma: " + suma);
		fr.close();
	}
	
	public void link(Element a, Element b){
		b.parent = a;
	}
	
	private ArrayList<Element> makeSets(){
		ArrayList<Element> sets = new ArrayList<>();
		
		for(Element e: vertices){
			makeSet(e);
			sets.add(e);
		}
		
		return sets;
	}
	
	private void makeSet(Element x){
		x.parent = x;
	}
	
	private PriorityQueue<Edge> makeQueue(){
		PriorityQueue<Edge> q = new PriorityQueue<>();
		for (Edge e: edgeList){
			q.add(e);
		}
		return q;
	}
	
	private Element search(int i, ArrayList<Element> ver){
		Iterator<Element> it = ver.iterator();
		while(it.hasNext()){
			Element temp = it.next();
			if (temp.index == i) return temp;
		}
		return null;
	}
	
	private Element find(Element x){
		return x == x.parent? x: find(x.parent);
	}
	
	private void union(Element x, Element y){
		link(find(x), find(y));
	}
	
	public void display(ArrayList<Edge> edgeL){
		for (Edge e: edgeL){
			System.out.println(e.toString());
		}
	}
	
	

}
