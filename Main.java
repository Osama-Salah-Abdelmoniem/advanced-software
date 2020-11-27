package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

         CRUDoperations c1=new CRUDoperations();
        Parser p1=new Parser();
        NotificationsTemplate n1=new NotificationsTemplate();
        boolean found=false;
        n1.setTemplate("Dear {x} ,your email is ok :)");
        found=p1.Parse(n1.getTemplate());

        if(found)
        {
            n1.setSubject("confirm");
            n1.setType("email");
            n1.setLanguage("en");
            c1.create(n1.getSubject(), n1.getTemplate(), n1.getType(),p1.getPlaceHolders(),n1.getLanguage());
            c1.read("confirm");
            // c1.update(n1.getSubject(),"confirm1",n1.getTemplate(),"sms", p1.getPlaceHolders(), "EN");
            // c1.read("confirm1");
            //  c1.delete("confirm1");
            //  c1.read("confirm1");
        }
        else
        {
            System.out.println("error");
        }


    }
}
