import org.shark.example.Application;
import org.shark.example.service.base.pojo.BeanToMapExampleDto;
import org.shark.example.service.test.TestService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@RequiredArgsConstructor
public class BeanMapTest {


    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.start();
    }

    @Test
    public void testBeanMap() {
        List<BeanToMapExampleDto> exampleList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            BeanToMapExampleDto exampleDto = new BeanToMapExampleDto();
            exampleDto.setIntValue(i);
            exampleDto.setStrValue(String.valueOf(i));
            exampleList.add(exampleDto);
        }
        BeanToMapExampleDto example = new BeanToMapExampleDto();
        example.setIntValue(10);
        example.setStrValue("10");
        example.setExampleList(exampleList);
        System.out.println("example: " + new Gson().toJson(example));
        Map<String, Object> exampleMap = new HashMap<>();
        BeanMap beanMap = BeanMap.create(example);
        for (Object key : beanMap.keySet()) {
            exampleMap.put(key + "", beanMap.get(key));
        }

    }
}
