package com.shepherd.manage.webTest;

import com.shepherd.manage.test.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 9:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebTestDemo {
    @Autowired
    private Book b;
    @Test
    public void testBook(){
        System.out.println(b.getName());
    }
}
