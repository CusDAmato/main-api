package ru.diamond.mainapi.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserStoryId implements Serializable {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "story_uuid")
    private UUID storyUuid;
}
