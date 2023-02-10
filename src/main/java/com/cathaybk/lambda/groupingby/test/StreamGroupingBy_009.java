package com.cathaybk.lambda.groupingby.test;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RogerLo
 * @date 2023/2/2
 */
class Txn {

    int id;
    String city;
    BigDecimal money;
    String type; // 交易分類

    public Txn(int id, String city, BigDecimal money, String type) {
        this.id = id;
        this.city = city;
        this.money = money;
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("city", city)
                .append("money", money)
                .append("type", type)
                .toString();
    }
}

public class StreamGroupingBy_009 {

    public static void main(String[] args) {
        Txn txn1 = new Txn(1, "Taipei", new BigDecimal(100), "即時");
        Txn txn2 = new Txn(2, "USA", new BigDecimal(200), "批次");
        Txn txn3 = new Txn(3, "Taipei", new BigDecimal(101), "即時");
        Txn txn4 = new Txn(4, "Taipei", new BigDecimal(105), "批次");
        Txn txn5 = new Txn(5, "USA", new BigDecimal(107), "即時");

        List<Txn> txnList
                = Stream.of(txn1, txn2, txn3, txn4, txn5).toList();

        Map<String, BigDecimal> result = txnList.stream()
                .collect(Collectors.groupingBy(Txn::getCity))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, xx -> {
                    return xx.getValue().stream()
                            .map(txn -> txn.money)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                }));
        System.out.println("result = " + result);
    }

}
