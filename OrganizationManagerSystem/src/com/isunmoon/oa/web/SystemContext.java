package com.isunmoon.oa.web;

public class SystemContext {
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();  
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();  
   
    public static int getOffset() {
    	Integer offsetValue = (Integer) offset.get();
    	if(offsetValue == null) {
    		return 0;
    	}
    	return offsetValue;
    }
    public static void setOffset(int offsetValue) {
    	offset.set(offsetValue);
    }
    public static int getPageSize() {
    	Integer pageSizeValue = (Integer) pageSize.get();
    	if(pageSizeValue == null) {
    		return Integer.MAX_VALUE;
    	}
    	return pageSizeValue;
    }
    public static void setPageSize(int pageSizeValue) {
    	pageSize.set(pageSizeValue);
    }
    public static void removeOffset() {
    	offset.remove();
    }
    public static void removePageSize() {
    	pageSize.remove();
    }
}
