package com.yang.portal.test.config;

public class ThreadContext {

    private static final ThreadLocal<String> ACCOUNT_ID = new ThreadLocal<>();

    public static void setAccountId(String accountId){
        ACCOUNT_ID.set(accountId);
    }

    public static String getAccountId(){
        return ACCOUNT_ID.get();
    }

    public static void remove(){
        ACCOUNT_ID.remove();
    }
}
