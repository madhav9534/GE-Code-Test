package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        char[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));
        Assume.assumeNotNull(util.getColumnValues(0));
        Assume.assumeNotNull(util.getRowValues(0));
        
        

        char[] expectedResult = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0));
        
        char[] expectedColResult = {'a', 'e', 'i', 'm'};
        assertArrayEquals(expectedColResult, util.getColumnValues(0));
        
        char[] expectedRowResult = {'a', 'b', 'c', 'd'};
        assertArrayEquals(expectedRowResult, util.getRowValues(0));
        
        
        long[][] intData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        ArrayQuadrantUtil intutil = new ArrayQuadrantUtil(intData);
        Assume.assumeNotNull(intutil.getIntQuadrantValues(0, 0));
        Assume.assumeNotNull(intutil.getIntColumnValues(0));
        Assume.assumeNotNull(intutil.getIntRowValues(0));
        
        

        long[] intexpectedResult = {1, 2, 5, 6};
        assertArrayEquals(intexpectedResult, intutil.getIntQuadrantValues(0, 0));
        
        long[] intexpectedResult1 = {1, 5, 9, 13};
        assertArrayEquals(intexpectedResult1, intutil.getIntColumnValues(0));
        
        long[] intexpectedResult2 = {1, 2, 3, 4};
        assertArrayEquals(intexpectedResult2, intutil.getIntRowValues(0));
    }
}
