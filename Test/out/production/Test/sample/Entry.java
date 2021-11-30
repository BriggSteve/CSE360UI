package sample;

import java.io.*;



class Entry implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public String username;
    public String password;
    public String job;
    public String medication;
    public String nextAppointment;
    public Entry(String a, String b, String c, String d, String e, String f){
        name = a;
        username = b;
        password = c;
        job = d;
        medication = e;
        nextAppointment = f;
    }

}

