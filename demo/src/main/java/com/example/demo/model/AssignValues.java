package com.example.demo.model;

import org.springframework.stereotype.Component;
import java.util.List;
import java.lang.Math;

@Component
public class AssignValues {
    private int st;
    private int dt;
    private String dtname;

    public AssignValues() {
    }

    public AssignValues(int st, int dt, String stname, String dtname) {
        this.st = st;
        this.dt = dt;
        this.dtname = dtname;
    }

    public void setSt(int st, String stname) {
        this.st = st;
    }

    public void setDt(int dt, String dtname) {
        this.dt = dt;
        this.dtname = dtname;
    }

    public void check(Passengerdetails pd, List<AssignValues> a, String email) {
        int n = a.size();
        int min = 1000;
        int x = 0;

        for (int i = 0; i < n; i++) {
            if (Math.abs(st - a.get(i).dt) < min) {
                min = Math.abs(st - a.get(i).dt);
                x = i;
            }
        }

        System.out.println("near=" + x + " " + a.get(x).dt + " " + a.get(x).dtname);

        // Sendmsg sendmsg = new Sendmsg(a.get(x).dtname, pd);
        // System.out.println(sendmsg.sendText());

        // new Sendemail(sendmsg.sendText(), email);
    }

    @Override
    public String toString() {
        return st + " " + dt + "\n";
    }
}

