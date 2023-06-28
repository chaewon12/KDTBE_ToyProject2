package org.fastcampus.dto.player;

import lombok.*;

public class PlayerRequestDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PlayerAddReqDTO{
        private Integer teamId;
        private String name;
        private String position;
    }
}
