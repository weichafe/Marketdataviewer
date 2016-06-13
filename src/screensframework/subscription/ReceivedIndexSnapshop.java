package screensframework.subscription;

import quickfix.field.*;
import quickfix.fix44.MarketDataSnapshotFullRefresh;
import quickfix.fix44.Message;
import screensframework.Repository;
import screensframework.model.IndexModel;
import screensframework.utils.Configuration;

public class ReceivedIndexSnapshop extends Thread {

    private IndexModel indexModel;
    private MarketDataSnapshotFullRefresh.NoMDEntries noMDEntries = new MarketDataSnapshotFullRefresh.NoMDEntries();

    public ReceivedIndexSnapshop(Message message) {

        try {

            if (!message.getString(MDReqID.FIELD).equals(Configuration.mDReqIDIdex)) return;

            String symbol = getSymbol(message);

            if (message.getString(Symbol.FIELD).endsWith("(Con dividendos)")) {

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

            if (message.getString(Symbol.FIELD).endsWith("(Sin dividendos)")) {

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


    public String getSymbol(Message message) throws Exception{
        return (message.getString(Symbol.FIELD).endsWith("(Sin dividendos)")) ?
                message.getString(Symbol.FIELD).replace("(Sin dividendos)","") :
                message.getString(Symbol.FIELD).replace("(Con dividendos)","");
    }
}
