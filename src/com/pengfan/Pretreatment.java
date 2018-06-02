package com.pengfan;

public class Pretreatment {

    /**
     * according to the blank space to split the string and generate many substring;
     * @param string the string was inputted
     * @return  an array which sort the substring
     */
    public String[] divideString(String string){
        String[] list;
        list = string.split("\\s");

        return list;
    }

}
