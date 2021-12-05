package com.bilgeadam.ogrencidb;


import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class CalistirSelect {
    public static void main(String[] args) {

        try{

            //Class.forName ile jdbc driverın ilgili calssını gösteriyoruz.
            Class.forName("org.postgresql.Driver");

            //Connection objesi oluşturuyoruz.
            Connection conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/ogrencidb", "postgres", "postgres");

            //Statement ile sql sorgusu yazabiliriz.
            Statement st = conn.createStatement();

            //Select sonucu ResultSet'e atılır.
            ResultSet rs = st.executeQuery("select no, ad, soyad, kredi from ogrenci order by kredi desc ");

            //rs üzerinde while ile döneriz.
            while(rs.next()){
                System.out.print("No:" + rs.getInt("no"));
                System.out.print("Ad" +rs.getString(2));
                System.out.print("Soyad:" +rs.getString(3));
                System.out.print("Kredi:" +rs.getDouble("kredi"));
                System.out.println();
            }
            rs.close();
            conn.close();

        }
        catch (Exception e){
            System.err.println("Hata:" + e.getMessage());
        }
    }
}
