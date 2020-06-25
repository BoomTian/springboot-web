package com.tbw.controller;

import com.tbw.dao.BookDao;
import com.tbw.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hasee
 */
@Controller
public class BookController {

    @Autowired
    BookDao bookDao;


    @RequestMapping("/books")
    public String list(Model model){
        List<Book> books = bookDao.getAll();
        Integer total = bookDao.getTotal();
        model.addAttribute("total",total);
        model.addAttribute("books",books);
        return "list";
    }

    @GetMapping("/add")

    public String toAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String addBook(Book book,Model model){
        boolean b = bookDao.getBookId(book.getBook_id());
        System.out.println(b);
        if (b=true){
            model.addAttribute("gg","您输入的id号已存在请修改");
            return "/add";
        }
         bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/add/{book_id}")
    public String toUpdate(@PathVariable("book_id") Integer book_id, Model model){
        Book book = bookDao.getBookById(book_id);
        model.addAttribute("book",book);
        return "update";
    }

    @PostMapping("/update")
    public String update(Book book){
        bookDao.update(book);
        return "redirect:/books";
    }
    @GetMapping("/del")
    public String delete(@RequestParam("book_id")Integer book_id){
        bookDao.delete(book_id);
        return "redirect:/books";
    }

    @PostMapping("/search")
    public String secrch(String book_name,Model model){
        Book books = bookDao.searchBookByName(book_name);
        Integer nameTotal = bookDao.getNameTotal(book_name);
        model.addAttribute("books",books);
        model.addAttribute("total",nameTotal);
        return "list";
    }

}
