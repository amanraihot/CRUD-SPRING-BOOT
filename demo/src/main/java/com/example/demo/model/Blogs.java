package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.CloseableThreadContext;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blogs {
    @Id
    @Column(name = "blogId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogId;

    @Column(name = "blog")
    private String blog;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name= "date")
    private Instant dateCreated;

}
