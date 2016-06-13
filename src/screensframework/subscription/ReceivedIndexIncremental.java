package screensframework.subscription;

import quickfix.field.MDReqID;
import quickfix.field.NoMDEntries;
import quickfix.fix44.MarketDataIncrementalRefresh;
import quickfix.fix44.MarketDataSnapshotFullRefresh;
import quickfix.fix44.Message;
import screensframework.Repository;
import screensframework.model.IndexModel;
import screensframework.utils.Configuration;


public class ReceivedIndexIncremental extends Thread {

    private IndexModel indexModel;
    private Message message;
    private MarketDataSnapshotFullRefresh.NoMDEntries noMDEntries = new MarketDataSnapshotFullRefresh.NoMDEntries();

    public ReceivedIndexIncremental(Message message){
        this.message = message;
    }

    public void run(){

        try {

            if (!message.getString(MDReqID.FIELD).equals(Configuration.mDReqIDIdex)) return;

            String symbol = "";

            for (int i = 1; i <= message.getDouble(NoMDEntries.FIELD); i++) {
                MarketDataIncrementalRefresh.NoMDEntries noMDEntries = new MarketDataIncrementalRefresh.NoMDEntries();
                message.getGroup(i, noMDEntries);
                symbol = noMDEntries.getSymbol().getValue();
            }


            if (symbol.endsWith("(Con dividendos)")) {

                symbol = getSymbol(symbol);

                if (!Repository.indexController.hashData.containsKey(symbol)) {

                    indexModel = new IndexModel();
                    indexModel.setPositions(Repository.indexController.positions++);

                    indexModel.setSymbol(symbol);

                    for (int i = 1; i <= message.getDouble(NoMDEntries.FIELD); i++) {
                        message.getGroup(i, noMDEntries);
                        indexModel.setValueDiv(noMDEntries.getMDEntryPx().getValue());
                        indexModel.setVarDiv(noMDEntries.getPriceDelta().getValue());
                        indexModel.setAmount(noMDEntries.getMDEntrySize().getValue());
                    }

                    Repository.indexController.hashData.put(symbol, indexModel);
                    Repository.indexController.data.add(indexModel.getPositions(), indexModel);

                } else {

                    indexModel = Repository.indexController.hashData.get(symbol);

                    for (int i = 1; i <= message.getDouble(NoMDEntries.FIELD); i++) {
                        message.getGroup(i, noMDEntries);
                        indexModel.setValueDiv(noMDEntries.getMDEntryPx().getValue());
                        indexModel.setVarDiv(noMDEntries.getPriceDelta().getValue());
                        indexModel.setAmount(noMDEntries.getMDEntrySize().getValue());
                    }

                    Repository.indexController.data.set(indexModel.getPositions(), indexModel);
                }

            }

            if (symbol.endsWith("(Sin dividendos)")) {

                symbol = getSymbol(symbol);

                if (!Repository.indexController.hashData.containsKey(symbol)) {

                    indexModel = new IndexModel();
                    indexModel.setSymbol(symbol);
                    indexModel.setPositions(Repository.indexController.positions++);

                    for (int i = 1; i <= message.getDouble(NoMDEntries.FIELD); i++) {
                        message.getGroup(i, noMDEntries);
                        indexModel.setValueSin(noMDEntries.getMDEntryPx().getValue());
                        indexModel.setVarSin(noMDEntries.getPriceDelta().getValue());
                        indexModel.setAmount(noMDEntries.getMDEntrySize().getValue());
                    }

                    Repository.indexController.hashData.put(symbol, indexModel);
                    Repository.indexController.data.add(indexModel.getPositions(), indexModel);

                } else {

                    indexModel = Repository.indexController.hashData.get(symbol);

                    for (int i = 1; i <= message.getDouble(NoMDEntries.FIELD); i++) {
                        message.getGroup(i, noMDEntries);
                        indexModel.setValueSin(noMDEntries.getMDEntryPx().getValue());
                        indexModel.setVarSin(noMDEntries.getPriceDelta().getValue());
                        indexModel.setAmount(noMDEntries.getMDEntrySize().getValue());
                    }

                    Repository.indexController.data.set(indexModel.getPositions(), indexModel);
                }

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public String getSymbol(String message) throws Exception{
        return (message.endsWith("(Sin dividendos)")) ?
                message.replace("(Sin dividendos)", "") :
                message.replace("(Con dividendos)","");
    }
}
