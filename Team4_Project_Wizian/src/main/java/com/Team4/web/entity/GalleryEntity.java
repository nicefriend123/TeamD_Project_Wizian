package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "ATTACHMENT")
public class GalleryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //@Column(length = 50, nullable = false)
    //private String title;

    @Column(columnDefinition = "TEXT")
    private String filePath;
    
    
    private String imgFullPath;
    
    

    @Builder
    public GalleryEntity(Long id, String filePath) {
        this.id = id;
        //this.title = title;
        this.filePath = filePath;
    }
}