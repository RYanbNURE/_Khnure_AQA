package com.company.modulejava.lecture16.ex1;

public class Contact implements Cloneable{
    private long phoneNo;
    private String email;
    private String address;
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    Contact(long phoneNo, String email, String address ){
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }
    public void displayContact() {
        System.out.println("Phone no: "+this.phoneNo);
        System.out.println("Email: "+this.email);
        System.out.println("Address: "+this.address);
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
