package com.platform.test.token;

import com.bonday.service.Application;
import com.bonday.service.security.token.TokenService;
import com.bonday.service.security.token.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yunge on 16/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
//@WebAppConfiguration   // 3
//@IntegrationTest("server.port:0")   // 4
public class TokenServiceTest {

    @Autowired
    TokenService tokenService; //5

    public static User user;

//    @Value("${local.server.port}")   // 6
//            int port;

    @Before
    public void setUp() {
        user = new User("hello", "world");
    }

    @Test
    public void generate() {
        String msg = tokenService.generateToken(user.toString());
        assert user.toString().equals(tokenService.getMessageFromToken(msg));
    }

    @Test
    @Ignore
    public void findAny() {
        Optional<String> str = Stream
                .generate(Math::random)
                .peek(System.out::println)
                .limit(100)
                .map(i -> i * 100)
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .findAny();
    }

    <T> List<T> copeList(List<T> list) {
        List<T> list1 = new ArrayList<>();
        Collections.copy(list1, list);
        list1.forEach(System.out::println);
        return list1;
    }

    public <T> List<List<T>> powerSet(List<T> list) {
        if (list.size() == 0) return new ArrayList<>();
        T lastItem = list.get(list.size() - 1);
        List<List<T>> n_1 = powerSet(copeList(list));
        List<List<T>> result = Stream.concat(n_1.stream().map(subList -> {
            List<T> listTemp = copeList(subList);
            listTemp.add(lastItem);
            return listTemp;
        }), n_1.stream()).collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }

    @Test
    @Ignore
    public void testPowerSet() {
        System.out.println("--------------------Begin Test -----------------------");
        List<Integer> testSource = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = powerSet(testSource);
        result.forEach(System.out::println);
        System.out.println("--------------------End Test-----------------------");
    }

    @Test
    @Ignore
    public void testConcat() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> intList2 = intList.stream().map(i -> i * 10).collect(Collectors.toList());
        Stream.concat(intList.stream(), intList2.stream()).peek(System.out::println).collect(Collectors.toList());
    }
}
