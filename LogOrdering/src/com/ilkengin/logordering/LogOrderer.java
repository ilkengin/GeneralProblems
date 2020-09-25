package com.ilkengin.logordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogOrderer {

    public String[] reorderLogFiles(String[] logs) {
        List<Log> logList = new ArrayList<>();
        
        for(String log: logs) {
            String[] splittedLog = log.split(" ", 2);
            logList.add(new Log(splittedLog[0], splittedLog[1]));     
        }
        
        Collections.sort(logList);        
        
        return logList.stream().map(log -> log.id + " " + log.log).toArray(String[]::new);
    }
	
}
