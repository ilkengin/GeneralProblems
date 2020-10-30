package com.ilkengin.functionexclusivetimes;

public class Log {
    int id;
    LogType type;
    int timestamp;
    
    public Log(int id, LogType type, int t) {
        this.id = id;
        this.type = type;
        this.timestamp = t;
    }
    
    public static Log parse(String log) {
        String[] splittedLog = log.split(":");
        
        // TODO: Do error check
        
        int id = Integer.parseInt(splittedLog[0]);
        LogType type = splittedLog[1].equals("start") ? LogType.Start : LogType.End;
        int timestamp = Integer.parseInt(splittedLog[2]);
        
        return new Log(id, type, timestamp);
    }
}