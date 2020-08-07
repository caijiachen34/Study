package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BooksService booksService;

    //查询全部书籍，并且返回到书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=booksService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        booksService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books=booksService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=="+books);
        int i=booksService.updateBook(books);
        if (i>0){
            System.out.println("添加book成功" +books);
        }
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        booksService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){

        
    }


}
