import java.util.Scanner;

public class BrokenKeyboard {

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		
		String text = "";
		while (kb.hasNext()) {
			
			String line = kb.nextLine();
			text = text + line + "\n";
		}
		text = text.substring(0, text.length() - 1);	// Removing the last \n.

		// TODO: text is the entire input string, with home (^) and end ($) characters pressed. 
		// Please write code to reconstruct the original text without the home and end characters.
        System.out.println("\n input processed... \n");

        CharSet set = new CharSet();
        int selector = 1; //Selects whether to add to beginning or end.

        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == '^')
            {
                selector = 0;
            }
            else if(text.charAt(i) == '$')
            {
                selector = 1;
            }
            else
            {
               if(selector == 0)
               {
                    set.insertFront(text.charAt(i));
                    selector = 2;
               }
               else if(selector == 2)
               {
                    set.insertAfterHead(text.charAt(i));
               }
               else
               {
                    set.insertRear(text.charAt(i));
               }
            }
        }
        
        System.out.println("*****Broken Keyboard output.*****");
        System.out.println(text);

        System.out.println("\n\n *****Original text.*****");
        set.print();
    }

}
