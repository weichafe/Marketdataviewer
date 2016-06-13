package screensframework.subscription;

import quickfix.Session;
import quickfix.field.*;
import quickfix.fix44.MarketDataRequest;
import screensframework.utils.Configuration;
import screensframework.utils.Helper;

public class SubscribeIndex extends Thread {

    private MarketDataRequest.NoMDEntryTypes noMDEntryType = new MarketDataRequest.NoMDEntryTypes();

    public void run() {

        try {

            MarketDataRequest mktDataReq = new MarketDataRequest();

            MarketDataRequest.NoRelatedSym noRelatedSym = new MarketDataRequest.NoRelatedSym();
            mktDataReq.getHeader().setString(SenderSubID.FIELD, "1");

            mktDataReq.set(new SubscriptionRequestType(SubscriptionRequestType.SNAPSHOT_PLUS_UPDATES));
            mktDataReq.set(new MarketDepth(1));

            Configuration.mDReqIDIdex = Helper.getID();
            mktDataReq.set(new MDReqID(Configuration.mDReqIDIdex));

            noRelatedSym.set(new Symbol(Configuration.Index.SYMBOLS));
            noRelatedSym.set(new SecurityExchange(Helper.XSGO));
            mktDataReq.addGroup(noRelatedSym);

            noMDEntryType.set(new MDEntryType(MDEntryType.INDEX_VALUE));
            mktDataReq.addGroup(noMDEntryType);

            Session.sendToTarget(mktDataReq, Configuration.Index.SENDER_INDEX, Configuration.Index.TARGET_INDEX);


        } catch(Exception ex) {
            ex.printStackTrace();

        }

    }


}
