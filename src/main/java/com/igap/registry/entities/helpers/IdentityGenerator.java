package com.igap.registry.entities.helpers;

import java.security.SecureRandom;
import java.time.LocalDateTime;

/**
 * class IdentityGenerator
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class IdentityGenerator {
    static SecureRandom random = new SecureRandom();

    private IdentityGenerator() {}

    public static String getIdentityNumber(int strLength, int numLength) {

        StringBuilder builder = new StringBuilder();

        String randString = getRandomString(strLength, true);
        builder.append(randString);
        long randInt = getRandInt(numLength);
        builder.append(randInt);

        return builder.toString();
    }

    public static String getIdentityNumber(int str1Length, int numLength, int str2Length) {

        StringBuilder builder = new StringBuilder();

        String randString = getRandomString(str1Length, true);
        builder.append(randString);

        long randInt = getRandInt(numLength);
        builder.append(randInt);

        String randString2 = getRandomString(str2Length, true);
        builder.append(randString2);

        return builder.toString();
    }

    public static String getAccountNumber() {
        LocalDateTime date = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();

        String year = String.valueOf(date.getYear()).substring(3,4);
        sb.append(year);

        String day = String.valueOf(date.getDayOfYear());
        sb.append(day);

        long randInt = 0;

        if(day.length() == 1)
            randInt = getRandInt(7);
        else if (day.length() == 2) {
            randInt = getRandInt(6);
        }
        else {
            randInt = getRandInt(5);
        }

        sb.append(randInt);

        return sb.toString();
    }

    public static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        return getStringBuilder(n, alphaNumericString);
    }

    public static String getRandomString(int size, boolean isUpper) {

        String alphaNumericString = "";

        if (isUpper) {
            alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        else {
            alphaNumericString = "abcdefghijklmnopqrstuvxyz";
        }

        return getStringBuilder(size, alphaNumericString);
    }

    public static String getRandomNumeric(int size) {

        // choose a Character random from this String
        String numericString = "9876543210"
                + "0123456789"
                + "5432109876";

        return getStringBuilder(size, numericString);
    }

    public static long getRandInt(int size) {

        return switch (size) {
            case 1 -> random.nextInt(1, 9);
            case 2 -> random.nextInt(10, 99);
            case 3 -> random.nextInt(100, 999);
            case 4 -> random.nextInt(1000, 9999);
            case 5 -> random.nextInt(10000, 99999);
            case 6 -> random.nextInt(100000, 999999);
            case 7 -> random.nextInt(1000000, 9999999);
            case 8 -> random.nextInt(10000000, 99999999);
            case 9 -> random.nextInt(100000000, 999999999);
            default -> Long.parseLong(getRandomNumeric(size));
        };
    }

    private static String getStringBuilder(int size, String alphaNumericString) {

        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            // generate a random number between 0 to alphaNumericString variable length
            int index = random.nextInt(alphaNumericString.length());

            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String getYearPlusNumberAccount(int numLength) {
        LocalDateTime date = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();

        String year = String.valueOf(date.getYear()).substring(2,4);
        sb.append(year);

        long randInt = getRandInt(numLength);

        sb.append(randInt);

        return sb.toString();
    }


}


