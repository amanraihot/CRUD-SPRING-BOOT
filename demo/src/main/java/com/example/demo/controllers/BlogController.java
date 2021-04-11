package com.example.demo.controllers;
import com.example.demo.dto.BlogDto;
import com.example.demo.dto.BlogUpdateDto;
import com.example.demo.model.Blogs;
import com.example.demo.repo.BlogRepo;
import com.example.demo.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blog/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public ResponseEntity<String> createBlog(@RequestBody BlogDto blogDto)
    {
        return blogService.createBlog(blogDto);
    }

    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<String> deleteBlog(@PathVariable String id)
    {
        return blogService.deleteBlog(Long.parseLong(id));
    }

    @PutMapping("/update/{id}/")
    public ResponseEntity<String> updateBlog(@PathVariable String id, @RequestBody BlogUpdateDto blogUpdateDto)
    {
        System.out.println(Long.parseLong(id));
         return   blogService.updateBlog(Long.parseLong(id),blogUpdateDto);
    }


}
