package view;

import controller.Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        phoneNumber = scanner.nextLine();
        String regex = "\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(matcher.find()){
            System.out.println("oke");
        }
        else{
            System.out.println("fails");
        }

    }
}
