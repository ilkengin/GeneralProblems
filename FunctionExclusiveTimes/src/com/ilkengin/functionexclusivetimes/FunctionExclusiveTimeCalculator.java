package com.ilkengin.functionexclusivetimes;

import java.util.List;
import java.util.Stack;

public class FunctionExclusiveTimeCalculator {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] times = new int[n];
        Stack<Integer> callStack = new Stack<>();
        int latestTimestamp = -1;
        LogType latestLogType = LogType.Start;
        
        for(String logStr: logs) {
            Log log = Log.parse(logStr);
            if (log.type == LogType.Start) {
                if (!callStack.empty()) {
                    times[callStack.peek()] += log.timestamp - latestTimestamp;  
                    if (latestLogType == LogType.End) {
                        times[callStack.peek()] -= 1;
                    }
                }
                
                callStack.push(log.id);
            } else if (log.type == LogType.End) {
                callStack.pop();
                times[log.id] += log.timestamp - latestTimestamp;
                if (latestLogType == LogType.Start) {
                    times[log.id] += 1;
                }
            }
            
            latestTimestamp = log.timestamp;
            latestLogType = log.type;
        }
        
        return times;
    }
}
