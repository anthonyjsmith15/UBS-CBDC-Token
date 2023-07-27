package BoEBlockchain;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.*;

public class UKTCTv3 {
    /**
     * The current inflation rate goes into previousnationalinflationrate
     */
    public static Double UKpreviousnationalinflationrate = 0.0;
    public static Double UKtwicepreviousnationalinflationrate = 0.0;
    /**
     * The factor to apply to the wallet quotas to determine the value of the tokens received
     */
    public static Double quotafactor = 50.0;

    /**
     * The national inflation rate target
     */
    public static Double UKnationalinflationtarget = 2.0;
    public static Long millis = 0L;
    public static Integer minutes = 0;
    public static Long seconds = 0L;
    public static Integer hours = 0;
    public static Integer day = 1;
    public static Integer firstday = 1;
    public static Integer month = 1;
    public static Integer year = 0;
    public static String date = "";
    public static String today = "";
    public static String yesterday = "";
    public static String tomorrow = "";
    public static Double UKinitialsupplyfactor = 0.0;
    public static Long UKTCTsupply = 0L;

    public static Long UKPrevTCTSupply = 0L;
    public static Long UKPrevTCTbuysell = 0L;
    public static Long GBDCsupply = 88855000000L;
    public static Long UKTCTbuysell = 0L;
    public static Double UKTCTGBDC = 0.0;
    public static Long UKTCTcirculatingsupply = 0L;
    public static Long UKTCTmarketcap = 0L;
    public static Double USDGBP = 0.86;
    public static Double GBPUSD = 1.16;
    public static Double averageofaveragewages = 15830.189375;
    public static Double UKTCTsupplywages = 0.0;
    public static ArrayList<Object> months = new ArrayList<>();
    public static String Month1 = "Month1";
    public static String Month2 = "Month2";
    public static String Month3 = "Month3";
    public static String Month4 = "Month4";
    public static String Month5 = "Month5";
    public static String Month6 = "Month6";
    public static String Month7 = "Month7";
    public static String Month8 = "Month8";
    public static String Month9 = "Month9";
    public static String Month10 = "Month10";
    public static String Month11 = "Month11";
    public static String Month12 = "Month12";
    public static String Month13 = "Month13";
    public static String Month14 = "Month14";
    public static String Month15 = "Month15";
    public static String Month16 = "Month16";
    public static String Month17 = "Month17";
    public static String Month18 = "Month18";
    public static String Month19 = "Month19";
    public static String Month20 = "Month20";
    public static String Month21 = "Month21";
    public static String Month22 = "Month22";
    public static String Month23 = "Month23";
    public static String Month24 = "Month24";
    public static Integer currentmonth = 1;
    public static Double quotasum = 0.0;
    public static Double UKaveragewagePPP = 0.0;
    public static Long UKpopulation = 0L;
    public static Double UKnationalinflationrate = 0.0;
    public static Long GBDCmonetarypolicy = 0L;
    public static String encryptedFactor = "";
    public static Double UKsupplyfactor = 0.0;
    public static Double walletQuota = 0.0;
    public static Double initialBalance = 0.0;
    public static Double endofMonthBalance = 0.0;
    public static Double transactionsValue = 0.0;
    public static String citizen1age = CitizenAges.Ages.Citizen1.id;
    public static String citizen2age = CitizenAges.Ages.Citizen2.id;
    public static String citizen3age = CitizenAges.Ages.Citizen3.id;
    public static String citizen4age = CitizenAges.Ages.Citizen4.id;
    public static String citizen5age = CitizenAges.Ages.Citizen5.id;
    public static String citizen6age = CitizenAges.Ages.Citizen6.id;
    public static String citizen7age = CitizenAges.Ages.Citizen7.id;
    public static String citizen8age = CitizenAges.Ages.Citizen8.id;
    public static String citizen9age = CitizenAges.Ages.Citizen9.id;
    public static String citizen10age = CitizenAges.Ages.Citizen10.id;
    public static Dictionary<String, Double> citizen1 = new Hashtable<>();
    public static Dictionary<String, Double> citizen2 = new Hashtable<>();
    public static Dictionary<String, Double> citizen3 = new Hashtable<>();
    public static Dictionary<String, Double> citizen4 = new Hashtable<>();
    public static Dictionary<String, Double> citizen5 = new Hashtable<>();
    public static Dictionary<String, Double> citizen6 = new Hashtable<>();
    public static Dictionary<String, Double> citizen7 = new Hashtable<>();
    public static Dictionary<String, Double> citizen8 = new Hashtable<>();
    public static Dictionary<String, Double> citizen9 = new Hashtable<>();
    public static Dictionary<String, Double> citizen10 = new Hashtable<>();

