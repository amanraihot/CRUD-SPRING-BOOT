package com.example.demo.controllers;
import com.example.demo.dto.BlogDto;
import com.example.demo.model.Blogs;
import com.example.demo.repo.BlogRepo;
import com.example.demo.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public ResponseEntity<String> createBlog(@RequestBody BlogDto blogDto)
    {
        System.out.println("fdfff");
        return blogService.createBlog(blogDto);
    }

}
