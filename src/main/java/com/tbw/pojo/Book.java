package com.tbw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hasee
 * 信息安全 应用现状 发展趋势
 * 信息安全技术是什么
 * 问题？
 * 现状
 * 发展
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private String book_publish;
    private double book_price;

    public Book(String book_name, String book_author, String book_publish, double book_price) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_publish = book_publish;
        this.book_price = book_price;
    }
}
