//Aaron Stein. 3/27/22. Homework 3

package Aaron_Stein_hw_two;

import java.util.Scanner;

public class Main {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in); //two different scanner objects to make sure the user input is collected
		Scanner kb2 = new Scanner(System.in);
		ExpressionTree t = new ExpressionTree();
		Converter c = new Converter();
		boolean loop = true, loop2;
		String expression, user_input = "";
		
		//loops to make sure user can add as many different formulas as they want
		while(loop)
		{
			loop2 = true;
			System.out.println("Type your expression: ");
			expression = kb.nextLine();
			expression = c.toPostfix(expression);
			
			System.out.print("Prefix: "); 
			t.prefix(t.convert(expression));
			System.out.print("\n");
			
			System.out.print("Infix: "); 
			t.infix(t.convert(expression));
			System.out.print("\n");
			
			System.out.print("Postfix: "); 
			t.postfix(t.convert(expression));
			
			System.out.println("\n" + "\n" + "Would you like to type another expression ('yes'/'no'): ");
			
			while(loop2) //second loop to see if user wants to continue 
			{
				
				user_input = kb2.nextLine();
				if(user_input.equals("yes"))
				{
					System.out.println();
					loop = true;
					loop2 = false;
				}
				else if(user_input.equals("no"))
				{
					loop = false;
					loop2 = false;
				}
				else
				{
					System.out.println("Please type 'yes' or 'no'");
					loop2 = true;
				}
				
			}
			
		}
		
	}
}
