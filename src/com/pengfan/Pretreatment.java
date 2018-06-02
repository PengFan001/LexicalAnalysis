package com.pengfan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pretreatment {

    /**
     * according to the blank space to split the string and generate many substring;
     * @param string the string was inputted
     * @return  an array which sort the substring
     */
    public String[] divideString(String string){
        String[] list;
        if(string != null)
            list = string.split("\\s");
        else
            list = null;

        return list;
    }

    /**
     * read the source_code from the file which name is code.txt, and generate the string list
     * @return  a string list
     * @throws IOException
     */
    public String readCode() throws IOException {
        List<String> list = new ArrayList<>();
        String code = null;
        FileReader reader = new FileReader("D:/Project/IDEA Project/LexicalAnalysis/src/code.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String strLine = bufferedReader.readLine();
        System.out.println("\nthe source code:");
        while (strLine != null){
            System.out.println(strLine);
            list.add(strLine);
            list.add(" ");
            strLine = bufferedReader.readLine();
        }

        bufferedReader.close();
        reader.close();

        for(int i=0;i<list.size();i++)
            code = code + list.get(i);

        return code;
    }

}
