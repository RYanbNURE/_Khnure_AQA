package com.company.modulejava.lecture12.ex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
        Field classMemberField = ClassWithAnnotations.class.getDeclaredField("classMember");
        Annotation[] annotations = classMemberField.getDeclaredAnnotations();
//        System.out.println(annotations.length == 2); //true

        System.out.println((classMemberField.isAnnotationPresent(FirstAnnotation.class)));
        System.out.println((classMemberField.isAnnotationPresent(SecondAnnotation.class)));
        System.out.println((classMemberField.isAnnotationPresent(ThirdAnnotation.class)));
//        assertThat(classMemberField.isAnnotationPresent(SecondAnnotation.class)).isTrue();
//        assertThat(classMemberField.isAnnotationPresent(ThirdAnnotation.class)).isFalse();
    }
}


//    @Test
//    public void whenCallingIsAnnotationPresent_thenOnlyRuntimeAnnotationsAreAvailable() throws NoSuchFieldException {
//        Field classMemberField = ClassWithAnnotations.class.getDeclaredField("classMember");
//        assertThat(classMemberField.isAnnotationPresent(FirstAnnotation.class)).isTrue();
//        assertThat(classMemberField.isAnnotationPresent(SecondAnnotation.class)).isTrue();
//        assertThat(classMemberField.isAnnotationPresent(ThirdAnnotation.class)).isFalse();
//    }

//    @Test
//    public void whenCallingGetDeclaredAnnotationsOrGetAnnotations_thenSameAnnotationsAreReturned() throws NoSuchFieldException {
//        Field classMemberField = ClassWithAnnotations.class.getDeclaredField("classMember");
//        Annotation[] declaredAnnotations = classMemberField.getDeclaredAnnotations();
//        Annotation[] annotations = classMemberField.getAnnotations();
//        assertThat(declaredAnnotations).containsExactly(annotations);
//    }