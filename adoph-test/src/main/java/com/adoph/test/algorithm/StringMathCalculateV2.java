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
                    while (!ops.isEmpty() && (!(ops.peek().equals("(") || ops.peek().equals(")")))) {
                        process(ops, vars);
                    }
                    ops.push(item);
                    break;
                case "*":
                case "/":
                    while (!ops.isEmpty() && (ops.peek().equals("*") || ops.peek().equals("/"))) {
                        process(ops, vars);
                    }
                    ops.push(item);
                    break;
                case "(":
                    ops.push(item);
                    break;
                case ")":
                    while (!ops.peek().equals("(")) {
                        process(ops, vars);
                    }
                    ops.pop();
                    break;
                default:
                    vars.push(Double.valueOf(item));
                    break;
            }
        }
        while (!ops.isEmpty()) {
            process(ops, vars);
        }
        return vars.pop();
    }

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

    public static String[] convert(String content) {
        return content.replaceAll("\\+", "\\$\\+\\$")
                .replaceAll("-", "\\$-\\$")
                .replaceAll("\\*", "\\$\\*\\$")
                .replaceAll("/", "\\$/\\$")
                .replaceAll("\\(", "\\$\\(\\$")
                .replaceAll("\\)", "\\$\\)\\$")
                .split("\\$");
    }
}
