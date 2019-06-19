
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String	s="10";	
        int i=Integer.parseInt(s);	
        System.out.println(i);
        String	pi="3.1415026535";	
        float	π=Float.parseFloat(pi);
        System.out.println(π);
        Scanner scanner =new Scanner(System.in);
        String inputString;
        int z;
        boolean corretto =true;
        do{
            try{
                System.out.println("scrivi numero");
                inputString=scanner.nextLine();
                z = Integer.parseInt(inputString);
                System.out.println("input valido!");
                corretto=false;
            }catch(NumberFormatException ex){
                System.out.println("input non valido!");
                System.out.println(ex);
                corretto =true;
            }finally{
                    System.out.println("---------------");
            }
        }while(corretto);
    }
}
/** OUTPUT
10
3.1415026
scrivi numero
a
input non valido!
java.lang.NumberFormatException: For input string: "a"
---------------
scrivi numero
b
input non valido!
java.lang.NumberFormatException: For input string: "b"
---------------
scrivi numero
30
input valido!
---------------

**/