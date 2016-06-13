package screensframework.subscription;

import quickfix.Session;
import quickfix.field.*;
import quickfix.fix44.MarketDataRequest;
import screensframework.utils.Configuration;
import screensframework.utils.Helper;

public class SubscribeSymbol extends Thread {

    String [] symbolList;

    public SubscribeSymbol(String [] symbolList){
        this.symbolList = symbolList;
    }

    public void run() {

        try {

            MarketDataRequest mktDataReq = new MarketDataRequest();

            MarketDataRequest.NoRelatedSym noRelatedSym = new MarketDataRequest.NoRelatedSym();
            mktDataReq.getHeader().setString(SenderSubID.FIELD, "1");

            mktDataReq.set(new SubscriptionRequestType(SubscriptionRequestType.SNAPSHOT_PLUS_UPDATES));
            mktDataReq.set(new MarketDepth(1));

            Configuration.mDReqID = Helper.getID();
            mktDataReq.set(new MDReqID(Configuration.mDReqID));

            for (String symbol : symbolList) {
                noRelatedSym.set(new Symbol(symbol));
                mktDataReq.addGroup(noRelatedSym);
            }

            noRelatedSym.set(new SecurityExchange(Helper.XSGO));
            mktDataReq.addGroup(noRelatedSym);

            MarketDataRequest.NoMDEntryTypes noMDEntryType4 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType4.set(new MDEntryType(MDEntryType.OPENING_PRICE));
            mktDataReq.addGroup(noMDEntryType4);

            MarketDataRequest.NoMDEntryTypes noMDEntryType5 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType5.set(new MDEntryType(MDEntryType.CLOSING_PRICE));
            mktDataReq.addGroup(noMDEntryType5);

            MarketDataRequest.NoMDEntryTypes noMDEntryType7 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType7.set(new MDEntryType(MDEntryType.TRADING_SESSION_HIGH_PRICE));
            mktDataReq.addGroup(noMDEntryType7);

            MarketDataRequest.NoMDEntryTypes noMDEntryType8 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType8.set(new MDEntryType(MDEntryType.TRADING_SESSION_LOW_PRICE));
            mktDataReq.addGroup(noMDEntryType8);

            MarketDataRequest.NoMDEntryTypes noMDEntryType9 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType9.set(new MDEntryType(MDEntryType.TRADING_SESSION_VWAP_PRICE));
            mktDataReq.addGroup(noMDEntryType9);

            MarketDataRequest.NoMDEntryTypes noMDEntryTypeA = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryTypeA.set(new MDEntryType(MDEntryType.IMBALANCE));
            mktDataReq.addGroup(noMDEntryTypeA);

            MarketDataRequest.NoMDEntryTypes noMDEntryTypeB = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryTypeB.set(new MDEntryType(MDEntryType.TRADE_VOLUME));
            mktDataReq.addGroup(noMDEntryTypeB);

            MarketDataRequest.NoMDEntryTypes noMDEntryTypeD = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryTypeD.set(new MDEntryType(MDEntryType.COMPOSITE_UNDERLYING_PRICE));
            mktDataReq.addGroup(noMDEntryTypeD);

            MarketDataRequest.NoMDEntryTypes noMDEntryTypeG = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryTypeG.set(new MDEntryType(MDEntryType.MARGIN_RATE));
            mktDataReq.addGroup(noMDEntryTypeG);

            MarketDataRequest.NoMDEntryTypes noMDEntryType0 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType0.set(new MDEntryType(MDEntryType.BID));
            mktDataReq.addGroup(noMDEntryType0);

            MarketDataRequest.NoMDEntryTypes noMDEntryType1 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType1.set(new MDEntryType(MDEntryType.OFFER));
            mktDataReq.addGroup(noMDEntryType1);

            MarketDataRequest.NoMDEntryTypes noMDEntryType2 = new MarketDataRequest.NoMDEntryTypes();
            noMDEntryType2.set(new MDEntryType(MDEntryType.TRADE));
            mktDataReq.addGroup(noMDEntryType2);

            Session.sendToTarget(mktDataReq, Configuration.Paper.SENDER_PAPER, Configuration.Paper.TARGET_PAPER);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }


}
