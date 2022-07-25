package com.javatest;

import org.junit.Test;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.io.IOException;
import java.text.MessageFormat;


public class ReflectionCounter {
    public static void main(String[] args) throws IOException {
        BookingTest bookingTest = new BookingTest();
        int counter = 0;
        FileWriter myWriter = new FileWriter("TestMethodsList.txt");

        Class bookingTestClass = bookingTest.getClass();
        for (Method methodWithAnnotationTest : bookingTestClass.getDeclaredMethods()) {
            if (methodWithAnnotationTest.getAnnotation(Test.class) != null) {
                try {
                    myWriter.write(MessageFormat.format("{0}, ", methodWithAnnotationTest.getName()));
                } catch (IOException e) {
                    System.out.println("Exception occurred.");
                    e.printStackTrace();
                }
                counter++;
            }
        }
        myWriter.close();
        System.out.println(MessageFormat.format("Count of test methods: {0}", counter));
        System.out.println("Successfully wrote method names to the file.");
    }
}
