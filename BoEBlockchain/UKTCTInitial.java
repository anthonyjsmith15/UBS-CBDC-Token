package BoEBlockchain;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.*;


public class UKTCTInitial {
    /**
     * The current inflation rate goes into previousnationalinflationrate
     */
    public static Double UKpreviousnationalinflationrate = 9.0;
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
    public static Long GBDCsupply = 0L;
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

    public static Double UKsupplyfactor = 0.0;
    public static String UKsupplyfactorencrypted = "";
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
    private static String initialSupplyFactor = "";


    public static void main() throws Exception {

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
            UKnationalinflationrate = inflationrate.getMonth1Inflation();
        if (currentmonth == 14)
            UKnationalinflationrate = inflationrate.getMonth2inflation();
        if (currentmonth == 15)
            UKnationalinflationrate = inflationrate.getMonth3inflation();
        if (currentmonth == 16)
            UKnationalinflationrate = inflationrate.getMonth4inflation();
        if (currentmonth == 17)
            UKnationalinflationrate = inflationrate.getMonth5inflation();
        if (currentmonth == 18)
            UKnationalinflationrate = inflationrate.getMonth6inflation();
        if (currentmonth == 19)
            UKnationalinflationrate = inflationrate.getMonth7inflation();
        if (currentmonth == 20)
            UKnationalinflationrate = inflationrate.getMonth8inflation();
        if (currentmonth == 21)
            UKnationalinflationrate = inflationrate.getMonth9inflation();
        if (currentmonth == 22)
            UKnationalinflationrate = inflationrate.getMonth10inflation();
        if (currentmonth == 23)
            UKnationalinflationrate = inflationrate.getMonth11inflation();
        if (currentmonth == 24)
            UKnationalinflationrate = inflationrate.getMonth12inflation();

        if (UKnationalinflationrate >= UKnationalinflationtarget) {
            UKsupplyfactor = (UKaveragewagePPP / 365) * (1 - (Math.abs((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate)));
        } else if (UKnationalinflationrate == 0) {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (UKnationalinflationtarget - ((UKnationalinflationrate - UKpreviousnationalinflationrate))));
        } else if (UKnationalinflationrate < 0) {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (1 - Math.abs(((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate))));
        } else {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (UKnationalinflationtarget - ((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate)));
        }
        GBDCsupply =  88855000000L; //(long) ((UKTCTsupply / (UKnationalinflationtarget * UKnationalinflationtarget)) * (1 / USDGBP));
        UKinitialsupplyfactor = (GBDCsupply / UKpopulation) / ((UKnationalinflationtarget * UKnationalinflationtarget) * 100); // ((UKsupplyfactor * 10000000) / Double.valueOf(UKpopulation));

        if (day == 1 && currentmonth == 1) {
            UKTCTsupply = (long) (GBDCsupply * UKinitialsupplyfactor);
//                    ((((((citizen1.get("walletQuota") * quotafactor + citizen2.get("walletQuota") * quotafactor +
//                    citizen3.get("walletQuota") * quotafactor + citizen4.get("walletQuota") * quotafactor +
//                    citizen5.get("walletQuota") * quotafactor + citizen6.get("walletQuota") * quotafactor +
//                    citizen7.get("walletQuota") * quotafactor + citizen8.get("walletQuota") * quotafactor +
//                    citizen9.get("walletQuota") * quotafactor + citizen10.get("walletQuota") * quotafactor)
//                    * UKnationalinflationtarget * (Double.valueOf(UKpopulation) / 10)) / UKinitialsupplyfactor) * GBPUSD) * UKTCTsupplywages)
//                    * (UKnationalinflationtarget * UKnationalinflationtarget));
            GBDCmonetarypolicy = (long) (Math.abs(UKTCTbuysell * UKTCTGBDC));
            UKTCTGBDC = (Double.valueOf(GBDCsupply) / Double.valueOf(UKTCTsupply));
            UKTCTcirculatingsupply = (long) (quotasum * (Double.valueOf(UKpopulation) / 10));
            UKTCTmarketcap = (long) (Double.valueOf(UKTCTcirculatingsupply) * UKTCTGBDC);
            insertIntoPostgres();
        }
        System.out.println("Updating Postgres...");
        insertDayIntoPostgres();
        SECRET_KEY = retrieveSecretKeyFromPostgres();
        SALTVALUE = retrieveSaltvalueFromPostgres();
        UKsupplyfactorencrypted = encrypt(String.valueOf(calculateSupplyFactor()));
        insertFactorIntoPostgres();
        //swapCMPforDGBP();
        System.out.println("Postgres updated.");
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
    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException |
                 InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error occured during encryption: " + e.toString());
        }
        return null;
    }

    public static Double calculateSupplyFactor() {
        if (UKnationalinflationrate >= UKnationalinflationtarget) {
            UKsupplyfactor = (UKaveragewagePPP / 365) * (1 - (Math.abs((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate)));
        } else if (UKnationalinflationrate == 0) {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (UKnationalinflationtarget - ((UKnationalinflationrate - UKpreviousnationalinflationrate))));
        } else if (UKnationalinflationrate < 0) {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (1 - Math.abs(((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate))));
        } else {
            UKsupplyfactor = ((UKaveragewagePPP / 365) * (UKnationalinflationtarget - ((UKnationalinflationrate - UKpreviousnationalinflationrate) / UKnationalinflationrate)));
        }
        return UKsupplyfactor;
    }

        public static void swapCMPforDGBP() throws Exception {

        String startQuote = "\"";
        String endQuote = "\"";
        String baseStart = " cmd /c start cmd /K ";
        String first_command_chcp = " chcp 1251 ";
        String dirList = " &node Citizen1SwapCMPforDGBP.js ";
        String changeDir = " &cd/ &I: ";
        String changeDir2 = " &cd\\Ropsten &I: ";
        String javaLaunch = " &java ";
        String javaClass = " Encodes ";
        String javaCommand = javaLaunch + javaClass;
        String totalCommand = baseStart +
                startQuote +
                first_command_chcp +
                //javaCommand +
                changeDir +
                changeDir2 +
                dirList +
                endQuote;
        runCmd(totalCommand);

    }
    public static void issueTokens() throws Exception {

        String startQuote = "\"";
        String endQuote = "\"";
        String baseStart = " cmd /c start cmd /K ";
        String first_command_chcp = " chcp 1251 ";
        String dirList2 = " &node sendcmptocitizen1.js ";
        String changeDir = " &cd/ &I: ";
        String changeDir2 = " &cd\\Ropsten &I: ";
        String javaLaunch = " &java ";
        String javaClass = " Encodes ";
        String javaCommand = javaLaunch + javaClass;
        String totalCommand2 = baseStart + startQuote + first_command_chcp + changeDir + changeDir2 + dirList2 +
                endQuote;;
        runCmd(totalCommand2);
    }
    public static void runYear1() throws Exception {

        String startQuote = "\"";
        String endQuote = "\"";
        String baseStart = " cmd /c start cmd /c ";
        String first_command_chcp = " chcp 1251 ";
        String dirList = " &-cp BoEBlockchain-1.0-SNAPSHOT.jar BoEBlockchain.UKTCTv2";
        String changeDir = " &cd/ &I: ";
        String changeDir2 = " &cd\\Users\\antsm\\BoEBlockchain\\target &I: ";
        String javaLaunch = " &java ";
        String javaClass = " Encodes ";
        String javaCommand = javaLaunch + javaClass;
        String totalCommand = baseStart +
                startQuote +
                first_command_chcp +
                //javaCommand +
                changeDir +
                changeDir2 +
                javaCommand +
                dirList +
                endQuote;
        runCmd2(totalCommand);
    }
        public static void runCmd(String command) throws Exception {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);
            proc.waitFor();
        }
    public static void runCmd2(String command) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(command);
        proc.waitFor();
    }
        public static Double fillWallets () throws Exception {
            //mintSupply();
            //Thread.sleep(2000);
            //issueTokens();
            //swapCMPforDGBP();
            //runYear1();
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
        public static Connection connectpostgres () {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }
        public static void insertIntoPostgres () throws SQLException {

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
    public static void insertDayIntoPostgres () throws SQLException {

        String SQL = "INSERT INTO day (date, day) " +
                "VALUES (now(), ?)";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        {
            pstmt.setDouble(1, day);
            pstmt.executeUpdate();
            conn.close();
        }
    }
    public static void insertFactorIntoPostgres () throws SQLException {

        String SQL = "INSERT INTO supplyfactor (date, supplyfactor) " +
                "VALUES (now(), ?)";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        {
            pstmt.setString(1, UKsupplyfactorencrypted);
            pstmt.executeUpdate();
            conn.close();
        }
    }
    public static void insertSecretIntoPostgres () throws SQLException {

        String SQL = "INSERT INTO secret (date, secretkey, secretphrase) " +
                "VALUES (now(), ?, ?)";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        {
            pstmt.setString(1, SECRET_KEY);
            pstmt.setString(2, SALTVALUE);
            pstmt.executeUpdate();
            conn.close();
        }
    }
    public static String retrieveInitialSupplyFactorFromPostgres() throws SQLException {

        String SQLsecret = "SELECT initsupplyfactor from secret order by id desc";

        Connection conn = connectpostgres();
        PreparedStatement pstmt = conn.prepareStatement(SQLsecret);
        {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                initialSupplyFactor = rs.getString(1);
                conn.close();
                return initialSupplyFactor;

            }
        }
        return null;
    }
    public static void insertIntoGlobal () throws SQLException {

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
}










