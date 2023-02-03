package com.cathaybk.lambda.function;


import java.util.Map;
import java.util.function.Supplier;

/**
 * @author RogerLo
 * @date 2022/3/2
 */
class RsData {
    String txnSerial;
    String traderName;

    public String getTxnSerial() {
        return txnSerial;
    }

    public RsData setTxnSerial(String txnSerial) {
        this.txnSerial = txnSerial;
        return this;
    }

    public String getTraderName() {
        return traderName;
    }

    public RsData setTraderName(String traderName) {
        this.traderName = traderName;
        return this;
    }

    @Override
    public String toString() {
        return "RsData{" +
                "txnSerial='" + txnSerial + '\'' +
                ", traderName='" + traderName + '\'' +
                '}';
    }
}

public class Test_Function003 {

    public static void main(String[] args) {
        RsData rsData = new RsData();
        Test_Function003.putDataIntoRs(rsData, () -> {
            return Map.of("_txnSerial", "txn0003607788", "_traderName", "Roger");
        });
        System.out.println(rsData);
    }

    public static void putDataIntoRs(RsData rsData, Supplier<Map<String, String>> supplier) {
        var stringStringMap = supplier.get();
        rsData.setTraderName(stringStringMap.get("_txnSerial")).setTxnSerial(stringStringMap.get("_traderName"));
    }

}
