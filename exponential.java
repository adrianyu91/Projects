package random_stuff;
import java.util.Scanner;


public class exponential {
    /**
    * create mapping points for exponential
    */
    public static void fexponential(Scanner input){
        double [][] mapping=new double [4][11];
    final double e=2.71828; 
    System.out.println("is your base e? enter y or n");
    String base2=input.next();
    Double base;
    while(!base2.equals("y")||!base2.equals("n")){
        System.out.println("input y or no");
        base2=input.next();
        if(base2.equals("y")||base2.equals("n")){break;}
    }
        if(base2.equals("y")){
            base=e;
        }
        else{
            base=input.nextDouble();
        }
    System.out.println("input the transformations:");
    double vfactor=input.nextDouble();
    double hfactor=input.nextDouble();
    double hshift=input.nextDouble();
    double vshift=input.nextDouble();
    input.close();

    //number of mapping points(range -5 to 5)    
    for(int col=0;col<11;col++){
        int x=col-5;
        double y=Math.pow(base, x);
        mapping[0][col]=x;
        mapping[1][col]=y;
    }  
    //mapping points after transformations
    for(int col=0;col<11;col++){
        int x=col-5;
        //double x2=x;
        double y2= Math.pow(base,x);
        double x2=(x/hfactor)+hshift;
        y2=(vfactor*y2)+vshift;
        mapping[2][col]=x2;
        mapping[3][col]=y2;
    }
    System.out.printf("%5s%8s%7s%7s%n","x1","y1","x2","y2");
    for(int col=0;col<11;col++){
        System.out.printf("%6.1f",mapping[0][col]);
        System.out.printf("%2s%5.5f","",mapping[1][col]);
        System.out.printf("%6.1f",mapping[2][col]);
        System.out.printf("%2s%4.5f","",mapping[3][col]);
        System.out.println();
    }
    }
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("input what function you want (enter the first letter)");
    System.out.print("polynomial, inverse, exponential, logs, square roots:");
    String function=input.next();
    System.out.println();
    if(function.equals("e")){
        fexponential(input);
    }
    
    
}   

}