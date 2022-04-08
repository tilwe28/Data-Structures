//Anurag Tilwe
public class Tree<E extends Comparable<E>>
{

	public static void main(String[] args)
	{
		Tree<Integer> tree = new Tree<Integer>(3);
		tree.add(1);
		tree.add(9);
		tree.add(5);
		tree.add(5);
		tree.add(7);
    	tree.traverseInOrder(tree.getRoot());
	}//main

	class TreeNode<E>
	{

		private E value;
		private TreeNode<E> left, right;

		public TreeNode(E value)
		{
			this.value = value;
			left = null;
			right = null;
		}//constructor

		//Accessor methods
		public E getValue() { return value; }
		public TreeNode<E> getLeft() { return left; }
		public TreeNode<E> getRight() { return right; }


		//Mutator methods
		public E setValue(E value)
		{
			E temp = this.value;
			this.value = value;
			return temp;
		}

		public TreeNode<E> setLeft(TreeNode<E> left)
		{
			TreeNode<E> temp = this.left;
			this.left = left;
			return temp;
		}

		public TreeNode<E> setRight(TreeNode<E> right)
		{
			TreeNode<E> temp = this.right;
			this.right = right;
			return temp;
		}

		public String toString()
		{
			return value.toString();
		}//toString

	}//TreeNode class

	TreeNode<E> root;
	int size;

	//Constructors
	public Tree()
	{
		root = null;
		size = 0;
	}

	public Tree(E value)
	{
			root = new TreeNode<E>(value);
			size = 1;
	}

	//Accessor methods
	public TreeNode<E> getRoot() { return root; }
	public int size() { return size; }

	public void add(E value)
	{
		root = addRecur(root, value);
		size++;
	}

	private TreeNode<E> addRecur(TreeNode<E> node, E value)
	{
		if (node == null)
			return new TreeNode<E>(value);
		else if (value.compareTo(node.getValue()) < 0)
			node.left = addRecur(node.getLeft(), value);
		else
			node.right = addRecur(node.getRight(), value);

		return node;
	}


	//Traversal methods
	public void traverseInOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			traverseInOrder(node.getLeft());
			System.out.println(node.getValue());
			traverseInOrder(node.getRight());
		}
	}

	public void traversePreOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			System.out.println(node.getValue());
			traversePreOrder(node.getLeft());
			traversePreOrder(node.getRight());
		}
	}

	public void traversePostOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			traversePostOrder(node.getLeft());
			traversePostOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}

}//Tree class