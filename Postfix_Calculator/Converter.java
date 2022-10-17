package Aaron_Stein_hw_two;
//Aaron Stein. 3/27/22. Homework 3
public class Converter {
	
	//setting variables
	ArrayStack<Character> stack = new ArrayStack<Character>(1000);
	private String output = "";
	private Character[] lst;
	private String infix;
	
	//constructor
	public Converter()
	{
		
	}
	public Converter(String input)
	{
		infix = input;
		
	}
	public String toPostfix(String infix)
	{
		lst = new Character[infix.length()]; //creates an array to store formula
		
		for(int q = 0; q < infix.length(); q++)
		{
			lst[q] = infix.charAt(q); //adds the #s to the array 
		}
		
		Character temp_out = null;
		for(int x = 0; x < lst.length; x++) //iterates through the array
		{
			if(Character.isDigit(lst[x]) == false && lst[x] != '(' && lst[x] != ')')
			{
				output = output + " "; //adds all the #s to the output
			}
			if(Character.isDigit(lst[x]) && lst[x] != null)
			{
				output = output + lst[x];
			}
			else if(lst[x] == '(')
			{
				stack.push(lst[x]); //puts open parentheisis onto the stack
			}
			else if(lst[x] == ')') //goes back through stack if there is a closed parenthesis
			{
				stack.push(lst[x]);
				for(int i = 0; i < stack.size(); i++) //iterates thru stack
				{
					if(lst[x] == '(') //stops if it finds other closed parentehsis 
					{
						i = stack.size();
					}
					else
					{
						temp_out = stack.pop();
						if(temp_out != ')' && temp_out != '(')
						{
							output = output + " " + temp_out; //adds everything inbetween parenthesis to output
						}
					}
					
				}
				if(stack.isEmpty() == false)
				{
					if(stack.top() == '(') //gets rid of extra parenthesis
					{
						
					}
					else if(stack.isEmpty() == false) //checks for double parenthesis
					{
						output = output + " " + stack.pop();
					}
				}
					
			}
			else if(this.precedence(lst[x]) || stack.isEmpty() //checks for precedence
					|| stack.top() == '(')
			{
				stack.push(lst[x]);			
			}
			
			else if(this.precedence(lst[x]) == false)
			{
		
				while(true)
				{
					if(stack.isEmpty())
					{
						break;
					}
					if(this.precedence(lst[x]))
					{
			
						break;
					}
					else if(stack.top() != null && stack.top() != '(' && stack.top() != ')')
					{
						
						output = output + stack.pop() + " "; 
					}
				}
				
				stack.push(lst[x]);
			}
		}
		if(stack.isEmpty() == false) //gets rid of all the extra operators in the stack
		{
			for(int x = 0; x < stack.size()+1; x++)
			{
				if(stack.top() != '(' && stack.top() != ')')
				{
					output = output + " " + stack.pop();
				}
			}
		}
		
		return output; //returns the final postfix
	}
	public boolean precedence(Character sign) //checks for precedence
	{
		int sign_val = 0, temp1_val = 0; //sets variables 
		Character temp1 = null;
		if(stack.isEmpty())
		{
			return true;
		}
		else
		{
			temp1 = stack.top();
		}
		
		
		if(sign == '^') //assigns highest value to exponent
		{
			sign_val = 1;
		}
		if(sign == '*' || sign == '/') //2nd highest to multiply and divide
		{
			sign_val = 2;
		}
		if(sign == '+' || sign == '-') //lowest to plus and minus 
		{
			sign_val = 3;
		}
		
		if(temp1 == '^')
		{
			temp1_val = 1;
		}
		if(temp1 == '*' || sign == '/')
		{
			temp1_val = 2;
		}
		if(temp1 == '+' || sign == '-')
		{
			temp1_val = 3;
		}
		
		if(sign_val < temp1_val) //returns true if the checked value is greater than the top of the stack value
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
