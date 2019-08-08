package com.cm.jdk8.chapter3;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/1 11:17
 */
public class Letter {
    public static String addHeader(String text){
       return "Dear "+text+":";
    }

    public static  String addFooter(String text){
        return text+"\r\n\tbest wish";
    }
}
