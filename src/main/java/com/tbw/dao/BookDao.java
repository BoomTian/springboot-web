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

    @Update("update  book set book_name = #{book_name},book_author = #{book_author},book_publish = #{book_publish},book_price = #{book_price} where book_id =#{book_id}")
    public void update(Book book);

    @Select("select count(*) from book")
    Integer getTotal();

    @Select("select count(*) from book where book_name =#{book_name}")
    Integer getNameTotal(@Param("book_name") String book_name);

    @Select("select * from book")
    public List<Book> getAll();

    @Select("select * from book where book_id =#{book_id}")
    public Book getBookById(@Param("book_id") Integer book_id);
    @Select("select * from book where book_id =#{book_id}")
    public Book getBookBy(@Param("book_id") Integer book_id);

    @Select("select * from book where book_name =#{book_name}")
    public Book searchBookByName(@Param("book_name") String book_name);

    @Delete("delete from book where book_id = #{book_id}")
    public void delete(@Param("book_id") Integer book_id);
}
