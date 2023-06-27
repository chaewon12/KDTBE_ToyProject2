package org.fastcampus.domain.player;

import org.fastcampus.db.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDaoTest {
    Connection connection = DBConnection.getInstance();
    Savepoint savepoint;
    PlayerDao playerDao = PlayerDao.getInstance(connection);

    @BeforeEach
    void setUp() throws SQLException {
        connection.setAutoCommit(false); // 자동 커밋 비활성화
        savepoint = connection.setSavepoint(); // Savepoint 설정
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.rollback(savepoint); // 롤백
        connection.setAutoCommit(true); // 자동 커밋 활성화
    }

    @Test
    void insertPlayer_success_test() {
        // given
        Player player = Player.builder()
                .teamId(3)
                .name("나성범")
                .position("우익수")
                .build();

        // when
        int result = playerDao.insertPlayer(player);

        // then
        Assertions.assertEquals(result,1);
    }
    @Test
    void insertPlayer_fail_test() {
        // given
        Player player = Player.builder()
                .teamId(3)
                .name("나성범")
                .position("중견수")
                .build();

        // when
        int result = playerDao.insertPlayer(player);

        // then
        Assertions.assertEquals(result,0);
    }
}