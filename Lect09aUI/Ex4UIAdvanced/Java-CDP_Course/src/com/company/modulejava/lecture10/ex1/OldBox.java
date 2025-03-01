package com.company.modulejava.lecture10.ex1;

public class OldBox {
    private Object data;

//    public OldBox(Object data) {
//        this.data = data;
//    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void processData() {
        System.out.println("Processing my data " + data);
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setName("Jack");
        student2.setName("John");

        Tutor tutor  = new Tutor();
        tutor.setName("Garry");
        tutor.setSalary(100);

//        OldBox oldBox1 = new OldBox("My awesome Indian team");
//        OldBox oldBox2 = new OldBox(1);
//        OldBox oldBox3 = new OldBox(student1);
//        OldBox oldBox4 = new OldBox(student2);
//        OldBox oldBox5 = new OldBox(tutor);
//
//
//        OldBox [] oldBoxArray = new OldBox[5];
//        oldBoxArray[0] = oldBox1;
//        oldBoxArray[1] = oldBox2;
//        oldBoxArray[2] = oldBox3;
//        oldBoxArray[3] = oldBox4;
//        oldBoxArray[4] = oldBox5;
//
//        for (OldBox box: oldBoxArray) {
//            box.processData();
//        }
//
////        Parent parent = new Child();
////        Child child = new Child();
////        Child child1 = new Parent();
//
//        Object objectChild = new Child("Tezal");
//        Child child4 = (Child) objectChild;
//
//        OldBox oldBoxChild = new OldBox(objectChild);
//
//        Child child2 = new Child("AARAV");
//        OldBox oldBoxChild2 = new OldBox(child2);
//        OldBox oldBoxChild3 = new OldBox(new Child("AARAV"));
////        Object object1 = new Parent();
////        Object object2 = new Tutor();
//
//
//        String dataFromFirstBox = (String) oldBox1.getData();
    }
}
