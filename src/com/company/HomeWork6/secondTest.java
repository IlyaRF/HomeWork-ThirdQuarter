package com.company.HomeWork6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;




    @RunWith(Parameterized.class)
    public class secondTest {

        private int[] in;
        private int[] out;

        public secondTest(int[] in, int[] out) {
            this.in = in;
            this.out = out;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                    {new int[]{4, 2, 85, 7, 96, 5, 2, 2, 2, 1}, new int[]{2, 85, 7, 96, 5, 2, 2, 2, 1}},
                    {new int[]{1, 3, 7, 5, 4, 4, 3, 2, 7, 9, 1}, new int[]{3, 2, 7, 9, 1}},
            });
        }

        @Test
        public void test() throws RuntimeException {
            Assert.assertArrayEquals(out, secondTest.doIt(in));
        }
        public static int[] doIt(int[] array) throws RuntimeException {
            if (array.length == 0)
                throw new RuntimeException("empty array");
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == 4) {
                    if (i == array.length - 1) return new int[]{};
                    int[] newArray = new int[array.length - i - 1];
                    System.arraycopy(array, i + 1, newArray, 0, array.length - i - 1);
                    return newArray;
                }
            }
            throw new RuntimeException("there is no 4 in the array");
        }
    }