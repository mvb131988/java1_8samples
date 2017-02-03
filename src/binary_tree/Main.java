package binary_tree;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		int[] input1 = getInput1();
		for(int i : input1){
			tree.insert(i);
		}
		
		Vertex4 v = tree.search(5);
		System.out.println(tree.min().getValue());
		System.out.println(tree.max().getValue());
		
		System.out.println();
		tree.printTree();
		
		System.out.println(tree.predecessor(tree.search(16)).getValue());
	}
	
	public static int[] getInput1() {
		return new int[]{3,1,5,2,4,9,16,17,19,18};
	}
	
}
