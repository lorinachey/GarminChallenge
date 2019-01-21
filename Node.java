import java.util.*;

/*
Class which represents the nodes of a grpah and holds the node data and 
a List of the children of that node.
*/
public class Node {
	
	private String name;
	private List<Node> Children;
	
	public Node() {
		this("", new ArrayList<Node>());
	}
	
	public Node(String name, List<Node> Children) {
		this.name = name;
		this.Children = Children;
	}
	
	public String getName() {
		return (name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Node> getChildren() {
		return (Children);
	}
	
	public void setChildren(List<Node> Children) {
		this.Children = Children;
	}
	
}