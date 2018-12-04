package com.kevinearls.adventofcode2018.repose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guard {
    private String id;
    private Map<String, List<String>> sleepRecord = new HashMap<>();

    public Guard(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public int getTotalSleepMinutes() {
        int minutesSlept = 0;
        for (String date : sleepRecord.keySet()) {
            List<String> minutes = sleepRecord.get(date);
            for (String minute: minutes) {
                if (minute.equals("#")) {
                    minutesSlept++;
                }
            }
        }

        return minutesSlept;
    }

    /** During which minute was this guard most frequently asleep
     *
     * @return
     */
    public int getMostSleptMinute() {
        int[] blah = new int[60];
        for (String date : sleepRecord.keySet()) {
            List<String> minutes = sleepRecord.get(date);
            for (int i = 0; i < 60; i++) {
                if (minutes.get(i).equals("#")) {
                    blah[i]++;
                }
            }
        }

        int highest = 0;
        for (int i=1; i < 60; i++) {
            if (blah[i] > blah[highest]) {
                highest = i;
            }
        }

        return highest;
    }

    /**
     * Added for part 2.  How many times was this guard asleep during the minute where he slept the most
     * @return
     */
    public int getMostSleptMinuteValue() {
        int[] blah = new int[60];
        for (String date : sleepRecord.keySet()) {
            List<String> minutes = sleepRecord.get(date);
            for (int i = 0; i < 60; i++) {
                if (minutes.get(i).equals("#")) {
                    blah[i]++;
                }
            }
        }

        int highest = 0;
        for (int i=1; i < 60; i++) {
            if (blah[i] > blah[highest]) {
                highest = i;
            }
        }

        return blah[highest];
    }


    // guard.record(date, startMinute, endMinute);
    public void record(String date, Integer startMinute, Integer endMinute) {
        List<String> minutes;
        if (sleepRecord.containsKey(date)) {
            minutes = sleepRecord.get(date);
        } else {
            minutes = new ArrayList<>(60);
            for (int i=0; i <60; i++) {
                minutes.add(".");
            }
        }

        for (int i=startMinute; i < endMinute; i++) {
            minutes.set(i, "#");
        }
        sleepRecord.put(date, minutes);
    }
}
