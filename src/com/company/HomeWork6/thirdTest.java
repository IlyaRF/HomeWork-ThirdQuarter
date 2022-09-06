package com.company.HomeWork6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;



    @RunWith(Parameterized.class)
    public class thirdTest {
        private int[] in;
        private boolean out;

        public thirdTest(int[] in, boolean out) {
            this.in = in;
            this.out = out;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {new int[]{3, 4, 1, 5, 9, 4, 4, 7, 4, 8, 6}, true},
                    {new int[]{4, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true},
                    {new int[]{5, 7, 5, 27, 16, 7}, true}, // Error
                    {new int[]{2, 3, 6, 7, 9}, false},
                    {new int[]{8, 30, 61, 72, 9, 4, 66}, true},
                    {new int[]{2, 3, 4, 7, 92, 2, 6, 8, 1}, false}, // Error
            });
        }

        @Test
        public void test() {
            Assert.assertEquals(thirdTest.doIt(in), out);
        }
        public static boolean doIt(int[] array) {
            for (int j : array) {
                if (j == 1 || j == 4)
                    return true;
            }
            return false;
        }
    }

