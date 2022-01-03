package basic.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TestEnter {

    static String readFirstLineFromFile(String path) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
            writer.println("Hello World");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "x";
    }

    public String canEnter(Integer age) {
        try {
            ValidateAge validateAge = new ValidateAge();
            validateAge.canEnter(age);
        } catch (MyExceptionValidateAge ex) {
            System.out.println("Enter 1 line");
            //throw  new MyExceptionValidateAge("Enter 1 line");
            //throw ex;
        } catch (IllegalArgumentException ex1) {
            System.out.println("Enter 2 line");
            throw ex1;
        } catch (Exception ex2) {
            System.out.println("Enter 3 line");
            throw ex2;
        }

        return "You can enter";
    }

    public static void print(int a , int b) {
        int result = a / b;

    }

    public static void main(String[] args) throws MyExceptionValidateAge{
        TestEnter testEnter = new TestEnter();
        testEnter.canEnter(2);

        try {
            print(1, 0);

        } catch (ArithmeticException ex) {
            System.out.println("Deu problema".concat( ex.toString()));

        }


    }
}
