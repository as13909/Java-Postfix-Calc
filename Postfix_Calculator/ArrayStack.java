package Aaron_Stein_hw_two;

public class ArrayStack<Type> implements Stack<Type> {
	public static final int capacity = 1000;
	private Type[] items; 
	private int c = -1;
	
	
	public ArrayStack()
	{
		
	}
	public ArrayStack(int capacity)
	{
		items = (Type[]) new Object[capacity];
	}
	
	
	@Override
	public int size() {
		
		return c+1;
	}

	@Override
	public boolean isEmpty() {
		
		return (c== -1);
	}

	@Override
	public void push(Type val) throws IllegalStateException{
		if(size() == items.length) 
		{
			throw new IllegalStateException("Stack is full");
		}
		else
		{
			items[++c] = val;
		}
		
	}

	@Override
	public Type top() {
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return items[c];
		}
	}

	@Override
	public Type pop() {
		if(isEmpty())
		{
			return null;
		}
		else
		{
			Type answer = items[c];
			items[c] = null;
			c--;
			return answer;
		}
	}

}
