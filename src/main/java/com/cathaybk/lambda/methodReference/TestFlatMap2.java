package com.cathaybk.lambda.methodReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.cathaybk.model.FakeData;

public class TestFlatMap2 {

	/**
	 * FakeData 原始json : sample1.json 
	 */
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		System.out.println(FakeData.originDataMap);
		List<Map<String, Object>> oriList = (ArrayList<Map < String, Object >>) FakeData.originDataMap.get("Companies");
		
		Map<String, Object> rsData = new HashMap<>();
		AtomicInteger i = new AtomicInteger(0);
		Map<Object, Object> ggMap = oriList.stream()
			.map(x -> { 
				List<String> campaignList = new ArrayList<String>();
				Optional.ofNullable((String) x.get("RATE_A")).ifPresent((rateA) -> {
					campaignList.add("活動加碼優惠：" + rateA + " %");
				});
				Optional.ofNullable((String) x.get("RATE_B")).ifPresent((rateB) -> {
					campaignList.add("活存利率：" + rateB + " %");
				});
				Optional.ofNullable((String) x.get("FREE_WITHDRAW")).ifPresent((times) -> {
					campaignList.add("跨提轉：" + times + " 次");
				});
				x.put("Campaigns", campaignList);
				// --- 
				List<String> empNameList = ((ArrayList<Map <String, String>>) x.get("Emps")).stream()
					.map(gg -> gg.get("name"))
					.collect(Collectors.toList());
				x.put("EmpNames", empNameList);
				return x;
			})
//			.flatMap(x -> {
////				System.out.println("@" + x);
////				Stream<Map<String, String>> stream1 = ((ArrayList<Map <String, String>>) x.get("Emps")).stream();
//				Stream<String> stream1 = ((List<String>) x.get("EmpNames")).stream();
//				Stream<String> stream2 = ((List<String>) x.get("Campaigns")).stream();
//				return Stream.concat(stream1, stream2);
//			})
			.collect(Collectors.toMap(entry -> i.incrementAndGet(), entry -> {
				return Map.of("EmpNames", entry.get("EmpNames"), "Campaigns", entry.get("Campaigns"));
			}));
//			.forEach(System.out::println);
		
		rsData.put("ggMap", ggMap);
		System.out.println("------------------");
		System.out.println("rsData = " + rsData);
	}
	
}