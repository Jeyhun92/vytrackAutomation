package com.vytrack.utilities.ExtraUtils;

public class Sleep {
    
    public static void Zzz(int snooze){

        try {
            Thread.sleep(snooze*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
}
