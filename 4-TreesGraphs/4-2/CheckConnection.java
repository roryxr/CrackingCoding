import java.util.LinkedList;
class CheckConnection {
	public static int VERTEX_SIZE = 6;

	public static void main(String[] args){
		Graph g = createGraph();
		System.out.println("Connection: true = connected, false = not connected.\n"+isConnected(g, g.vertices[1], g.vertices[4]));
	}

	public static Graph createGraph(){
		Graph g = new Graph(6);
		String[] names = {"a", "b", "c", "d", "e", "f"};
		for(String s : names){
			Node n = new Node(s, VERTEX_SIZE);
			g.addVertex(n);
		}
		g.vertices[0].addAdjacent(g.vertices[1]);
		g.vertices[0].addAdjacent(g.vertices[2]);
		g.vertices[0].addAdjacent(g.vertices[3]);
		g.vertices[1].addAdjacent(g.vertices[0]);
		g.vertices[2].addAdjacent(g.vertices[0]);
		g.vertices[2].addAdjacent(g.vertices[3]);
		g.vertices[3].addAdjacent(g.vertices[0]);
		g.vertices[3].addAdjacent(g.vertices[2]);
		g.vertices[3].addAdjacent(g.vertices[4]);
		g.vertices[4].addAdjacent(g.vertices[3]);
		return g;
	}

	public static boolean isConnected(Graph g, Node start, Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		for(Node n : g.vertices){
			if(n != null)
				n.visited = false;
		}
		q.addLast(start);
		while(!q.isEmpty()){
			Node curr = q.pollFirst();
			for(Node n : curr.adjacents){
				if(n != null){
					if(!n.visited){
						if(n.equals(end)) return true;
						q.addLast(n);
					}
				}
			}
			curr.visited = true;
		}
		return false;
	}
}
