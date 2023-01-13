package com.cathaybk.paginate;

import java.text.MessageFormat;
import java.util.List;

/**
 * 使用 Linq / StreamAPI 進行分頁
 * ref. https://ithelp.ithome.com.tw/articles/10104729
 */
public class StreamPaginateTest {

    public static void main(String[] args) {
        List<Integer> elemList = List.of(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17);
        var pageRows = 5; // 每頁幾筆
        var totalPageCnt = elemList.size() % pageRows != 0 ? (elemList.size() / pageRows) + 1 : elemList.size() / pageRows;
        for (int page = 1; page <= totalPageCnt; page++) {
            // System.out.println(MessageFormat.format("Page-{0}: ", page));
            System.out.println(
                    MessageFormat.format("Page-{0}: {1}",
                            page, StreamPaginateTest.getElemsByPageNum(elemList, page, pageRows)));
        }
    }

    /**
     * 使用 skip + limit 進行分頁
     */
    public static <T> List<T> getElemsByPageNum(List<T> list, int pageCnt, int pageRows) {
        return list.stream()
                .skip((pageCnt - 1) * pageRows)
                .limit(pageRows)
                .toList();
    }

}
