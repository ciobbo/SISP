package com.SISP.server.flutter.SISP.costants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public Date generateCurrentDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return date;
    }
}
