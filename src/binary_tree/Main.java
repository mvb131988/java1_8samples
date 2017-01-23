package binary_tree;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		int[] input1 = getInput1();
		for(int i : input1){
			tree.insert(i);
		}
		
		Vertex4 v = tree.search(3);
		System.out.println(tree);
	}
	
	public static int[] getInput1() {
		return new int[]{3,1,5,2,4};
	}
	
}
