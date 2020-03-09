package com.coretheorylife.common.utils;

public class TicketdashiUUID {

    public static String generateOID() {

        return new ObjectId().toString();
    }
}
