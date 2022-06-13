import java.util.Scanner;
import java.util.Stack;

public class Driveway{
    Stack<Integer> driveway;
    Stack<Integer> street;

    public Driveway(){
        driveway = new Stack<Integer>();
        street = new Stack<Integer>();
    }

    public void add(int lincesePlate){
        if(driveway.contains(lincesePlate)){
            System.out.println("Is already in the Driveway");   //Checks to see if the value is already there
        }

        else{
            driveway.push(lincesePlate);    //Adds the value to the stack
        }
        print();
    }

    public void remove(int lincesePlate){
        do{
            int move = driveway.pop();  //Moves ecverything to the street

            street.push(move);
            print();
        }
        while(driveway.contains(lincesePlate));

        do{
            int move2 = street.pop();   //Moves everthing back to the driveway
            driveway.push(move2);
            print();
        }
        while(street.contains(lincesePlate));

       /* else{
            System.out.println("Is already in the driveway");
        }*/
        
        
        print();
    }

    public void print(){
        System.out.println(driveway);
        System.out.println(street);
       /* for (int i = 0; driveway.size() > i; i++)
        {
            System.out.println(driveway.peek() + " ");
            i++;
        }

        for (int i = 0; street.size() > i; i++)
        {
            System.out.println(street.peek() + " ");
            i++;
        }*/

    }
    public static void main (String[] args)
    {
        Driveway testDriveway = new Driveway();
        Scanner in = new Scanner(System.in);
        System.out.println("Positive integers add cars to the driveway");
        System.out.println("Negative license numbers remove cars.");
        System.out.println("0 stops the simulation");

        while (in.hasNextInt())
        {
            int lincesePlate = in.nextInt();
            if(lincesePlate > 0)
            {
                testDriveway.add(lincesePlate);
            }
            else if (lincesePlate < 0)
            {
                testDriveway.remove(0 - lincesePlate);
            }
            else 
            {
                return;
            }
        }
    }
}