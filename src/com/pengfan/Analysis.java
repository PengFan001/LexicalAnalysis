package com.pengfan;

//System keyword : const end while if then var procedure begin ood  call read write
//endOpts :     ;  :  #  (  ) { }
//singleOpts:  +, -, *, /, =, >, <
//doubleOpts:  :=, <=, >=, <>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis {

    private Sym sym = new Sym();

    /**
     * judge the type of the every string which is sorted in the list,
     * and then sort the type and the sortNumber of  the every string into the mapList
     * @param list 存储了整个代码被分割出来的所有字符串的数组
     * @return  字符串对应的类型和序列值    即mapList
     */
    public List<Map> lexicalAnalysis(String[] list){

        char firstChar;//用于存储第一个首字符
        String sortNum = null;//字符串存储的序列值
        String keyword = null;//关键字
        String sortType = null;//字符串的类型
        String firstCharType = null;//第一个字符的类型。是字母、数字、运算符
        String word;//用于存放list中每个字符串

        List<Map> mapList = new ArrayList<Map>();//存储 字符串对应的类型和序列值

        //对每个字符串逐个进行判断
        for(int i=0;i<list.length;i++){
            Map<String, String> map = new HashMap<>();
            word = list[i];
            if(word=="" || word==null || word.trim()==null)
                continue;
            firstChar = word.charAt(0);
            firstCharType = getCharType(firstChar);

            //第一个字符是字母的情况
            if(firstCharType.equals("char")){

                //首先判断是不是关键字
                if(firstChar=='c' || firstChar=='v' || firstChar=='b' || firstChar=='p' || firstChar=='e' || firstChar=='o'
                        || firstChar=='i' || firstChar=='t' || firstChar=='w' ||firstChar=='r')
                {
                    Map<String, String> map1 = getKeyword(word);
                    if (map1!=null){
                        sortNum = map1.get("sortNum");
                        sortType = map1.get("sortType");
                        keyword = map1.get("keyword");
                    }
                    else {
                        if(isLegalID(word)){
                            sortNum = sym.charSortType("ID").getSortNum()+"";
                            sortType = sym.charSortType("ID").getSortType();
                            keyword = word;
                        }
                        else
                            System.out.println("这个"+word+"是一个不合法的自定义字符，所在位置：第"+(i+1)+"个单词");
                    }
                }
                else {
                    if(isLegalID(word)){
                        sortNum = sym.charSortType("ID").getSortNum()+"";
                        sortType = sym.charSortType("ID").getSortType();
                        keyword = word;
                    }
                    else
                        System.out.println("这个"+word+"是一个不合法的自定义字符，所在位置：第"+(i+1)+"个单词");
                }
            }

            //第一个字符数字的情况
            if(firstCharType.equals("digit")){
                if(isLegalNumber(word)){
                    sortNum = sym.charSortType("NUM").getSortNum()+"";
                    sortType = sym.charSortType("NUM").getSortType();
                    keyword = word;
                }
                else
                    System.out.println("这个"+word+"是一个不合法的数字，所在位置：第"+(i+1)+"个单词");
            }

            //第一个字符是运算符时
            if(firstCharType.equals("opts")){
                //首先判断是单目运算符还是算木运算符
                int length = word.length();

                //是单目运算符的情况
                if(length==1){

                    //是算数运算符时
                    if(isSingleOpts(word)){
                        sortNum = sym.charSortType(word).getSortNum()+"";
                        sortType = sym.charSortType(word).getSortType();
                        keyword = word;
                    }

                    //是分界符时
                    else if(isEndOpts(word)){
                        sortNum = sym.charSortType(word).getSortNum()+"";
                        sortType = sym.charSortType(word).getSortType();
                        keyword = word;
                    }
                    else
                        System.out.println("这个"+word+"是一个不合法的字符，所在位置：第"+(i+1)+"个单词");
                }

                //是双目运算符时
                else if(length==2){
                    if(isDoubleOpts(word)){
                        sortNum = sym.charSortType(word).getSortNum()+"";
                        sortType = sym.charSortType(word).getSortType();
                        keyword = word;
                    }
                    else
                        System.out.println("这个"+word+"是一个不合法的字符，所在位置：第"+(i+1)+"个单词");
                }
                else
                    System.out.println("这个"+word+"是一个不合法的字符，所在位置：第"+(i+1)+"个单词");
            }

            if(sortNum == null || keyword == null || sortType == null)
                continue;
            else {
                map.put("sortNum", sortNum);
                map.put("sortType", sortType);
                map.put("keyword", keyword);
                mapList.add(map);
                sortNum = null;
                sortType = null;
                keyword = null;
            }

        }
        return mapList;
    }


    /**
     * judge the type of the char
     * 判定字符是字母、数字、运算符
     * @param c 待判定的字符
     * @return  字符的类型
     */
    private String getCharType(char c){

        String type;
        if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))
            type = "char";
        else if('0' <= c && c <= '9')
            type = "digit";
        else
            type = "opts";

        return type;
    }

    /**
     * Confirming the word is what kind of keyword
     * @param word the string was inputted
     * @return  the keyword's type of word
     */
    private Map<String, String> getKeyword(String word) {

        Map<String, String> map = new HashMap<>();
        char firstChar = word.charAt(0);
        switch (firstChar){

            case 'c':
                if(word.equals("const")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                else if(word.equals("call")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'p':
                if(word.equals("procedure")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'e':
                if(word.equals("end")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'v':
                if(word.equals("var")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'i':
                if(word.equals("if")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 't':
                if(word.equals("then")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'o':
                if(word.equals("odd")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'b':
                if(word.equals("begin")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case 'r':
                if(word.equals("read")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;

            case  'w':
                if(word.equals("while")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                else if(word.equals("write")){
                    SortType sortType = sym.charSortType(word);
                    map.put("sortNum", sortType.getSortNum()+"");
                    map.put("sortType", sortType.getSortType());
                    map.put("keyword", word);
                }
                break;
        }

        return map;

    }

    /**
     * judge the word weather a legally ID
     * @param word  the string is inputted
     * @return  default return true, then return false
     */
    private boolean isLegalID(String word) {
        boolean flag = true;
        char firstChar = word.charAt(0);
        char c;
        if(getCharType(firstChar).equals("char")){
            for(int i=0;i<word.length();i++){
                c = word.charAt(i);
                if(getCharType(c).equals("char") || getCharType(c).equals("digit"))
                    continue;
                else
                    flag = false;
            }
        }
        else
            flag = false;

        return flag;
    }

    /**
     * judge the word weather a legally Number
     * @param word  the string is inputted
     * @return  default return true, then return false
     */
    private boolean isLegalNumber(String word) {
        boolean flag = true;
        char firstChar = word.charAt(0);
        char c;
        if(getCharType(firstChar).equals("digit")){
            for(int i=0;i<word.length();i++){
                c = word.charAt(i);
                if(getCharType(c).equals("digit"))
                    continue;
                else
                    flag = false;
            }
        }
        else
            flag = false;

        return flag;
    }

    /**
     * judge the word weather a singleOpts
     * @param word  the string is inputted
     * @return  default return false, then return true
     */
    private boolean isSingleOpts(String word) {
        boolean flag = false;
        String[] singleOpts = {"+", "-", "*", "/", "=", ">", "<"};
        for(int i=0;i<singleOpts.length;i++)
            if(word.equals(singleOpts[i]))
                flag = true;
        return flag;
    }

    /**
     * udge the word weather a endOpts
     * @param word  the string is inputted
     * @return  default return false, then return true
     */
    private boolean isEndOpts(String word) {
        boolean flag = false;
        String[] endOpts = {";", "#", "(", ")", ":", "{", "}"};
        for(int i=0;i<endOpts.length;i++)
            if(word.equals(endOpts[i]))
                flag = true;
        return flag;
    }

    /**
     * judge the word weather a doubleOpts
     * @param word  the string is inputted
     * @return  default return false, then return true
     */
    private boolean isDoubleOpts(String word) {
        boolean flag = false;
        String[] doubleOpts = {"<=", ">=", ":=", "<>"};
        for(int i=0;i<doubleOpts.length;i++)
            if(word.equals(doubleOpts[i]))
                flag = true;
        return flag;
    }


}
