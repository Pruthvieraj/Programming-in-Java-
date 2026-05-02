import java.util.Scanner; 
public class ArithmeticOperations{ 
    public int num1,num2; 
    public int addNums(int n1,int n2){ 
        return n1+n2; 
    } 
    public int subNums(int n1,int n2){ 
        return n1-n2; 
    } 
    public long mulNums(int n1,int n2){ 
        return n1*n2; 
    } 
    public float divNums(int n1,int n2){ 
        return n1/n2; 
    } 
    public int modNums(int n1,int n2){ 
        return n1%n2; 
    } 
        public static void main(String[] args){ 
            ArithmeticOperations op = new ArithmeticOperations(); 
            Scanner scan = new Scanner(System.in); 
            System.out.println( "Enter first number:"); 
            op.num1 = scan.nextInt(); 
            System.out.println( "Enter second number:"); 
            op.num2 = scan.nextInt(); 
            int sum = op.addNums(op.num1,op.num2); 
            int diff = op.subNums(op.num1,op.num2); 
            long prod = op.mulNums(op.num1,op.num2); 
            float div = op.divNums(op.num1,op.num2); 
            int mod = op.modNums(op.num1,op.num2); 
        //System.out.println("Sum: " + sum + " Difference: " + diff + " Product: "+ prod + " Division: " + div + " Modulus: " + mod ); 
 
            System.out.println(" Sum: " + sum); 
            System.out.println(" Difference: " + diff); 
            System.out.println(" Product: "+ prod); 
            System.out.println(" Division: " + div); 
            System.out.println(" Modulus: " + mod ); 
            scan.close(); 
        } 
    }
    