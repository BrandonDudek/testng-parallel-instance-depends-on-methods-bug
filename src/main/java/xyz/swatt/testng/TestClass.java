package xyz.swatt.testng;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class doing the Tests.
 */
public class TestClass {

    @DataProvider(parallel = true)
    public static Iterator< Object[] > factoryDataProvider() {

        System.out.println("Factory\tDataProvider");

        final int COUNT = 3;

        ArrayList<Object[]> toRet = new ArrayList( COUNT );

        for( int i = 0; i < COUNT; i++ ) {
            char c = (char) ( 'A' + i );
            toRet.add( new Object[] { String.valueOf(c) } );
        }

        return toRet.iterator();
    }

    private final String INSTANCE_NAME;

    @Factory(dataProvider = "factoryDataProvider")
    public TestClass(String _instanceName) {

        System.out.println("Factory\t" + _instanceName);

        INSTANCE_NAME = _instanceName;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before\tSuite " + INSTANCE_NAME);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before\tTest " + INSTANCE_NAME);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before\tClass " + INSTANCE_NAME);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before\tMethod " + INSTANCE_NAME);
    }

    @Test
    public void testMethod1() {

        for( int i = 0; i < 10; i++ ) {

            System.out.println("Test\tMethod " + INSTANCE_NAME + "-1");

            try {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException e ) {
                continue;
            }
        }
    }

    @Test(dependsOnMethods = "testMethod1")
    public void testMethod2() {

        for( int i = 0; i < (INSTANCE_NAME.equalsIgnoreCase("B") ? 100 : 10); i++ ) {

            System.out.println("Test\tMethod " + INSTANCE_NAME + "-2");

            try {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException e ) {
                continue;
            }
        }
    }

    @Test(dependsOnMethods = "testMethod2")
    public void testMethod3() {

        for( int i = 0; i < 10; i++ ) {

            System.out.println("Test\tMethod " + INSTANCE_NAME + "-3");

            try {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException e ) {
                continue;
            }
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After\tMethod " + INSTANCE_NAME);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After\tClass " + INSTANCE_NAME);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After\tTest " + INSTANCE_NAME);
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("After\tSuite " + INSTANCE_NAME);
    }

    @Override
    public String toString() {
        return INSTANCE_NAME;
    }
}
