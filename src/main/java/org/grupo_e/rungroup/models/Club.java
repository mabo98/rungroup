package org.grupo_e.rungroup.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")

public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String photoUrl;
    private String content;
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<Event> events = new ArrayList<>();
}
