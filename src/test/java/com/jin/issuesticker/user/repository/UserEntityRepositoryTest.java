package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserEntityRepositoryTest {

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Test
    public void userEntity_저장_테스트() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("test_id");
        userEntity.setEmail("email@email.com");
        userEntity.setName("테스트_유저");
        userEntity.setRegisteredDate(new Timestamp(new Date().getTime()));

        UserEntity saveUserEntity = userEntityRepository.save(userEntity);

        assertThat(saveUserEntity.getId(), is(notNullValue()));
    }
}
