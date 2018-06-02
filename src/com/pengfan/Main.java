package com.pengfan;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Analysis analysis = new Analysis();
        Pretreatment pretreatment = new Pretreatment();
        Scanner input = new Scanner(System.in);
        System.out.println("input the code:");
        String string = input.nextLine();
        String[] strings = pretreatment.divideString(string);
        List<Map> list;
        list = analysis.lexicalAnalysis(strings);
        for(Map map : list){
            String sortNum = (String) map.get("sortNum");
            String sortType = (String) map.get("sortType");
            String keyword = (String) map.get("keyword");
            System.out.println("("+sortNum+","+sortType+","+keyword+")");
        }
    }

}
