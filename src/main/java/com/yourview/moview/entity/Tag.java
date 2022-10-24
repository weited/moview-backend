package com.yourview.moview.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tag")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "tag_name")
    private String name;

    @CreationTimestamp
    @Column(name = "created_time")
    private OffsetDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private OffsetDateTime updatedTime;
}
