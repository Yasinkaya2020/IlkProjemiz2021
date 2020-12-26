package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D15_FilePath extends TestBase {



    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir"));
        //icinde oldugumuz klasorun yolunu(path) verir
        String anaPath=System.getProperty("user.home");
        //Hangi bilgisayrda isek o bilgisayarin ana path ini verir
        //C:\User\sila0\Desktop

        String  masaustuPath=anaPath+"\\Destkop";
        System.out.println("Destkop yolu: "+masaustuPath);
    }
    @Test
    public void isExist(){
        //C:\Users\sila0\Desktop\FLOWER.jpg
        //1.adim b sayarimizin home path ini buluyoruz

        String homePath=System.getProperty("user.home");

        //2.adim home Path in devamina dosya yolunu olusturacak sekile ek yapiyoruz
        //ONEMLI: dosya adindan sonra uzantiinin da yazilmasi gerekir
        String filePath=homePath+"\\Desktop\\FLOWER.jpg";

        //System.out.println(filePath);

        //masaustunede FLOWER.jpg dosyasinin var oldugunu test edin
        //3.adim dosyanin var oldugunu Files.exist ile test edebiliriz.
        boolean dosyaVarmi=Files.exists(Paths.get(filePath));

        System.out.println(dosyaVarmi);





    }
}
