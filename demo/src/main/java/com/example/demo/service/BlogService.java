package com.example.demo.service;

import com.example.demo.dto.BlogDto;
import com.example.demo.dto.BlogUpdateDto;
import com.example.demo.model.Blogs;
import com.example.demo.model.User;
import com.example.demo.repo.BlogRepo;
import com.example.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BlogService  {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthService authService;

    public ResponseEntity<String> createBlog(BlogDto blogDto)
    {
        Blogs blog = new Blogs();
        blog.setBlog(blogDto.getBlog());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        User current = authService.getCurrentUser();
        blog.setBlog(blogDto.getBlog());
        blog.setUser(current);
        blog.setDateCreated(Instant.now());
        blogRepo.save(blog);
        return new ResponseEntity<>("Done",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBlog(Long id)
    {
        System.out.println("Fdf");
        Optional<Blogs> curr = blogRepo.findById(id);
        Blogs blog = curr.get();
        if(blog.getUser() == authService.getCurrentUser())
            blogRepo.delete(blog);
        else
            return new ResponseEntity<>("you cant delete others post",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("deleted blog successfully",HttpStatus.OK);
    }

    public ResponseEntity<String>   updateBlog(Long id, BlogUpdateDto blogUpdateDto)
    {
        Optional<Blogs> curr = blogRepo.findById(id);
        Blogs blog = curr.get();
        if(blog.getUser() == authService.getCurrentUser())
        {
            blog.setBlog(blogUpdateDto.getBlog());
            blogRepo.save(blog);
        }
        else
            return  new ResponseEntity<>("only blog owner can delete", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("updated blog successfully",HttpStatus.OK);
    }
}
