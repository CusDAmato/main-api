package ru.diamond.mainapi.dtos.story;

import java.util.UUID;
import lombok.Data;

@Data
public class StoryDto {
    private UUID uuid;
    private String previewImgPath;
    private String imgPath;
    private String caption;
    private String title;
    private String subtitle;
    private boolean wasSeen;
}
