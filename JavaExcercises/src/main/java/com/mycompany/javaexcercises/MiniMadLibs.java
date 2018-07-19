
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class MiniMadLibs {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        
        System.out.print("Please give me a noun? ");
        a = inputReader.nextLine();
        System.out.print("Now an adjective! ");
        b = inputReader.nextLine();
        System.out.print("Another noun next ");
        c = inputReader.nextLine();
        System.out.print("How about a number ");
        d = inputReader.nextLine();
        System.out.print("Give me a plural noun ");
        e = inputReader.nextLine();
        System.out.print("Give me another plural noun ");
        f = inputReader.nextLine();
        System.out.print("How about one more");
        g = inputReader.nextLine();
        System.out.print("How about an adverb ");
        h = inputReader.nextLine();
        System.out.print("How about a verb ");
        i = inputReader.nextLine();
        System.out.print("Lastly, may I have another verb? ");
        j = inputReader.nextLine();
        
        System.out.println(a + ": the" +b+ " frontier. These are the voyages of the starship" +c+". "
                + "Its" + d + "-year mission: to explore strange" + e +" " + f + ", to seek out " + e +" " + g + "and" + e + "" + h + ","
                + " to boldly "+ i +" where no one has "+ j +" before.");
    }
}
