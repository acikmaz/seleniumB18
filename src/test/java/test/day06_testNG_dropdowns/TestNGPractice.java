package test.day06_testNG_dropdowns;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPractice {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }



}
