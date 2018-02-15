import java.util.Scanner;
import java.util.Stack;

public class Calculator {
  
  private String[] enteredValue;
  private double result=0;
  private LinkedStack<String> stack1 = new LinkedStack<String>();
  private LinkedStack<String> stack2 = new LinkedStack<String>();
  
  
  public Calculator() {};
  
  public void runIt()
  {
    setUpStack(getValue());
    System.out.println(calculateResult()+"");
  }
  
  public static boolean isNumeric(String toBeChecked)  
  {  
    try  
    {  
      double d = Double.parseDouble(toBeChecked);  
    }  
    catch(NumberFormatException nfe)  
    {  
      return false;  
    }  
    return true;  
  }
  
  public String getValue()
  {
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter value: ");
    String yeah =reader.nextLine();
    return yeah;
  }
  
  public void setUpStack(String value)
  {
    enteredValue = value.split("\\s");      
    for (int x=enteredValue.length-1; x>=0; x--)
    {
      String tempString = enteredValue[x];
      stack1.push(tempString);
    }
     
  }
  
  public double calculateResult()
  {
    String temp1;
    String temp2;
    String temp3;
    Double tempDouble;
    boolean okay=true;
    while(!stack1.isEmpty() && okay)
    {
      temp1=stack1.pop();
      if(isNumeric(temp1))
      {
        stack2.push(temp1);
      }
      else
      {
        temp2=stack2.pop();
        temp3=stack2.pop();
        if(temp1.equals("+"))
        {
          tempDouble=Double.parseDouble(temp3) + Double.parseDouble(temp2);
        }
        else if(temp1.equals("-"))
        {
          tempDouble=Double.parseDouble(temp3) - Double.parseDouble(temp2);
        }
        else if(temp1.equals("*"))
        {
          tempDouble=Double.parseDouble(temp3) * Double.parseDouble(temp2);
        }
        else
        {
          tempDouble=Double.parseDouble(temp3) / Double.parseDouble(temp2);
        }
        
        stack2.push(tempDouble+"");
       
        
        
      }
    }
    result=Double.parseDouble(stack2.pop());
    return result;
  }
  
  public String getTempResult(String num1, String num2, String op)
  {
    Double result;
    if(op.equals("+"))
    {
      result = Double.parseDouble(num1) + Double.parseDouble(num2);
    }
    else if (op.equals("-"))
    {
      result = Double.parseDouble(num1) - Double.parseDouble(num2);
    }
    else if (op.equals("*"))
    {
      result=Double.parseDouble(num1) * Double.parseDouble(num2);
    }
    else
    {
      result=Double.parseDouble(num1) / Double.parseDouble(num2);
    }
    
    String resultFinal = result +"";
    return resultFinal;
  }
  
  
  

}
