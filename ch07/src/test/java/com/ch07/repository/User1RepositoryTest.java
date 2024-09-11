package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> user = (List<User1>) user1Repository.findUser1ByName("김유신");
        System.out.println(user);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("김유신");
        System.out.println(users);
    }


    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a101", "김춘추");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> users = user1Repository.findUser1ByUidOrName("a101", "박준우");
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void selelctUser1UnderAge30() {
    }

    @Test
    void selelctUser1WhereName() {
    }

    @Test
    void selectUser1WhereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");
        System.out.println(list.toString());

        for (Object[] obj : list) {
            Parent parent = (Parent) obj[0];
            Child child = obj.length > 1 ? (Child) obj[1] : null;  // Null 체크

            System.out.println(parent);

            if (child != null) {
                System.out.println(child);
            } else {
                System.out.println("No child associated with this parent.");
            }
        }
    }

}