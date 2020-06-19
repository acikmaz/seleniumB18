package test.day05_testng_intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGClass {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method is running...");
    }

    @Test
    public void test1(){
        System.out.println("test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }
}
