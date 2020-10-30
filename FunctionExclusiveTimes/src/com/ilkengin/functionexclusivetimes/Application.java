package com.ilkengin.functionexclusivetimes;

import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {
        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        int n = 2;
        
        FunctionExclusiveTimeCalculator calculator = new FunctionExclusiveTimeCalculator();
        System.out.println(Arrays.toString(calculator.exclusiveTime(n, logs)));
	}
}
