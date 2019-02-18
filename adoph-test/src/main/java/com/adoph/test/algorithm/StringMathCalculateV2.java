package com.adoph.test.algorithm;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

/**
 * 利用栈实现计算字符串数学表达式
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/2/18
 */
public class StringMathCalculateV2 {

    public static void main(String[] args) throws ScriptException {
        String content = "1+12/(2+5*2+100)*7";
        System.out.println("利用栈实现：" + eval(content));
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        System.out.println("JS引擎：" + engine.eval(content).toString());
    }

    public static double eval(String content) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vars = new Stack<>();
        String[] arr = convert(content);
        for (String item : arr) {
            if (item.equals("")) {
                continue;
            }
            switch (item) {
                case "+":
                case "-":
                    //非括号执行出栈计算
                    while (!ops.isEmpty() && (!(ops.peek().equals("(") || ops.peek().equals(")")))) {
                        process(ops, vars);
                    }
                    ops.push(item);
                    break;
                case "*":
                case "/":
                    //非乘除执行出栈计算
                    while (!ops.isEmpty() && (ops.peek().equals("*") || ops.peek().equals("/"))) {
                        process(ops, vars);
                    }
                    ops.push(item);
                    break;
                case "(":
                    //左括号不做操作，直接操作符入栈
                    ops.push(item);
                    break;
                case ")":
                    //非左括号，进行出栈计算至左括号，最后清除左括号
                    while (!ops.peek().equals("(")) {
                        process(ops, vars);
                    }
                    ops.pop();
                    break;
                default:
                    //参数入栈
                    vars.push(Double.valueOf(item));
                    break;
            }
        }
        //出栈计算所有栈内数据
        while (!ops.isEmpty()) {
            process(ops, vars);
        }
        return vars.pop();
    }

    /**
     * 出栈执行操作符
     *
     * @param ops  操作符栈
     * @param vars 参数栈
     */
    private static void process(Stack<String> ops, Stack<Double> vars) {
        String op = ops.pop();
        Double v1 = vars.pop();
        Double v2 = vars.pop();
        switch (op) {
            case "+":
                vars.push(v1 + v2);
                break;
            case "-":
                vars.push(v2 - v1);
                break;
            case "*":
                vars.push(v1 * v2);
                break;
            case "/":
                vars.push(v2 / v1);
                break;
        }
    }

    /**
     * 转换为数组，注意大于10位的数字转换
     *
     * @param content 待转换字符串
     * @return 数组
     */
    private static String[] convert(String content) {
        return content.replaceAll("\\+", "\\$\\+\\$")
                .replaceAll("-", "\\$-\\$")
                .replaceAll("\\*", "\\$\\*\\$")
                .replaceAll("/", "\\$/\\$")
                .replaceAll("\\(", "\\$\\(\\$")
                .replaceAll("\\)", "\\$\\)\\$")
                .split("\\$");
    }
}
