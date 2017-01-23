package binary_tree;

public class Tree {

	private Vertex4 root;

	public Vertex4 search(int key) {
		Vertex4 parent = parentOf(root, key);
		Vertex4 v = null;

		// root case
		if (parent == null) {
			v = root;
		} else {
			if (parent.getValue() > key) {
				v = parent.getLeft();
			}
			if (parent.getValue() < key) {
				v = parent.getRight();
			}
		}

		return v;
	}

	public void insert(int number) {
		Vertex4 v = new Vertex4();
		v.setValue(number);

		if (root == null) {
			root = v;
		} else {
			Vertex4 parent = parentOf(root, number);
			if (parent == null) {
				// No insert number == key of the root element, cause it's the
				// only one without parent
			} else if ((parent.getLeft() != null && parent.getLeft().getValue() == number)
					|| (parent.getRight() != null && parent.getRight().getValue() == number)) {
				// if number == key of either left or right child of a parent,
				// then such a key already
				// exists in the tree, leads to no inserts.
			} else {
				v.setParent(parent);
				// Left insert
				if (parent.getValue() > number) {
					assert (parent.getLeft() == null);
					parent.setLeft(v);
				}
				// Right insert
				if (parent.getValue() < number) {
					assert (parent.getRight() == null);
					parent.setRight(v);
				}
			}
		}

	}

	private Vertex4 parentOf(Vertex4 subRoot, int key) {
		Vertex4 parent = null;

		// 3 base cases
		if (subRoot.getValue() == key) {
			parent = subRoot.getParent();
		}
		if (subRoot.getValue() < key && subRoot.getRight() == null) {
			parent = subRoot;
		}
		if (subRoot.getValue() > key && subRoot.getLeft() == null) {
			parent = subRoot;
		}

		// 2 inductive steps
		if (subRoot.getValue() < key && subRoot.getRight() != null) {
			parent = parentOf(subRoot.getRight(), key);
		}
		if (subRoot.getValue() > key && subRoot.getLeft() != null) {
			parent = parentOf(subRoot.getLeft(), key);
		}

		return parent;
	}

}
