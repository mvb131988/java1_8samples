package binary_tree;

import java.util.ArrayList;
import java.util.List;

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
	
	public Vertex4 min() {
		return extremum(root, v->v.getLeft());
	}

	public Vertex4 max() {
		return extremum(root, v->v.getRight());
	}
	
	public Vertex4 min(Vertex4 subRoot) {
		return extremum(subRoot, v->v.getLeft());
	}
	
	public Vertex4 max(Vertex4 subRoot) {
		return extremum(subRoot, v->v.getRight());
	}
	
	private Vertex4 extremum(Vertex4 startVertex, Extremum ext) {
		Vertex4 v = startVertex;
		while(ext.candidate(v) != null) {
			v = ext.candidate(v);
		}
		return v;
	}
	
	public void printTree() {
		List<Vertex4> l = new ArrayList<>();
		l.add(root);
		internallyPrintTree(l);
	}
	
	private void internallyPrintTree(List<Vertex4> list) {
		List<Vertex4> newList = new ArrayList<>();
		
		boolean stop = true;
		for(Vertex4 v: list) {
			if(v != null) {
				System.out.print(v.getValue() + " ");
				
				newList.add(v.getLeft());
				newList.add(v.getRight());
				
				if(v.getLeft() != null || v.getRight() != null ) {
					stop = false;
				}
			}else {
				System.out.print("e ");
				
				newList.add(null);
				newList.add(null);
			}
		}
		System.out.println();
		
		if(stop) {
			return;
		} else {
			internallyPrintTree(newList);
		}
	}
	
	/**
	 * Find predecessor for vertex v
	 * 
	 * @param v
	 * @return
	 */
	public Vertex4 predecessor(Vertex4 v) {
		return findPOS(v, ve->ve.getLeft(), (v1,v2)->v1.getValue() > v2.getValue(), v3->max(v3));
	}
	
	/**
	 * Find successor for vertex v
	 * 
	 * @param v
	 * @return
	 */
	public Vertex4 successor(Vertex4 v) {
		return findPOS(v, ve->ve.getRight(), (v1,v2)->v1.getValue() < v2.getValue(), v3->min(v3));
	}
	
	/**
	 * POS - predecessor or successor
	 * 
	 * @param v
	 * @param c
	 * @param nc
	 * @param f
	 * @return
	 */
	private Vertex4 findPOS(Vertex4 v, Child c, NodeComparator nc, ExtremumFunction f) {
		if (c.get(v) != null) {
			return f.ext(c.get(v));
		} else {
			Vertex4 parent = v;
			while ((parent = parent.getParent()) != null && nc.compare(parent, v));
			return parent;
		}
	}
}
