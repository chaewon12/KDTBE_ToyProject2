package org.fastcampus.dto.player;

import lombok.*;
import org.fastcampus.domain.player.Player;

import java.util.List;

public class PlayerRespDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PlayerListRespDTO{
        private Integer id;
        private String name;
        private String position;

        public static PlayerListRespDTO fromEntity(Player player){
            return PlayerListRespDTO.builder()
                    .id(player.getId())
                    .name(player.getName())
                    .position(player.getPosition())
                    .build();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("--------------------------------------");
            sb.append("\nid: ").append(id);
            sb.append("\nname: ").append(name);
            sb.append("\nposition: ").append(position);
            sb.append("\n--------------------------------------");
            return sb.toString();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class positionBoardRespDTO{
        private String position;
        private List<String> nameList;
    }
}
