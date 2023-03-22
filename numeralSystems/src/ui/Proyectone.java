/*
Inputs:
option : (int) - Integer: receives the option that the user wants to choose, with respect to the mathematical function to operate
a : (double) : receives the value of a: interacts as variable x in the bisection method when evaluating the different functions
b : (double): receives the value of b: interacts as variable x in the bisection method when evaluating the different functions
x : (double) : receives through the user the value of x, which is subsequently replaced in function two

Output:
c : (double) : shows the user as output the approximate root of the function evaluated by means of the bisection method.

Problem context:

This program or integrator, aims to search through a function that is given by the user through an input (option), 
which in total are three functions to perform, evaluate by means of the bisection method an exact approximation of the root of function(c). 
In the program, different methods were used that corresponded to each of the parts of the Taylor method, which is used to find the cosine of a number x,
such as pow(potentiation), factorial, the absolute value and finally each function to be solved.

The bisection method was used to find the root of a function on an interval. This method is based on the theory that if a function is continuous on a closed interval [a, b],
it takes values with opposite signs at points a and b. This repeatedly divides the interval [a, b] in half and determines in which half the root of the function lies.
At each iteration (50) of the algorithm within the function, the function is evaluated at the midpoint of the interval and determines which half the root lies in,
giving the user the root = c, as result.

*/ 
package ui;
import java.util.Scanner;
import java.util.function.Function;
public class Proyectone{
    public static void main(String[] arg){
        Scanner reader = new Scanner(System.in);
        double a;
        double b;
        int option=0;
        double c;

        while(option!=4){
            menu();
            option = reader.nextInt();
                //function one
                if(option==1){
                    System.out.println("");
                	System.out.println("Enter the value of (A), in the function: ");
                    a = reader.nextDouble();
                    System.out.println("Enter the value of (B), in the function: ");
                    b = reader.nextDouble();

                    double root = biseccion(a, b, x -> functionone(x));
                    
                    if(Double.isNaN(root)) {
                        System.out.println("");
                        System.out.println("'The root does not exist'");
                    } else {
                        System.out.println("");
                        System.out.println("'The approximate value of the root is': " + root);
                    }
                    
                //function two
                }else if(option==2) {
                    double x;
                    System.out.println("");
                	System.out.println("Enter the value of (X)");
                    x = reader.nextInt();
                    double result2 = functiontwo(x);
                    System.out.println("");
                    System.out.println("'The result of fuction is': " + result2);
                   
                //function three
                }else if(option==3) {
                	System.out.println("Enter the value of A, in the function: ");
                    a = reader.nextDouble();
                    System.out.println("Enter the value of B, in the function: ");
                    b = reader.nextDouble();

                    double root = biseccion(a, b, x -> functionthree(x));
                     
                    if(Double.isNaN(root)) {
                        System.out.println("");
                        System.out.println("'The root does not exist'");
                    }else{
                        System.out.println("");
                        System.out.println("'The approximate value of the root is': " + root);
                    }
                 
                //option exit
                }else if(option==4){
                    System.out.println("");
                    System.out.println("'Exit successfully'");
                    System.out.println("");
                    
                }else{
                    System.out.println("");
                    System.out.println("'Invalid function'");
                }
        }
    } //Main

    //options menu method
    public static void menu(){
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Enter the function to operate: ");
        System.out.println("------------------------------");
        System.out.println("1. y = 2Cos(x^2)");
        System.out.println("2. y = 3(x^3) + 7(x^2) + 5");
        System.out.println("3. y = xCos(x)");
        System.out.println("4. Exit");
    }

    //method function 1, cosine
    public static double functionone(double x){
        double function=2*cose(pow(x,2));
        return function;
    }

    //method function 2, polynomial
    public static double functiontwo(double x){
        double function=3*pow(x,3)+7*pow(x,2)+5;
        return function;
    }

    //method function 3, cosine
    public static double functionthree(double x){
        double function=x*cose(x);
        return function;
    }

    //factorial method
    //take the factorial of a number x
    public static double factorial(double x) {
        double resultfactory = 1;
        for (double i = 1; i <= x; i++) {
            resultfactory *= i;
        }
        return resultfactory;
    }

    //method on potentiation of a number
    //Get the exponential value of the number x with exponent n.
    public static double pow(double x, double n){
        double resultpow = 1;
        for (int i = 1; i <= n; i++) {
            resultpow *= x;
        }
        return resultpow;
    }

    //absolute value method
    //Gets the absolute value of a number, depending on whether it is negative or positive.
    public static double abs(double x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }
    
    //definitive method of cosine
    //By means of Taylor's method, obtain an approximate value of the cosine
    public static double cose(double x){
        double resultcos = 0;
        for (int i = 0; i < 50; i++) {
            resultcos += ((pow(-1,i))*pow(x,(2*i))/(factorial((2*i))));
        }
        return resultcos;
    }
    //Bisection method
    //performs the bisection method, specified in the context of the problem
    public static double biseccion(double a, double b, Function<Double, Double> func) {
        double c = 0;
        double error = 0;
        double epsilon=0.000000001;

        double n=abs(b-a);
        do {
            c = (a+b)/2;
            if (func.apply(a)*func.apply(c) < 0) {
                b = c;
            } else {
                a = c;
            }
            error = (abs(b-a)/(2*n));
        } while (error > epsilon);
        
        return c;
    }
}//Class
