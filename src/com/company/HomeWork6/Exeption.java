package com.company.HomeWork6;

import org.junit.Test;


public class Exeption {


    public class secondTestException {
        @Test(expected = RuntimeException.class)
        public void testException() {
            secondTest.doIt(new int[]{1, 3, 7, 5, 2, 3, 8, 2, 1});
        }
    }
}
