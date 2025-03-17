package com.codewithsakthi.graphqldgs.configuration.fake;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.codewithsakthi.graphqldgs.codegen.types.Hello;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;

@Configuration
@RequiredArgsConstructor
public class FakeDataSource {

    // private final Faker faker;

    public static List<Hello> HELLO_LIST = new ArrayList<>();

    @PostConstruct
    private void postConstruct(){
        for(int i=0;i<10;i++){
            var hello = Hello.newBuilder().randomNumber(i)
                .text("123"+i)
                .build();
            HELLO_LIST.add(hello);
        }
    }
    
}
