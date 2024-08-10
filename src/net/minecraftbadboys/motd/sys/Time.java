package net.minecraftbadboys.motd.sys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    //TODO Special Secondary MOTD
    static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
    static Date currentSystemUTC = new Date(System.currentTimeMillis());

    public static String getMonAndDay() {
        return formatter.format(currentSystemUTC);
    }
}
