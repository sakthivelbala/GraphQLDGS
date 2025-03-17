package com.codewithsakthi.graphqldgs.component.fake;

import java.util.List;

import com.codewithsakthi.graphqldgs.codegen.DgsConstants;
import com.codewithsakthi.graphqldgs.codegen.types.Hello;
import com.codewithsakthi.graphqldgs.configuration.fake.FakeDataSource;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class FakeHelloDataReslover {

    @DgsQuery
    public List<Hello> allHellos(){
        return FakeDataSource.HELLO_LIST;
    }

    @DgsQuery
    public Hello onHello(){
        return FakeDataSource.HELLO_LIST.get(1);
    }

    // @DgsData(parentType = DgsConstants.QUERY_TYPE, field = "getHelloByRandomNumber")
    // public Hello findById(@InputArgument("number") Integer id){
    //     return FakeDataSource.HELLO_LIST.parallelStream().filter(e->e.getRandomNumber()==id).findFirst().orElse(null);
    // }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = "getHelloByRandomNumber")
    public Hello findById(DataFetchingEnvironment dataFetchingEnvironment){
        Integer id = dataFetchingEnvironment.getArgument("number");
        return FakeDataSource.HELLO_LIST.parallelStream().filter(e->e.getRandomNumber()==id).findFirst().orElse(null);
    }
}
