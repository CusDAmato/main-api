package ru.diamond.mainapi.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
@Entity
@Table(name = "users", schema = "diamond")
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "wardrobe_efficiency")
    private Double wardrobeEfficiency;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Type(type = "jsonb")
    @Column(name = "fitted_outfit")
    private JsonNode fittedOutfit;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Clothes> clothes = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStory> stories = new HashSet<>();

}
