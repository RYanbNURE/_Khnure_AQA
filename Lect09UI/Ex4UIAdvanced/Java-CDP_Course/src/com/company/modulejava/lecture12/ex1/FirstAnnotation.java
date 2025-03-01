package com.company.modulejava.lecture12.ex1;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//        RetentionPolicy.SOURCE – visible only in the source code
//        RetentionPolicy.CLASS – visible to the compiler at compilation time
//        RetentionPolicy.RUNTIME – visible to the compiler and to the runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
}
