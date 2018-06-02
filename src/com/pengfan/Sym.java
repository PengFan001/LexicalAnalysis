package com.pengfan;

//Const——用来声明常量；
//Var——用来声明变量；
//Procedure——用来声明过程；
//Begin——声明过程的开始；
//End——声明过程的结束；
//Ood——单目运算符，声明为关键字；
//If——条件语句；
//Then——条件语句；
//Call——声明调用函数；
//While——循环语句；
//Read——读文件语句；
//Write——写文件语句；
//endOpts :     ;  :  #  (  ) { }
//singleOpts:  +, -, *, /, =, >, <
//doubleOpts:  :=, <=, >=, <>
//ID   用户自己定义的字符变量
//NUM  用户自己定义的数字常量


public class Sym {

    /**
     * 定义关键字，分界符， 单目运算符， 双目运算符， 用户自定义变量和数据的种类和序列值
     * 对传入的已被截取的字符串进行识别，知道是哪一种情况
     * @param string 要被识别的字符串
     * @return 返回字符串种类 和 序列值
     */
    public SortType charSortType(String string){

        SortType type = new SortType();
        String sortType = null;
        int sortNum = 0;
        switch(string){

            case "const":
                sortType = "常量声明";
                sortNum = 0;
                break;
            case "var":
                sortType = "变量声明";
                sortNum = 1;
                break;
            case "procedure":
                sortType = "过程声明";
                sortNum = 2;
                break;
            case "begin":
                sortType = "过程开始";
                sortNum = 3;
                break;
            case "end":
                sortType = "过程结束";
                sortNum = 4;
                break;
            case "ood":
                sortType = "将单目运算符声明为关键字";
                sortNum = 5;
                break;
            case "if":
                sortType = "条件语句";
                sortNum = 6;
                break;
            case "then":
                sortType = "条件语句";
                sortNum = 7;
                break;
            case "while":
                sortType = "循环语句";
                sortNum = 8;
                break;
            case "call":
                sortType = "函数调用";
                sortNum = 9;
                break;
            case "read":
                sortType = "文件读取";
                sortNum = 10;
                break;
            case "write":
                sortType = "文件写入";
                sortNum = 11;
                break;
            case ";":
                sortType = "分号";
                sortNum = 12;
                break;
            case ":":
                sortType = "冒号";
                sortNum = 13;
                break;
            case "#":
                sortType = "井号";
                sortNum = 14;
                break;
            case "(":
                sortType = "左括号";
                sortNum = 15;
                break;
            case ")":
                sortType = "右括号";
                sortNum = 16;
                break;
            case "+":
                sortType = "加号";
                sortNum = 17;
                break;
            case "-":
                sortType = "减号";
                sortNum = 18;
                break;
            case "*":
                sortType = "乘号";
                sortNum = 19;
                break;
            case "/":
                sortType = "除号";
                sortNum = 20;
                break;
            case ">":
                sortType = "大于号";
                sortNum = 21;
                break;
            case "<":
                sortType = "小于号";
                sortNum = 22;
                break;
            case "=":
                sortType = "等号";
                sortNum = 23;
                break;
            case "{":
                sortType = "左大括号";
                sortNum = 24;
                break;
            case "}":
                sortType = "右大括号";
                sortNum = 25;
                break;
            case ":=":
                sortType = "赋值";
                sortNum = 26;
                break;
            case ">=":
                sortType = "大于等于";
                sortNum = 27;
                break;
            case "<=":
                sortType = "小于等于";
                sortNum = 28;
                break;
            case "<>":
                sortType = "不等于";
                sortNum = 29;
                break;
            case "ID":
                sortType = "自定义变量";
                sortNum = 30;
                break;
            case "NUM":
                sortType = "自定义数据";
                sortNum = 31;
                break;
        }

        type.setSortType(sortType);
        type.setSortNum(sortNum);

        return type;
    }

}
