package com.cathaybk.lambda.function;

import com.cathaybk.lambda.functionInterface.IGreetingService;

/**
* 測試 JDK8 Function-Interface
* @author RogerLo
* @date 2022-02-14
*/
public class Test_Function002 {

    // Roger-Fix
    public static void main(String[] args) {
        IGreetingService greetingSvc = (uName) -> "Hello, " + uName;
        System.out.println(greetingSvc.generateGreetingMsg("Roger"));
        System.out.println("----------------------------------------------------");
        System.out.println(buildWelcomeMsg("Grazie ~ ", "Roger", (x) -> "Halo " + x));
    }

    public static String buildWelcomeMsg(String prefixStr, String username, IGreetingService iGreetingSvc) {
        return prefixStr + iGreetingSvc.generateGreetingMsg(username);
    }

}
