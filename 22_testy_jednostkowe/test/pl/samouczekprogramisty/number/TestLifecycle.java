package pl.samouczekprogramisty.number;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifecycle {
    @Before
    public void setUp() {
        System.out.println("set up");
        System.out.flush();
    }

    @After
    public void tearDown() {
        System.out.println("tear down");
        System.out.flush();
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("set up class");
        System.out.flush();
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tear down class");
        System.out.flush();
    }

    @Test
    public void test1() {
        System.out.println("test 1");
        System.out.flush();
    }

    @Test
    public void test2() {
        System.out.println("test 2");
        System.out.flush();
    }
}

