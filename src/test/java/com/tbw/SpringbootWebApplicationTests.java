package com.tbw;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.tbw.dao.BookDao;
import com.tbw.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootWebApplicationTests {
    @Autowired
    BookDao bookDao;
    @Test
    void contextLoads() {
    }

    @Test
    void hh(){
        Book book = bookDao.searchBookByName("三体");
        System.out.println(book);
    }



}
