/**
 * MolecularMass.java
 *
 * @author Preston MacDonald
 * @version 02-09-2018
 */

import java.util.Scanner;

/**
 * Program that takes a string representation of a molecule as input and 
 * prints out its molecular mass.
 *
 * @author Preston MacDonald
 * @version 02-08-2018
 */
public class MolecularMass
{
    /**
     * Main method to run algorithm to calculate mass of a given molecule.
     */
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String molecularStr = "";

        System.out.println("\n****Running MolecularMass****\n");
        
        System.out.println("Running given test cases...");
        runGivenTestCases();
        
        System.out.println("\nRunning custom input test case...");
        runCustomTestCase(); 
    }
    
    /**
     * Method to take in custom test case and prints out molecule's molecular
     * mass.
     */
    public static void runCustomTestCase()
    {
        Scanner kb = new Scanner(System.in);
        String molecularStr = "";

        System.out.print("Valid molecules in this instant only include ");
        System.out.println("C,H,O elements.");
        System.out.println("Please input a valid molecule: ");
        molecularStr = kb.nextLine();

        molecularStr = molecularStr.toUpperCase();

        System.out.print(molecularStr + " has a molecular mass of: ");
        System.out.println(calcMass(molecularStr));
    }
     
    /**
     * Method that runs all 3 test cases given by the assignment and prints out
     * each molecule's molecular mass.
     */
    public static void runGivenTestCases()
    {
        String molecularStr = "";


        //Case #1
        molecularStr = "H2O";
        molecularStr = molecularStr.toUpperCase();
        System.out.print(molecularStr + " has a molecular mass of: ");
        System.out.println(calcMass(molecularStr));
        
        //Case #2
        molecularStr = "CH(CO2H)3";
        molecularStr = molecularStr.toUpperCase();
        System.out.print(molecularStr + " has a molecular mass of: ");
        System.out.println(calcMass(molecularStr));
        
        //Case #3
        molecularStr = "((CH)2(OH2H)(C(H))O)3";
        molecularStr = molecularStr.toUpperCase();
        System.out.print(molecularStr + " has a molecular mass of: ");
        System.out.println(calcMass(molecularStr));
    }
    
    /**
     * Method that takes a String argument that represents a molecule built
     * up with H,C, and O elements and calculates the mass of the molecule.
     *
     * @param moleStr
     *          String representation of the molecule.
     * 
     * @return mass of molecule
     */
    public static int calcMass(String moleStr)
    {
        IntStack opStack = new IntStack();
        char cursor;
        int mass;
        int multiplier = 0; //0 represents no multiplier

        for(int i = 0; i < moleStr.length(); i++)
        {
            cursor = moleStr.charAt(i);
            
            //Check to see if a multiplier needs use. 
            if(multiplier != 0 && processNum(cursor) == -1)
            {
                opStack.push(opStack.pop() * multiplier);
                multiplier = 0;
            }
            
            //Handling of symbols
            if(cursor == 'H' || cursor == 'C' || cursor == 'O' || cursor == '(')
            {
                switch(cursor)
                {
                    case 'H': opStack.push(1); break;
                    case 'C': opStack.push(12); break;
                    case 'O': opStack.push(16); break;
                    case '(': opStack.push(0); break;
                }
            }
            else if(cursor == ')') //Handling a right parenthesis
            {
                int stackCursor = opStack.pop();
                int sum = 0;
                while(stackCursor != 0)
                {
                    sum += stackCursor;
                    stackCursor = opStack.pop();    
                }
                opStack.push(sum);
            }
            else //handling a multiplier
            {
                if(multiplier == 0 && cursor != '0')
                {
                    multiplier = processNum(cursor);
                }
                else
                {
                    multiplier = (multiplier * 10) + processNum(cursor);
                }
            }
        }

        //Final check if multiplier needs use.
        if(multiplier != 0)
        {
            opStack.push(opStack.pop() * multiplier);
        }
        
        //Calculate mass by popping and adding everything in stack.
        int stackCursor = opStack.pop();
        mass = 0;

        while(stackCursor != -1)
        {
            mass += stackCursor;
            stackCursor = opStack.pop();
        }

        return mass;
    }


    /**
     * Method that takes in a character and processes if the character is a
     * proper digit and returns it. If the character is not a digit this will
     * return -1.
     *
     * @param charNum
     *          A character to convert to a digit if it meets a condition.
     *
     * @return int version of character, if not a digit, will return -1.
     */
    private static int processNum(char charNum)
    {
        switch(charNum)
        {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
        }

        return -1;
    }
}









