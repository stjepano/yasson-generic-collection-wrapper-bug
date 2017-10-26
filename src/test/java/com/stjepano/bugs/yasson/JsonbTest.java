package com.stjepano.bugs.yasson;

import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class JsonbTest {

    private Jsonb jsonb;

    @Before
    public void before() {
        jsonb = JsonbBuilder.create();
    }

    @Test
    public void shouldBeAbleToSerializeGenericCollectionWrapperWithEmptyList1() throws Exception {
        CollectionWrapper<String> collectionWrapper = new CollectionWrapper<>(Collections.emptyList());
        String json = jsonb.toJson(collectionWrapper);
        JSONAssert.assertEquals("{data:[]}", json, false);
    }

    @Test
    public void shouldBeAbleToSerializeGenericCollectionWrapperWithEmptyList2() throws Exception {
        CollectionWrapper<String> collectionWrapper = new CollectionWrapper<>(new ArrayList<>());
        String json = jsonb.toJson(collectionWrapper);
        JSONAssert.assertEquals("{data:[]}", json, false);
    }


    @Test
    public void shouldBeAbleToSerializeGenericCollectionWrapperWithSomeItems() throws Exception {
        CollectionWrapper<String> collectionWrapper = new CollectionWrapper<>(Arrays.asList("itemA", "itemB"));
        String json = jsonb.toJson(collectionWrapper);
        JSONAssert.assertEquals("{data:[\"itemA\",\"itemB\"]}", json, false);
    }

    @Test
    public void shouldBeAbleToSerializeGenericCollectionWrapperWithEmptyListAndProvidedTypeData1() throws Exception {
        // works with type data
        CollectionWrapper<String> collectionWrapper = new CollectionWrapper<>(Collections.emptyList());
        String json = jsonb.toJson(collectionWrapper, new CollectionWrapper<String>() {}.getClass().getGenericSuperclass());
        JSONAssert.assertEquals("{data:[]}", json, false);
    }

}
