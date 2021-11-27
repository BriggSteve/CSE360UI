package sample;

import java.io.Serializable;

class Entry implements Serializable {
    public String name;
    public String username;
    public String password;
    public String job;
    public Entry(String a, String b, String c, String d){
        name = a;
        username = b;
        password = c;
        job = d;
    }


}

