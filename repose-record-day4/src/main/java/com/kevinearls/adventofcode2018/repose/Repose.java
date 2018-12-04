package com.kevinearls.adventofcode2018.repose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repose {
    private Map<String, Guard> guards = new HashMap<>();

    public void loadGuards(List<String> input) {
        int index = 0;
        String line = input.get(index++);
        while (index < input.size()) {
            String message = line.substring(19).trim();
            message = message.replace("#", "");
            String[] parts = message.split("\\s+");
            String guardId = parts[1];
            Guard guard;
            if (guards.containsKey(guardId)) {
                guard = guards.get(guardId);
            } else {
                guard = new Guard(guardId);
                guards.put(guardId, guard);
            }

            // TODO create Guard if needed and set local variables
            line = input.get(index++);
            while (line.contains("falls asleep")) {
                String date = line.substring(1, 11);
                Integer startMinute = Integer.valueOf(line.substring(15, 17));
                line = input.get(index++);
                Integer endMinute = Integer.valueOf(line.substring(15, 17));

                guard.record(date, startMinute, endMinute);

                if (index < input.size()) {
                    line = input.get(index++);
                }
            }
        }
    }

    public int strategyOne() {
        Guard sleepiestGuard = new Guard("");
        Integer maxSleep = Integer.MIN_VALUE;
        for (String guardId : guards.keySet()) {
            Guard guard = guards.get(guardId);
            Integer totalSleep = guard.getTotalSleepMinutes();
            if (totalSleep > maxSleep) {
                maxSleep = totalSleep;
                sleepiestGuard = guard;
            }
        }

        int minute = sleepiestGuard.getMostSleptMinute();
        int result = minute * Integer.valueOf(sleepiestGuard.getId());
        return result;
    }
}

