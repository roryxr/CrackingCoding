class Node {
	public Node[] adjacents;
	private int adjacentCount;
	public boolean visited;
	public String name;
	public Node(String name, int adjacentNum){
		this.name = name;
		adjacents = new Node[adjacentNum];
		adjacentCount = 0;
	}

	public void addAdjacent(Node n){
		adjacents[adjacentCount++] = n;
	}
}
