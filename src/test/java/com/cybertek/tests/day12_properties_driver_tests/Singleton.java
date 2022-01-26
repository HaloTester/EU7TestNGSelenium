package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    /*
    singleton class will have private constructor
    it means other classes cannot create object of this class
    we use Singleton patterns in order to make sure when we work with different class at the same time
    our Driver object should be same for different situation
    */
    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize it and return it
        if(str==null){
            System.out.println("str is null. assigning value it");
            str="somevalue";
        }else{
            //if it has value just return it
            System.out.println("it has value, just returning it");
        }
        return str;
    }

}
