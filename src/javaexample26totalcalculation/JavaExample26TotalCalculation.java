package javaexample26totalcalculation;

import java.util.Scanner;

public class JavaExample26TotalCalculation {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int numberOfGoods = 0;
        
        numberOfGoods = TheNumberOfGoods(in);
        
        int[] amounts = Amounts(in, numberOfGoods);
        
        double[] prices = Prices(in, numberOfGoods);
        
        Total(amounts, prices);
        
        in.close();
    }// end main()
    
    private static void Total(int[] amounts, double[] prices) {
        double total = 0;
        total = TotalCalculation(amounts, prices);
        System.out.println("Total is: " + total);
    }
    
    private static double[] Prices(Scanner in, int numberOfGoods) {
        double[] prices = new double[numberOfGoods];
        System.out.println("Enter the prices of goods. One price for one thing.");
        InitializeDoubleArray(prices, in);
        in.nextLine();
        return prices;
    }
    
    private static int[] Amounts(Scanner in, int numberOfGoods) {
        int[] amounts = new int[numberOfGoods];
        System.out.println("Enter the amonuts of goods. One amount for one thing.");
        InitializeIntegerArray(amounts, in);
        in.nextLine();
        return amounts;
    }
    
    private static int TheNumberOfGoods(Scanner in) {
        System.out.print("Enter number of goods: ");
        int numberOfGoods = GetInteger(in);
        in.nextLine();
        return numberOfGoods;
    }
    
    private static double TotalCalculation(int[] a, double[] b) {
        double res = 0;
        for (int i = 0; i < a.length; i++) {
            res = res + ((double) a[i] * b[i]);
        }
        return res;
    }
    
    private static void InitializeDoubleArray(double[] arr, Scanner input) {
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextDouble();
            }
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            System.out.println("Re-initialze your double-array");
            InitializeDoubleArray(arr, input);
        }// end catch
    }// end InitializeDoubleArray()
    
    private static void InitializeIntegerArray(int[] arr, Scanner input) {
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextInt();
            }
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            System.out.println("Re-initialize your integer-array");
            InitializeIntegerArray(arr, input);
        }// end catch
    } // end InitializeIntegerArray()
    
    public static int GetInteger(Scanner input) {
        int res = 0;
        try {
            res = input.nextInt();
            if (res <= 0) {
                throw new IllegalArgumentException("zero or negative number!");
            }
            return res;
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            return GetInteger(input);
        }
    }// end GetInteger()
    
    private static double GetDouble(Scanner input) {
        double res = 0;
        try {
            res = input.nextDouble();
            if (res <= 0) {
                throw new IllegalArgumentException("zero or negative number!");
            }
            return res;
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            return GetDouble(input);
        }
    }// end GetInteger()
}
