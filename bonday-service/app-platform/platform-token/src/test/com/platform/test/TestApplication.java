package com.platform.test;


import org.junit.runner.RunWith;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Created by yunge on 16/4/1.
 */
// todo just for test, remove latter
@Deprecated
public class TestApplication {
    private Optional<String> s = Stream
            .generate(Math::random)
            .limit(100)
            .map(String::valueOf)
            .filter( s -> s.startsWith("1"))
            .findAny();
}
