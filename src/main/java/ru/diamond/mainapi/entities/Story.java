package ru.diamond.mainapi.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stories", schema = "diamond")
public class Story {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "UUID")
    private UUID uuid;

    @Column(name = "preview_img_path")
    private String previewImgPath;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "caption")
    private String caption;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStory> users = new HashSet<>();
}
