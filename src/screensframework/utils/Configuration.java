package screensframework.utils;

import screensframework.Repository;

public class Configuration {

    public static final String[] IPSA           = Repository.properties.getPropertiesString("IPSA").split(";");
    public static final String[] INTER10        = Repository.properties.getPropertiesString("INTER10").split(";");
    public static final String[] IGPAMID        = Repository.properties.getPropertiesString("IGPAMID").split(";");
    public static final String[] BANCA          = Repository.properties.getPropertiesString("BANCA").split(";");
    public static final String[] IGPASMALL      = Repository.properties.getPropertiesString("IGPASMALL").split(";");
    public static final String[] RETAIL         = Repository.properties.getPropertiesString("RETAIL").split(";");
    public static final String[] CONSUMO        = Repository.properties.getPropertiesString("CONSUMO").split(";");
    public static final String[] CONSTINMOB     = Repository.properties.getPropertiesString("CONSTINMOB").split(";");
    public static final String[] COMMODITIES    = Repository.properties.getPropertiesString("COMMODITIES").split(";");
    public static final String[] IGPA           = Repository.properties.getPropertiesString("IGPA").split(";");
    public static final String[] INDUSTRIAL     = Repository.properties.getPropertiesString("INDUSTRIAL").split(";");
    public static final String[] UTILITIES      = Repository.properties.getPropertiesString("UTILITIES").split(";");
    public static final String[] IGPALARGE      = Repository.properties.getPropertiesString("IGPALARGE").split(";");
    public static final String[] DefaultIndex   = getSymbolIndex(Repository.properties.getPropertiesString("DefaultSubscribe"));

    public static String mDReqID = null;
    public static String mDReqIDIdex = null;

    public static class Index {

        public final static String SYMBOLS = Repository.properties.getPropertiesString("SymbolIndexes");
        public final static String SENDER_INDEX = Repository.properties.getPropertiesString("SenderCompIDIdex");
        public final static String TARGET_INDEX = Repository.properties.getPropertiesString("TargetCompIDIdex");
    }

    public static class Paper {

        public final static String SENDER_PAPER = Repository.properties.getPropertiesString("SenderCompIDIpsa");
        public final static String TARGET_PAPER = Repository.properties.getPropertiesString("TargetCompIDIpsa");
    }

    public static String[] getSymbolIndex(String symbol){

        if (symbol.equals("IGPAMID")){
            return IGPAMID;

        } else if (symbol.equals("BANCA")){
            return BANCA;

        } else if (symbol.equals("IGPASMALLL")){
            return RETAIL;

        } else if (symbol.equals("CONSUMO")){
            return CONSUMO;

        } else if (symbol.equals("CONSTINMOB")){
            return CONSTINMOB;

        } else if (symbol.equals("COMMODITIES")){
            return COMMODITIES;

        } else if (symbol.equals("INTER10")){
            return INTER10;

        } else if (symbol.equals("IGPA")){
            return INTER10;

        } else if (symbol.equals("INDUSTRIAL")){
            return INDUSTRIAL;

        } else if (symbol.equals("IPSA")){
            return IPSA;

        } else if (symbol.equals("UTILITIES")){
            return UTILITIES ;

        } else {
            return IGPALARGE ;
        }

    }
}

