package com.tbw.dao;

import com.tbw.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tbw
 */
@Repository
@Mapper
public interface BookDao {
    /**
     * 增加书
     * @author tbw
     * @param book book
     *
     */
    @Insert("insert into book(book_name,book_author,book_publish,book_price)  values (#{book_name},#{book_author},#{book_publish},#{book_price})")
    public void save(Book book);

    @Insert("insert into book(book_id,book_name,book_author,book_publish,book_price)  values (#{book_id},#{book_name},#{book_author},#{book_publish},#{book_price})")
    public void saveById(Book book);

    @Select("select * from book")
    public List<Book> getAll();

    @Select("select * from book where book_id =#{book_id}")
    public Book getBookById(@Param("book_id") Integer book_id);

    @Delete("delete from book where book_id = #{book_id}")
    public void delete(@Param("book_id") Integer book_id);
}
