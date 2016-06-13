package screensframework.subscription;


import quickfix.field.MDEntryPx;
import quickfix.field.MDEntryType;
import quickfix.field.MDReqID;
import quickfix.fix44.MarketDataIncrementalRefresh;
import quickfix.fix44.MarketDataSnapshotFullRefresh;
import screensframework.Repository;
import screensframework.controller.SymbolsController;
import screensframework.model.SymbolsModel;
import screensframework.utils.Configuration;

public class ReceivedSymbolIncremental extends Thread {

    private MDEntryPx mdEntryPx = new MDEntryPx();
    private SymbolsController controller;

    public ReceivedSymbolIncremental(MarketDataIncrementalRefresh mktDataFull){

        try {

            if (!mktDataFull.getString(MDReqID.FIELD).equals(Configuration.mDReqID)) return;

            controller = (SymbolsController) Repository.mainContainer.getController("SymbolID");
            SymbolsModel symbolsModel = new SymbolsModel();


            for (int i = 1; i <= mktDataFull.getNoMDEntries().getValue(); i++) {

                MarketDataIncrementalRefresh.NoMDEntries noMDEntries = new MarketDataIncrementalRefresh.NoMDEntries();
                mktDataFull.getGroup(i, noMDEntries);
                MDEntryType mdEntryType = new MDEntryType();
                noMDEntries.get(mdEntryType);

                symbolsModel.setSymbol(noMDEntries.getSymbol().getValue());

                if(mdEntryType.valueEquals(MDEntryType.OPENING_PRICE)) {
                    noMDEntries.get(mdEntryPx);
                    symbolsModel.setOpen(mdEntryPx.getValue());

                } else if(mdEntryType.valueEquals(MDEntryType.CLOSING_PRICE)) {
                    noMDEntries.get(mdEntryPx);
                    symbolsModel.setClose(mdEntryPx.getValue());

                } else if(mdEntryType.valueEquals(MDEntryType.TRADING_SESSION_HIGH_PRICE)) {
                    noMDEntries.get(mdEntryPx);
                    symbolsModel.setHigh(mdEntryPx.getValue());

                } else if(mdEntryType.valueEquals(MDEntryType.TRADING_SESSION_LOW_PRICE)) {
                    noMDEntries.get(mdEntryPx);
                    symbolsModel.setLow(mdEntryPx.getValue());

                } else if(mdEntryType.valueEquals(MDEntryType.IMBALANCE)) {
                    noMDEntries.get(mdEntryPx);
                    symbolsModel.setImbalance(mdEntryPx.getValue());


                } else if(mdEntryType.valueEquals(MDEntryType.TRADE_VOLUME)) {
                    symbolsModel.setVolume(noMDEntries.getMDEntrySize().getValue());

                } else if(mdEntryType.valueEquals('D')) {
                    symbolsModel.setAmount(noMDEntries.getMDEntrySize().getValue());

                } else if(mdEntryType.valueEquals('G')) {
                    symbolsModel.setMarginRate(noMDEntries.getText().getValue());
                }

            }

            if (!controller.hashData.containsKey(symbolsModel.getSymbol())){
                controller.addNewValue(symbolsModel);

            } else {
                controller.oldValue(symbolsModel);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}



