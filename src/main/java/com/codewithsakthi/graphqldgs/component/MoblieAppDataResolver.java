package com.codewithsakthi.graphqldgs.component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.codewithsakthi.graphqldgs.codegen.types.Author;
import com.codewithsakthi.graphqldgs.codegen.types.Hello;
import com.codewithsakthi.graphqldgs.codegen.types.HelloUnionMobilapp;
import com.codewithsakthi.graphqldgs.codegen.types.MobileApp;
import com.codewithsakthi.graphqldgs.codegen.types.MobileAppFilter;
import com.codewithsakthi.graphqldgs.codegen.types.osType;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DgsComponent
public class MoblieAppDataResolver {

    static boolean temp = true;
    
    @DgsQuery
    public List<MobileApp> mobileApps(@InputArgument MobileAppFilter mobileAppFilter) {
        log.info("Request is " + mobileAppFilter);
        return Arrays.asList(MobileApp.newBuilder().appId("test").name("somenamee").author(Author.newBuilder().name("authorName").age(10).build())
                .platform(Arrays.asList(osType.ANDROID, osType.IOS))
                .version("10").releaseDate(LocalDate.now())
                .build());
    }

    @DgsQuery
    public HelloUnionMobilapp testUnion(){
        temp=!temp;
        if(temp){
            return MobileApp.newBuilder().version("123").build();
        }
        return Hello.newBuilder().text("test").build();
    }

}
