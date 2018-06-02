package com.pengfan;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Analysis analysis = new Analysis();
        Pretreatment pretreatment = new Pretreatment();
//        Scanner input = new Scanner(System.in);
//        System.out.println("input the code:");
//        String string = input.nextLine();
        String[] strings = pretreatment.divideString(pretreatment.readCode());
        if(strings != null) {
            List<Map> list;
            list = analysis.lexicalAnalysis(strings);
            System.out.println("\nlexicalAnalysis result:");
            for (Map map : list) {
                String sortNum = (String) map.get("sortNum");
                String sortType = (String) map.get("sortType");
                String keyword = (String) map.get("keyword");
                System.out.println("(" + sortNum + "," + sortType + "," + keyword + ")");
            }
        }
        else
            System.out.println("未输入源代码");
    }

}
