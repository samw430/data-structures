import java.util.LinkedList;

public class Graph{

	boolean[][] allNodes;

	public Graph(int maxNodes){
		allNodes = new boolean[maxNodes][maxNodes];
	}

	public void addEdge(int a, int b){
		allNodes[a][b] = true;
	}

	public void depthFirst(int node){
		boolean[] visited = new boolean[allNodes.length];

		depthHelper(node, visited);
	}

	public void depthHelper(int node, boolean[] visited){
		visited[node] = true;
		System.out.println(node);
		for(int i=0;i<allNodes[node].length;i++){
			if(allNodes[node][i] && !visited[i]){
				depthHelper(i,visited);
			}
		}
	}

	public void breadthFirst(int node){
		boolean[] visited = new boolean[allNodes.length];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(node);

		while(!queue.isEmpty()){
			int current = queue.removeFirst();
			System.out.println(current);
			visited[current] = true;
			for(int i=0;i<allNodes[current].length;i++){
				if(allNodes[current][i] && !visited[i]){
						queue.add(i);
				}
			}
		}


	}

	public static void main(String[] args){
		Graph test = new Graph(6);
		test.addEdge(0,1);
		test.addEdge(0,3);
		test.addEdge(1,2);
		test.addEdge(3,5);
		test.depthFirst(0);
		test.breadthFirst(0);
	}	
}