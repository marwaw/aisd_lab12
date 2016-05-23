
public class Element {
	int index;
	Element parent;
	boolean visited = false;
	
	public Element(int ind){
		index = ind;
		parent = this;
	}
	
	public Element(int ind, Element par){
		index = ind;
		parent = par;
	}
	
	public void visited(boolean vis){
		visited = vis;
	}
	

}
