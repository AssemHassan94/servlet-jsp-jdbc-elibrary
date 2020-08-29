package com.library.utility;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Utility {



    public static void getAllPublicMeth(String pathOfClass) {
        try {
            Method[] publicMethods = Class.forName(pathOfClass).getMethods();
            System.out.println(Arrays.toString(publicMethods));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getAllPublicField(String pathOfClass) {
        try {
            Field[] publicFields = Class.forName(pathOfClass).getFields();
            System.out.println(Arrays.toString(publicFields));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getAllAnnotations(String pathOfClass) {
        try {
            Annotation[] annotations = Class.forName(pathOfClass).getAnnotations();
            System.out.println(Arrays.toString(annotations));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
