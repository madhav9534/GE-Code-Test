package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    char[][] charData;
    long[][] longData;
    double[][] doubleData;

    public ArrayQuadrantUtil(char[][] data) {
        this.charData = data;
    }
    public ArrayQuadrantUtil(long[][] data) {
        this.longData = data;
    }
    public ArrayQuadrantUtil(double[][] data) {
        this.doubleData = data;
    }
    
    
    
    public char[] getColumnValues(int column) {
    	int index = 0;
    	char[] ret = new char[charData.length];
    	
    	for(int j = column;j<charData.length;j++){
			ret[index++] = charData[j][column];
		}
    	return ret;
    }

    public char[] getRowValues(int row) {
    	int index = 0;
    	char[] ret = new char[charData.length];
    	for(int j = row;j<charData.length;j++){
			ret[index++] = charData[row][j];
		}
    	return ret;
    }
    public char[] getQuadrantValues(int row, int column) {
        	int size = charData.length/2;
    	char[] ret = new char[charData.length];
    	int index = 0;
    	
    	
    	for(int i =row;i<size;i++){
    		for(int j = column;j<size;j++){
    			ret[index++] = charData[i][j];
    		}
    	}
    	
        return ret ;
    }
    
    
    //Long
    
    public long[] getIntColumnValues(int column) {
    	int index = 0;
    	long[] ret = new long[longData.length];
    	
    	for(int j = column;j<longData.length;j++){
			ret[index++] = longData[j][column];
		}
    	return ret;
    }

    public long[] getIntRowValues(int row) {
    	int index = 0;
    	long[] ret = new long[longData.length];
    	for(int j = row;j<longData.length;j++){
			ret[index++] = longData[row][j];
		}
    	return ret;
    }
    public long[] getIntQuadrantValues(int row, int column) {
        	int size = longData.length/2;
    	long[] ret = new long[longData.length];
    	int index = 0;
    	
    	
    	for(int i =row;i<size;i++){
    		for(int j = column;j<size;j++){
    			ret[index++] = longData[i][j];
    		}
    	}
    	
        return ret ;
    }
}
