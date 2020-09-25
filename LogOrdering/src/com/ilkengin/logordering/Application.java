package com.ilkengin.logordering;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		LogOrderer logOrderer = new LogOrderer();
        String[] orderedLogs = logOrderer.reorderLogFiles(
            new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero" }
        );
        
        System.out.println(Arrays.asList(orderedLogs));
	}

}
