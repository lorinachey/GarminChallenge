import java.util.*;

/*
	Graph class holds a tree structured graph in an array of nodes. The
	nodes have a list of their child nodes. The nodes are stored in the 
	array in level order starting at the root and moving left to right on
	each subsequent level.

	EXAMPLE: array = [Root, Lt.Child, Rt.Child]

								Root
							   /    \
						Lt.Chld     Rt.Child

	Root Node is array[0], Root node's left child is array[1] and Root
	node's right child is array[2].
*/
public class Graph {
	
	private int numOfNodes;
	
	private Node graph[];
	
	Graph(int numOfNodes) {
		this.numOfNodes = numOfNodes;
		
		graph = new Node[numOfNodes];
		for (int i = 0; i < numOfNodes; i++) {
			graph[i] = new Node();
		}		
	}
	
	/*
	Prints the full graph in the format:
			Node -> 1st_child 2nd_child
	*/
	public void printGraph() {
		for (int i = 0; i < numOfNodes; i++) {
			System.out.print(graph[i].getName());
				for (Node node : graph[i].getChildren()) {
					System.out.print("-> " + node.getName() + " ");
				}
			System.out.println();
		}
		System.out.println("End of Graph");
	}
	
	/*
	Searches for a specific Node based on a name match. If found
	returns true, otherwise false. Prints the name of every node
	that is visited.
	*/
	public boolean findNode(Node node) {
		boolean isFound = false;
		
		for (int i = 0; i < graph.length; i++) {
			System.out.print(graph[i].getName());

			if (graph[i].getName() == node.getName()) {
				return (isFound = true);
			}

			for (Node child : graph[i].getChildren()) {
				System.out.print(" " + child.getName() + " ");
				if (child.getName() == node.getName()) {
					return (isFound = true);
				}
			}
			System.out.println();
		}		
		return isFound;
	}

	/* 
	Sets up the specific Garmin challenge graph. Stores Nodes of the tree
	in level order from root to leaf, going left to right, in an array.
	*/
	public static Graph setupGarminGraph() {

		Graph garminGraph = new Graph(9);
		
		List<Node> node9chld = new ArrayList<Node>();
		List<Node> node8chld = new ArrayList<Node>();
		List<Node> node7chld = new ArrayList<Node>();
		
		List<Node> node6chld = new ArrayList<Node>();
		node6chld.add(garminGraph.graph[8]);
		
		List<Node> node5chld = new ArrayList<Node>();
		node5chld.add(garminGraph.graph[7]);
		
		List<Node> node4chld = new ArrayList<Node>();
		node4chld.add(garminGraph.graph[6]);
		
		List<Node> node3chld = new ArrayList<Node>();
		node3chld.add(garminGraph.graph[4]);
		node3chld.add(garminGraph.graph[5]);
		
		List<Node> node2chld = new ArrayList<Node>();
		node2chld.add(garminGraph.graph[3]);
		
		List<Node> node1chld = new ArrayList<Node>();
		node1chld.add(garminGraph.graph[1]);
		node1chld.add(garminGraph.graph[2]);
	
		garminGraph.graph[0].setName("Start");
		garminGraph.graph[0].setChildren(node1chld);
		
		garminGraph.graph[1].setName("A1");
		garminGraph.graph[1].setChildren(node2chld);
		
		garminGraph.graph[2].setName("A2");
		garminGraph.graph[2].setChildren(node3chld);
		
		garminGraph.graph[3].setName("D1");
		garminGraph.graph[3].setChildren(node4chld);

		garminGraph.graph[4].setName("B1");
		garminGraph.graph[4].setChildren(node5chld);

		garminGraph.graph[5].setName("B2");
		garminGraph.graph[5].setChildren(node6chld);
		
		garminGraph.graph[6].setName("E1");
		garminGraph.graph[6].setChildren(node7chld);

		garminGraph.graph[7].setName("FindMe");
		garminGraph.graph[7].setChildren(node8chld);
		
		garminGraph.graph[8].setName("C1");
		garminGraph.graph[8].setChildren(node9chld);

		return garminGraph;
	}
	
	/*
	Graph class driver
	 */
	public static void main(String args[]) {
		
		System.out.println("\nStarting Graph Code\n");
		
		Graph garminGraph = setupGarminGraph();
		Node findMe = new Node("FindMe", new ArrayList<Node>());

		boolean isFound = garminGraph.findNode(findMe);

		System.out.println("\nNode named " + findMe.getName() + " is found? " + isFound + "\n");
	}
	
}