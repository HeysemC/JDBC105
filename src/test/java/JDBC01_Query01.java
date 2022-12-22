import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-ilgili Driver'i yuklemeliyiz - MySQL kullandigimizi bildiriyoruz
        //Driver'i bulamama ihtimaline karsi forName method'u benden "ClassNotFoundException"
        //icin main method'a Exception firlatmami istiyor
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2- Baglantiyi olusturmak icin username ve password girisi yapmaliyiz
        //Burada da username ve password'un yanlis olamsi ihtimtline karsi getConnection method'u
        //SQLException firlatmamizi istiyor
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        //3-SQL Qeury'leri icin bir Statement objesi olusturup,Java'da kendimize SQL sorgularimizi icin bir alan acacagiz
        Statement st = con.createStatement();

        //4-SQL sorgularini yazip, calistirabiliriz
        ResultSet veri =st.executeQuery(" select * from calisanlar");

        //Gorebilmek icin;
        // 5-Sonuclari gormek icin Iteration ile Set icersindeki elemanlari while dongusu icersinde yazdiracagiz

       /*
       CREATE TABLE calisanlar
	(
		id INT PRIMARY KEY,
		isim VARCHAR(50),
		sehir VARCHAR(50),
		maas INT,
		sirket VARCHAR(20)
	);
        */




        while (veri.next()){
            System.out.println(veri.getInt("id")+ " " +veri.getString("isim")+ " "
                    +veri.getString("sehir")+ " "
            +veri.getInt("maas")+ " " +veri.getString("sirket"));
        }

        //6-Olusturulan nesneleri close() ile kapatiyoruz ki bellekten yemesin

        con.close();
        st.close();
        veri.close();




    }
}
