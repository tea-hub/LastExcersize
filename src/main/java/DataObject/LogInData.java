package DataObject;

import com.github.javafaker.Faker;

public class LogInData {
    static  Faker faker1=new Faker();
    public  static String
            correctEmail="rostiashvilim72@gmail.com",
            correctPassword="tester1",
           incorrectEmail= faker1.bothify("???@gmail.com"),
           incorrectPassword=faker1.bothify("?????##"),
           invalidFormatEmail= "rostiashvilim72gmail.com";



}

