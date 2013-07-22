class Graph {
	public Node[] vertices;
	public int verticesCount;
	public int size;
	public Graph(int size){
		this.size = size;
		vertices = new Node[size];
		verticesCount = 0;
	}

	public void addVertex(Node n){
		if(verticesCount == size){
			System.out.println("Graph is full.");
			return;
		} else {
			vertices[verticesCount++] = n;
		}
	}
}
