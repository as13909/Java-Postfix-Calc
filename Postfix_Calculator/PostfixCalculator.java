package Aaron_Stein_hw_two;

public class PostfixCalculator {

	//setting variables
	Converter c1 = new Converter();
	private Character item = null;
	String temp = "";
	private String s_num1, s_num2, s_answer, temp2 = "";
	private Integer num1;
	Integer answer;
	Integer num2;
	ArrayStack<String> stack = new ArrayStack<String>(1000);
	
	public String PostfixCalculator(String postfix)
	{
		for(int i = 0; i < postfix.length(); i++) //loops through the String
		{
			item = postfix.charAt(i);
			
			if(item == ' ') //if theres a space activates this if statement
			{
				if(temp != "") //makes sure the temp var isn't empty
				{
					stack.push(temp);
					temp = "";
				}
					
			}
			else
			{
				if(Character.isDigit(item)) 
					//for more than 1 char numbers it adds the elements together
				{
					temp = temp + item.toString();
				}
			}
				
		
			if(item == '+') //adds two #s together if there is a +
			{
				s_num2 = stack.pop(); //takes it out as string
				s_num1 = stack.pop();
				
				//converts to int and does calculations
				num2 = Integer.parseInt(s_num2);
				num1 = Integer.parseInt(s_num1);
				
				answer = (num1 + num2);
				//back to string to go back in ArrayStack
				s_answer = Integer.toString(answer);
				
				stack.push(s_answer);
			}
			else if(item == '-') //subtracts #s if there is -
			{
				s_num2 = stack.pop(); //takes it out as string
				s_num1 = stack.pop();
				
				//converts to int and does calculations
				num2 = Integer.parseInt(s_num2);
				num1 = Integer.parseInt(s_num1);
				
				answer = (num1 - num2);
				
				//back to string to go back in ArrayStack
				s_answer = Integer.toString(answer);
				
				stack.push(s_answer);
			}
			else if(item == '/') //divides 2 #s
			{
				s_num2 = stack.pop(); //takes it out as string
				s_num1 = stack.pop();
				
				//converts to int and does calculations
				num2 = Integer.parseInt(s_num2);
				num1 = Integer.parseInt(s_num1);
				
				answer = (num1 / num2);
				
				//back to string to go back in ArrayStack
				s_answer = Integer.toString(answer);
				
				stack.push(s_answer);
				
			}
			else if(item == '*') //multiplies 2 numbers
			{
				s_num2 = stack.pop(); //takes it out as string
				s_num1 = stack.pop();
				
				//converts to int and does calculations
				num2 = Integer.parseInt(s_num2);
				num1 = Integer.parseInt(s_num1);
				
				answer = (num1 * num2);
				
				//back to string to go back in ArrayStack
				s_answer = Integer.toString(answer);
				
				stack.push(s_answer);
			}
			else if(item == '^') //exponents
			{
				s_num2 = stack.pop(); //takes it out as string
				s_num1 = stack.pop();
				
				//converts to int and does calculations
				num2 = Integer.parseInt(s_num2);
				num1 = Integer.parseInt(s_num1);
				
				answer = (int) (Math.pow(num1, num2));

				//back to string to go back in ArrayStack
				s_answer = Integer.toString(answer);
				
				stack.push(s_answer);
				
			}
		}
		return stack.top(); //returs solved problem 
		
	}
	
}