    private static final String url = "jdbc:postgresql://localhost/deflationtoken";
    private static final String user = "postgres";
    private static final String passwd = "postgres";
    private static final UKInflationRate inflationrate = new UKInflationRate();
    private static String SECRET_KEY = "";
    private static String SALTVALUE = "";


    public static void main() throws InterruptedException, SQLException {

        UKWageRate averagewage = new UKWageRate();
        UKaveragewagePPP = averagewage.UKwageYear1;
        UKTCTsupplywages = (UKaveragewagePPP / averageofaveragewages);
        UKPopulation pop = new UKPopulation();
        UKpopulation = pop.UKYear1;

        millis = (long) Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.MILLISECOND);
        minutes = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.MINUTE);
        seconds = (long) Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.SECOND);
        hours = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.HOUR_OF_DAY);
        //day = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.DAY_OF_MONTH);
        //month = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.MONTH) + 1;
        year = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.YEAR);
        int dayofyear = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.DAY_OF_YEAR);
        int dayofyearyesterday = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.DAY_OF_YEAR) - 1;
        int dayofyeartomorrow = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.UK).get(Calendar.DAY_OF_YEAR) + 1;
        today = "DAY_" + dayofyear;
        yesterday = "DAY_" + dayofyearyesterday;
        tomorrow = "DAY_" + dayofyeartomorrow;
        month = 1;
        date = day + ", " + month + ", " + year;
        String currenttimedate = date + " " + hours + ":" + minutes + ":" + seconds;

        if (day <= 731) {

            day = retrieveDayFromPostgres();
            if (day >= 32 && day < 60) {
                currentmonth = 2;
            }
            else if (day >= 60 && day < 91) {
                currentmonth = 3;
            }
            else if (day >= 91 && day < 121) {
                currentmonth = 4;
            }
            else if (day >= 121 && day < 152) {
                currentmonth = 5;
            }
            else if (day >= 152 && day < 182) {
                currentmonth = 6;
            }
            else if (day >= 182 && day < 213) {
                currentmonth = 7;
            }
            else if (day >= 213 && day < 244) {
                currentmonth = 8;
            }
            else if (day >= 244 && day < 274) {
                currentmonth = 9;
            }
            else if (day >= 274 && day < 305) {
                currentmonth = 10;
            }
            else if (day >= 305 && day < 335) {
                currentmonth = 11;
            }
            else if (day >= 335 && day < 365) {
                currentmonth = 12;
            }
            else if (day >= 365 && day < 397) {
                currentmonth = 13;
            }
            else if (day >= 397 && day < 425) {
                currentmonth = 14;
            }
            else if (day >= 425 && day < 456) {
                currentmonth = 15;
            }
            else if (day >= 456 && day < 486) {
                currentmonth = 16;
            }
            else if (day >= 486 && day < 517) {
                currentmonth = 17;
            }
            else if (day >= 517 && day < 547) {
                currentmonth = 18;
            }
            else if (day >= 547 && day < 578) {
                currentmonth = 19;
            }
            else if (day >= 578 && day < 608) {
                currentmonth = 20;
            }
            else if (day >= 608 && day < 639) {
                currentmonth = 21;
            }
            else if (day >= 639 && day < 669) {
                currentmonth = 22;
            }
            else if (day >= 669 && day < 700) {
                currentmonth = 23;
            }
            else if (day >= 700 && day < 731) {
                currentmonth = 24;
            }
            if (currentmonth == 1) {
                UKpreviousnationalinflationrate = 0.0;
            }
            else {
                UKpreviousnationalinflationrate = retrieveInflationRateFromPostgres();
                UKtwicepreviousnationalinflationrate = retrievePrevInflationRateFromPostgres();
            }
            GBDCsupply = retrieveCBDCSupplyFromPostgres();
            UKTCTsupply = retrieveUBSSupplyFromPostgres();
            UKPrevTCTbuysell = retrieveUKTCTPrevbuysellFromPostgres();
            System.out.println("Day: " + day);
            quotasum = fillWallets();

            if (currentmonth == 1)
                UKnationalinflationrate = inflationrate.getMonth1Inflation();
            if (currentmonth == 2)
                UKnationalinflationrate = inflationrate.getMonth2inflation();
            if (currentmonth == 3)
                UKnationalinflationrate = inflationrate.getMonth3inflation();
            if (currentmonth == 4)
                UKnationalinflationrate = inflationrate.getMonth4inflation();
            if (currentmonth == 5)
                UKnationalinflationrate = inflationrate.getMonth5inflation();
            if (currentmonth == 6)
                UKnationalinflationrate = inflationrate.getMonth6inflation();
            if (currentmonth == 7)
                UKnationalinflationrate = inflationrate.getMonth7inflation();
            if (currentmonth == 8)
                UKnationalinflationrate = inflationrate.getMonth8inflation();
            if (currentmonth == 9)
                UKnationalinflationrate = inflationrate.getMonth9inflation();
            if (currentmonth == 10)
                UKnationalinflationrate = inflationrate.getMonth10inflation();
            if (currentmonth == 11)
                UKnationalinflationrate = inflationrate.getMonth11inflation();
            if (currentmonth == 12)
                UKnationalinflationrate = inflationrate.getMonth12inflation();
            if (currentmonth == 13)
                UKnationalinflationrate = inflationrate.getMonth13Inflation();
            if (currentmonth == 14)
                UKnationalinflationrate = inflationrate.getMonth14Inflation();
            if (currentmonth == 15)
                UKnationalinflationrate = inflationrate.getMonth15Inflation();
            if (currentmonth == 16)
                UKnationalinflationrate = inflationrate.getMonth16Inflation();
            if (currentmonth == 17)
                UKnationalinflationrate = inflationrate.getMonth17Inflation();
            if (currentmonth == 18)
                UKnationalinflationrate = inflationrate.getMonth18Inflation();
            if (currentmonth == 19)
                UKnationalinflationrate = inflationrate.getMonth19Inflation();
            if (currentmonth == 20)
                UKnationalinflationrate = inflationrate.getMonth20inflation();
            if (currentmonth == 21)
                UKnationalinflationrate = inflationrate.getMonth21inflation();
            if (currentmonth == 22)
                UKnationalinflationrate = inflationrate.getMonth22inflation();
            if (currentmonth == 23)
                UKnationalinflationrate = inflationrate.getMonth23inflation();
            if (currentmonth == 24)
                UKnationalinflationrate = inflationrate.getMonth24inflation();

//            SECRET_KEY = retrieveSecretKeyFromPostgres();
//            SALTVALUE = retrieveSaltvalueFromPostgres();
            encryptedFactor = retrieveSupplyFactorFromPostgres();
            UKsupplyfactor = Double.valueOf(encryptedFactor);

            if (day == 32 || day == 60 || day == 91 || day == 121 || day == 152 || day == 182 || day == 213
                    || day == 244 || day == 274 || day == 305 || day == 335 || day == 365 || (day == 397)
                    || (day == 425) || (day == 456) || (day == 486) || (day == 517)
                    || (day == 547) || (day == 578) || (day == 608) || (day == 639) || (day == 669)
                    || (day == 700)) {

                if ((UKTCTbuysell <= 0) && (UKpreviousnationalinflationrate > UKnationalinflationtarget) && (UKpreviousnationalinflationrate >= UKtwicepreviousnationalinflationrate)) {
                    UKTCTsupply = UKTCTsupply + UKPrevTCTbuysell;
                }
                else if ((UKTCTbuysell <= 0) && (UKpreviousnationalinflationrate > UKnationalinflationtarget) && (UKpreviousnationalinflationrate < UKtwicepreviousnationalinflationrate)) {
                    UKTCTsupply = UKTCTsupply;
                }
                else if ((UKTCTbuysell <= 0) && (UKpreviousnationalinflationrate < UKnationalinflationtarget) && (UKpreviousnationalinflationrate < UKtwicepreviousnationalinflationrate)) {
                    UKTCTsupply = UKTCTsupply;
                }
                else if ((UKTCTbuysell > 0) && (UKpreviousnationalinflationrate >= 0)) {
                    UKTCTsupply = UKTCTsupply + UKPrevTCTbuysell;
                }
                else {
                    UKTCTsupply = UKTCTsupply;
                }

                if ((UKnationalinflationrate >= UKnationalinflationtarget) && (UKnationalinflationrate >= UKpreviousnationalinflationrate)) {
                    UKTCTbuysell = (long) (((UKTCTsupply) * ((((UKnationalinflationrate / UKpreviousnationalinflationrate) * 0.1) - 1) * 100) / 100) / UKsupplyfactor);
                    System.out.println(1);
                } else if ((UKnationalinflationrate >= UKnationalinflationtarget) && (UKnationalinflationrate < UKpreviousnationalinflationrate)) {
                    UKTCTbuysell = (long) Math.abs((UKTCTsupply * ((((UKnationalinflationrate / UKpreviousnationalinflationrate) * 0.1) - 1) * 100) / 100) / UKsupplyfactor);
                    System.out.println(2);
                } else if (UKnationalinflationrate == 0.0 && UKpreviousnationalinflationrate == 0.0) {
                    UKTCTbuysell = 0L;
                } else if (UKpreviousnationalinflationrate == 0 && UKnationalinflationrate > 0) {
                    if ((UKnationalinflationrate < UKnationalinflationtarget) && UKpreviousnationalinflationrate == 0)
                        UKTCTbuysell = (long) ((UKTCTsupply * ((((UKnationalinflationrate) * 0.1) - 1) * 100) / 100) / UKsupplyfactor);
                    System.out.println(3);
                } else if (UKnationalinflationrate < UKnationalinflationtarget) {
                    UKTCTbuysell = (long) Math.abs((UKTCTsupply * ((((UKnationalinflationrate / UKpreviousnationalinflationrate) * 0.1) - 1) * 100) / 100) / UKsupplyfactor);
                    System.out.println(4);
                }
                UKPrevTCTSupply = UKTCTsupply;



                if (UKTCTbuysell <= 0 && UKnationalinflationrate > UKnationalinflationtarget && UKnationalinflationrate >= UKpreviousnationalinflationrate) {
                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
                    GBDCsupply = (long) (GBDCsupply + (Math.abs(UKTCTGBDC * UKTCTbuysell))) - GBDCmonetarypolicy;
                }
                else if (UKTCTbuysell <= 0 && UKnationalinflationrate > UKnationalinflationtarget && UKnationalinflationrate < UKpreviousnationalinflationrate) {
                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
                    GBDCsupply = (long) (GBDCsupply);
                }
                else if (UKTCTbuysell > 0 && (UKnationalinflationrate > UKnationalinflationtarget) && (UKnationalinflationrate < UKpreviousnationalinflationrate)) {
                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
                    GBDCsupply = (long) (GBDCsupply + (GBDCsupply * ((UKTCTbuysell / UKTCTsupply) * (UKnationalinflationrate / 100))));
                }
                else {
                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
                    GBDCsupply = (long) (GBDCsupply);
                }
//
//                if (UKTCTbuysell > 0 && UKnationalinflationrate >= UKnationalinflationtarget && UKnationalinflationrate < UKpreviousnationalinflationrate) {
//                    GBDCsupply = (long) (GBDCsupply + (GBDCsupply * (((Double.valueOf(UKTCTbuysell / Double.valueOf(UKTCTsupply)) * (UKnationalinflationrate / 100))))));
//                    UKTCTsupply = UKTCTsupply + UKTCTbuysell;
//                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
//                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
//                } else if (UKTCTbuysell < 0 && UKnationalinflationrate >= UKnationalinflationtarget && UKnationalinflationrate >= UKpreviousnationalinflationrate) {
//                    //GBDCsupply = (long) ((GBDCsupply + (Math.abs(TCTbuysell * TCTGBDC))) - GBDCmonetarypolicy);
//                    UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
//                    GBDCmonetarypolicy = (long) (Math.abs(Double.valueOf(UKTCTbuysell) * UKTCTGBDC));
//                }

                // This then tells you how much CBDC supply (quantitative easing) or burn (quantitative tightening) is required to maintain the exchange rate with TCT, usually
                // a sale/bond purchase equivalent of around 1.5% of the total supply per day having increased the supply by that percentage.
                // If inflation is above the national target and staying flat or increasing, then CBDC supply is increased whilst monetary policy measures mitigate
                // the surplus to maintain the peg with sterling. If inflation is above the national target but decreasing in rate, TCT supply is increased
                // to devalue the tokens to encourage the trend back towards the national target.
                UKTCTcirculatingsupply = (long) (quotasum * (Double.valueOf(UKpopulation) / 10));
                UKTCTmarketcap = (long) (Double.valueOf(UKTCTcirculatingsupply) * UKTCTGBDC);

                System.out.println("Supply Factor: " + UKsupplyfactor);
                System.out.println("TCT Exchange Rate: " + UKTCTGBDC);
                System.out.println("GBDC Supply: " + GBDCsupply);
                System.out.println("TCT Supply: " + UKTCTsupply);
                System.out.println("TCT Buy Sell: " + UKTCTbuysell);
                System.out.println("Day: " + day + " Month: " + currentmonth);
                System.out.println("Monetary policy value: " + GBDCmonetarypolicy);
                System.out.println("50 year old monthly quota value: " + (((TokenQuotas.Quota.valueOf(String.valueOf(citizen9age)).id) * quotafactor) * UKTCTGBDC));
                System.out.println("18 year old monthly quota value: " + (((TokenQuotas.Quota.valueOf(String.valueOf(citizen3age)).id) * quotafactor) * UKTCTGBDC));
                insertIntoPostgres();
                if (day == 365 || day == 730) {
                    insertIntoGlobal();
                }
            }
        }
    }

    public static Double fillWallets() {
        ////////////
        //solidity scripts empty wallet then fill wallet with new quota
        ///////////
        months.add(Month1);
        months.add(Month2);
        months.add(Month3);
        months.add(Month4);
        months.add(Month5);
        months.add(Month6);
        months.add(Month7);
        months.add(Month8);
        months.add(Month9);
        months.add(Month10);
        months.add(Month11);
        months.add(Month12);
        months.add(Month13);
        months.add(Month14);
        months.add(Month15);
        months.add(Month16);
        months.add(Month17);
        months.add(Month18);
        months.add(Month19);
        months.add(Month20);
        months.add(Month21);
        months.add(Month22);
        months.add(Month23);
        months.add(Month24);

        citizen1age = CitizenAges.Ages.Citizen1.id;
        citizen2age = CitizenAges.Ages.Citizen2.id;
        citizen3age = CitizenAges.Ages.Citizen3.id;
        citizen4age = CitizenAges.Ages.Citizen4.id;
        citizen5age = CitizenAges.Ages.Citizen5.id;
        citizen6age = CitizenAges.Ages.Citizen6.id;
        citizen7age = CitizenAges.Ages.Citizen7.id;
        citizen8age = CitizenAges.Ages.Citizen8.id;
        citizen9age = CitizenAges.Ages.Citizen9.id;
        citizen10age = CitizenAges.Ages.Citizen10.id;

        citizen1.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen1age)).id);
        citizen2.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen2age)).id);
        citizen3.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen3age)).id);
        citizen4.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen4age)).id);
        citizen5.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen5age)).id);
        citizen6.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen6age)).id);
        citizen7.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen7age)).id);
        citizen8.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen8age)).id);
        citizen9.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen9age)).id);
        citizen10.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen10age)).id);
        Double quotasum = 0.0;
        citizen1.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen1age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen1age)).id);
        citizen2.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen2age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen2age)).id);
        citizen3.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen3age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen3age)).id);
        citizen4.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen4age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen4age)).id);
        citizen5.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen5age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen5age)).id);
        citizen6.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen6age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen6age)).id);
        citizen7.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen7age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen7age)).id);
        citizen8.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen8age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen8age)).id);
        citizen9.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen9age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen9age)).id);
        citizen10.put("walletQuota", TokenQuotas.Quota.valueOf(String.valueOf(citizen10age)).id);
        quotasum = quotasum + Double.valueOf(TokenQuotas.Quota.valueOf(String.valueOf(citizen10age)).id);
        return quotasum;
    }

    public static Connection connectpostgres() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void insertIntoPostgres() throws SQLException {

        String SQL = "INSERT INTO boe (date, averagewage, population, inflationrate, TCTSupply, CBDCsupply," +
                " TCTbuysell, TCTGBDC, TCTcircsupply, TCTMarketcap, CBDCmonetarypolicy) " +
                "VALUES (now(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        {
            pstmt.setDouble(1, UKaveragewagePPP);
            pstmt.setLong(2, UKpopulation);
            pstmt.setDouble(3, UKnationalinflationrate);
            pstmt.setLong(4, Long.valueOf((long) UKTCTsupply));
            pstmt.setLong(5, GBDCsupply);
            pstmt.setLong(6, UKTCTbuysell);
            pstmt.setDouble(7, UKTCTGBDC);
            pstmt.setLong(8, UKTCTcirculatingsupply);
            pstmt.setLong(9, UKTCTmarketcap);
            pstmt.setLong(10, GBDCmonetarypolicy);
            pstmt.executeUpdate();
            conn.close();
        }
    }

    public static void insertIntoGlobal() throws SQLException {

        String SQL = "INSERT INTO global (date, country, averagewageUSD, wagereltofiat, population, averagetcttoaveragewage, " +
                "averageTCTusdppp, TCTSupply, CBDCsupply, tctcbdc, TCTMarketcap) " +
                "VALUES (now(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        {
            pstmt.setString(1, "United Kingdom");
            pstmt.setDouble(2, UKaveragewagePPP);
            pstmt.setDouble(3, UKaveragewagePPP / averageofaveragewages);
            pstmt.setDouble(4, UKpopulation);
            pstmt.setDouble(5, ((quotasum * quotafactor) * GBPUSD) / averageofaveragewages);
            pstmt.setDouble(6, ((quotasum * quotafactor) * GBPUSD));
            pstmt.setLong(7, UKTCTsupply);
            pstmt.setLong(8, GBDCsupply);
            pstmt.setDouble(9, UKTCTGBDC);
            pstmt.setLong(10, UKTCTmarketcap);
            pstmt.executeUpdate();
            conn.close();
        }
    }

    public static String decrypt(String strToDecrypt) {
        try {
            /* Declare a byte array. */
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            /* Create factory for secret keys. */
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            /* PBEKeySpec class implements KeySpec interface. */
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            /* Retruns decrypted value. */
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException |
                 InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error occured during decryption: " + e.toString());
        }
        return null;
    }

    public static String retrieveSecretKeyFromPostgres() throws SQLException {

        String SQLsecret = "SELECT secretkey from secret order by id desc";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsecret);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SECRET_KEY = rs.getString(1);
                conn.close();
                return SECRET_KEY;

            }
        }
        return null;
    }

    public static String retrieveSaltvalueFromPostgres() throws SQLException {

        String SQLsecret = "SELECT secretphrase from secret order by id desc";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsecret);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SALTVALUE = rs.getString(1);
                conn.close();
                return SALTVALUE;

            }
        }
        return null;
    }

    public static Double retrieveInflationRateFromPostgres() throws SQLException {

        String SQLinflationrate = "SELECT inflationrate from boe order by id desc LIMIT 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLinflationrate);
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UKpreviousnationalinflationrate = Double.valueOf(rs.getString(1));
                conn.close();
                return UKpreviousnationalinflationrate;
            }
            return UKpreviousnationalinflationrate;
        }
    }

    public static Double retrievePrevInflationRateFromPostgres() throws SQLException {

        String SQLinflationrate = "SELECT inflationrate from boe order by id desc LIMIT 1 OFFSET 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLinflationrate);
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UKtwicepreviousnationalinflationrate = Double.valueOf(rs.getString(1));
                conn.close();
                return UKtwicepreviousnationalinflationrate;
            }
            return UKtwicepreviousnationalinflationrate;
        }
    }

    public static Long retrieveUKTCTPrevbuysellFromPostgres() throws SQLException {

        String SQLinflationrate = "SELECT tctbuysell from boe order by id desc LIMIT 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLinflationrate);
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UKPrevTCTbuysell = Long.valueOf(rs.getString(1));
                conn.close();
                return UKPrevTCTbuysell;
            }
            return UKPrevTCTbuysell;
        }
    }
    public static String retrieveSupplyFactorFromPostgres() throws SQLException {

        String SQLsecret = "SELECT supplyfactor from supplyfactor order by id desc LIMIT 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsecret);
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                encryptedFactor = rs.getString(1);
                conn.close();
                return encryptedFactor;
            }
            return encryptedFactor;
        }
    }

    public static Long retrieveCBDCSupplyFromPostgres() throws SQLException {

        String SQLsupply = "SELECT cbdcsupply from boe order by id desc LIMIT 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsupply);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                GBDCsupply = Long.valueOf(rs.getString(1));
                conn.close();
                return GBDCsupply;


            }
            return GBDCsupply;
        }

    }

    public static Long retrieveUBSSupplyFromPostgres() throws SQLException {

        String SQLUBSsupply = "SELECT tctsupply from boe order by id desc LIMIT 1";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLUBSsupply);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UKTCTsupply = Long.valueOf(rs.getString(1));
                conn.close();
                return UKTCTsupply;


            }
            return UKTCTsupply;
        }

    }

    public static Integer retrieveDayFromPostgres() throws SQLException {

        String SQLsecret = "SELECT day from day order by id desc";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsecret);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                day = rs.getInt(1);
                conn.close();
                return day;


            }
        }
        return null;
    }
}









