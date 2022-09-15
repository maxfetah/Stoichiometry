/**
 * Solves Basic Stoichiometry from both grams to moles and moles to grams of single element equations
 * and more complex formulas.
 *
 * @author (Max Fetah)
 * @version (1.01)
 * 
 */
import java.util.Scanner;
public class Stoichiometry
{  
   String equation = "";
    public int toWeight(String e)
    {
        String input = e; 
        
        switch(input) {
            case "H":
                return 1;
            case "He":
                return 4;
            case "Li":
                return 7;
            case "Be":
                return 9;
            case "B":
                return 11;
            case "C":
                return 12;
            case "N":
                return 14;
            case "O":
                return 16;
            case "F":
                return 19;
            case "Ne":
                return 20;
            case "Na":
                return 23;
            case "Mg":
                return 24;
            case "Al":
                return 27;
            case "Si":
                return 28;
            case "P":
                return 31;
            case "S":
                return 32;
                
                
            default:
                throw new IllegalArgumentException("Invalid Element: " + input);
            }
   }   
   
   public void direction()
   {
       Scanner scan = new Scanner(System.in);
       int dir = 0; int dirCheckComment = 0;
       
            while(dir != 1 && dir != 2)
            {
                if (dirCheckComment !=0)
                    System.out.println("Please enter \"1\" or \"2\"\n");
                System.out.println("Moles to Grams (1) or Grams to Moles (2) \n               (1) or (2)\n");
                dir = scan.nextInt();
                dirCheckComment++;
            }  
            
       if(dir == 1)
            MolesGrams();
       else
            GramsMoles();
    }
   
   public void MolesGrams()
   {
       double moles = inputMoles();
       double weight = equationWeight();
       //double weight = equationWeightImproved();
       System.out.println(moles + " Moles of " + equation + " with weight " + weight + " is " + (moles * weight) + " grams."); 
    }
    
   public void GramsMoles()
   {
       double grams = inputGrams();
       double weight = equationWeight();
       //double weight = equationWeightImproved();
       System.out.println(grams + " grams of " + equation + " with weight " + weight + " is " + (grams / weight) + " moles.");
    }
   
   public double inputMoles()
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter amt of Moles: ");
       return scan.nextDouble();
    }
    
   public double inputGrams()
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter amt of Grams: ");
       return scan.nextDouble();
    }
   
   public double equationWeightImproved()
   {
       Scanner scan = new Scanner(System.in);
       String input = ""; double weight = 0; int curSubscript = 0; 
       System.out.println("Enter formula of compound: (ex. C6H12O6 or H or CO2)");
       input = scan.nextLine();
       
       for(int x = input.length() - 1; x > 0; x--)
       {
           String sendTotoWeight = "";
           if(Character.isDigit(input.charAt(x))) 
                {
                    curSubscript = input.charAt(x); int elementLetters = 0; int subscribDigs = 0; 
                    
                    if(curSubscript > 9)
                        subscribDigs = 1;
                    else
                        subscribDigs = 2;
                    
                    if(x+1 < input.length() && Character.isDigit(input.charAt(x+1)))
                    {
                        curSubscript = (curSubscript * 10) + input.charAt(x+1);
                    }
                    
                    if(Character.isLowerCase(input.charAt(x-1)))
                    {
                        //two letter element
                        elementLetters = 2;
                        sendTotoWeight += input.substring(x-2-subscribDigs);
                        weight += toWeight(sendTotoWeight);
                        
                    }
                    else
                    {
                        //one letter element                        
                        elementLetters = 1;
                        sendTotoWeight += input.substring(x-1-subscribDigs);
                        weight += toWeight(sendTotoWeight);
                        
                    }
                                      
                    input = input.substring(0, x-(subscribDigs+elementLetters));
                        
                }
           
           else
           {
               sendTotoWeight += input.charAt(x);
               weight += toWeight(sendTotoWeight);
               input = input.substring(0, x-1);
               
            }
           
        }
       
       return weight;
    }
    
   
   public double equationWeight()
   {
       int moreE = 1;
       int weight = 0; 
       while (moreE == 1)
                 {
                     Scanner scan = new Scanner(System.in);
                     int curweight = 0; 
                     String inputE = "";
                     System.out.println("Enter an Element's Symbol. ex. \"Cu\"");
                     inputE = scan.nextLine();
                     weight+= toWeight(inputE);   
                     equation = equation + "" + inputE;
                     
                     System.out.println("Another Element? Yes (1), No (0)");
                     moreE = scan.nextInt();
                 }
       return weight;
    }
    
   /** 
    **/
}

