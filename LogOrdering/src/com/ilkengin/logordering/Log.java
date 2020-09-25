package com.ilkengin.logordering;


import java.lang.Comparable;

public class Log implements Comparable<Log> {
    String id;
    String log;
    boolean isDigit;

    Log(String _id, String _log) {
        id = _id;
        log = _log;
        isDigit = Character.isDigit(log.charAt(0));
    }
    
    @Override
    public int compareTo(Log o) {
        if (!(o instanceof Log)) {
            throw new IllegalArgumentException("Compared object is not a Log instance");
        }
        
        Log comparedLog = (Log) o;
        
        if (this.isDigit && comparedLog.isDigit) {
            return 0;
        }
        
        if (!this.isDigit && comparedLog.isDigit) {
            return -1;
        }
        
        if (this.isDigit && !comparedLog.isDigit) {
            return 1;
        }
        
        int comparedRes = this.log.compareTo(comparedLog.log);
        
        if(comparedRes == 0) {
            comparedRes = this.id.compareTo(comparedLog.id);
        }
        
        return comparedRes;
    }
}
