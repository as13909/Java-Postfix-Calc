package Aaron_Stein_hw_two;
//Aaron Stein. 3/27/22. Homework 3
public class ExpressionTree{
	
	private int size = 0; //size of tree
	
	ArrayStack<Node> stack = new ArrayStack<Node>(1000);
	
	
	public ExpressionTree()
	{
		
	}
	public boolean isEmpty()
	{
		if(size == 0) {return true;} //checks if tree is empty
		return false;
	}
	
	public int Size()
	{
		return size; //returns size of tree
	}
	private void setLeft(Node node, Node element)
	{
		node.leftChild = element; //allows to set left child of node
	}
	private void setRight(Node node, Node element)
	{
		node.rightChild = element; //allows set right child of node
	}
	public Node convert(String postfix_ex)
	{
		char temp; //the item currently being tested in the for loop
		Node temp1, temp2, temp3; //different holders for other nodes that need to be set as children
		for(int i = 0; i < postfix_ex.length(); i++)
		{
			
			temp = postfix_ex.charAt(i);
			if(temp == '+' || temp == '-'|| temp == '*'|| temp == '/'|| temp =='^') //checks to see if it is an operation sign
			{
				
				temp2 = stack.pop(); //pops two items off the stack
				temp3 = stack.pop();
				Node node = new Node(Character.toString(temp), temp2, temp3); //adds them as children of operator node
				stack.push(node);
				size++; //increases size by 1
				
			}
			else if(Character.isDigit(temp)) //checks if temp is a digit
			{
				Node node = new Node(Character.toString(temp)); //creates a new node for the number 
				stack.push(node);
				size++; //increases size by 1
			}
			
		}
		temp1 = stack.pop(); //pops the root node off of the stack
		return temp1; //returns root node
	}
	public String postfix(String infix)
	{
		Converter c = new Converter(); //converts infix expression to postfix using converter class
		return(c.toPostfix(infix));
		
	}
	public void prefix(Node tree)
	{
		System.out.print(tree.toString());
		if(tree.rightChild != null)
		{
			prefix(tree.rightChild);
		}
		if(tree.leftChild != null)
		{
			prefix(tree.leftChild);
		}
		
	}
	public void infix(Node tree)
	{
		
		if(tree.rightChild != null)
		{
			System.out.print("(");
			infix(tree.rightChild);
		}
		System.out.print(tree.toString());
		if(tree.leftChild != null)
		{
			infix(tree.leftChild);
			System.out.print(")");
		}
	}
	public void postfix(Node tree)
	{
		
		if(tree.rightChild != null)
		{
			postfix(tree.rightChild);
		}

		if(tree.leftChild != null)
		{
			postfix(tree.leftChild);
		}
		System.out.print(tree.toString());
	}
	
	
	
	
	
	
	
	
	
}