package screensframework.adaptor;

import quickfix.*;
import quickfix.Message;
import quickfix.fix44.*;
import quickfix.fix44.MessageCracker;
import screensframework.subscription.*;
import screensframework.utils.Configuration;

public final class QuickFixAdapter extends MessageCracker implements Application {

    public SocketInitiator socketInitiator;

    public QuickFixAdapter(String quickFixIniFile) {

        try {

            SessionSettings sessionSettings = new SessionSettings(quickFixIniFile);
            FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
            FileLogFactory fileLogFactory = new FileLogFactory(sessionSettings);
            DefaultMessageFactory defaultMessageFactory = new DefaultMessageFactory();

            this.socketInitiator = new SocketInitiator(this, fileStoreFactory, sessionSettings, fileLogFactory, defaultMessageFactory);
            this.socketInitiator.start();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void onCreate(SessionID sessionID) {

    }

    public void onLogon(SessionID sessionID) {

        if(sessionID.getSenderCompID().equals(Configuration.Index.SENDER_INDEX)){
            new SubscribeIndex().start();
        }

        if (sessionID.getSenderCompID().equals(Configuration.Paper.SENDER_PAPER)){
            new SubscribeSymbol(Configuration.DefaultIndex).start();
        }

    }

    public void onLogout(SessionID sessionID) {

    }

    public void toAdmin(Message message, SessionID sessionID) {

    }

    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

        try {
            crack(message, sessionID);
        } catch (UnsupportedMessageType unsupportedMessageType) {
            unsupportedMessageType.printStackTrace();
        }
    }

    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        // nothing
    }

    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

        try {
            crack(message, sessionID);
        } catch (UnsupportedMessageType unsupportedMessageType) {
            unsupportedMessageType.printStackTrace();
        }
    }

    public synchronized void onMessage(MarketDataSnapshotFullRefresh marketDataSnapshotFullRefresh, SessionID sessionID) {
        new ReceivedIndexSnapshop(marketDataSnapshotFullRefresh);
        new ReceivedSymbolsSnapshop(marketDataSnapshotFullRefresh);
    }

    public void onMessage(MarketDataIncrementalRefresh marketDataIncrementalRefresh, SessionID sessionID) {
        new ReceivedIndexIncremental(marketDataIncrementalRefresh).start();
        //new ReceivedSymbolIncremental(marketDataIncrementalRefresh).start();
    }

    public void onMessage(SecurityListRequest  securityListRequest , SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(MarketDataRequestReject marketDataRequestReject , SessionID sessionID) throws FieldNotFound {

    }

}

