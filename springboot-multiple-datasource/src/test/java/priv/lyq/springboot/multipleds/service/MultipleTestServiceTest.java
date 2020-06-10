package priv.lyq.springboot.multipleds.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import priv.lyq.springboot.multipleds.entity.MultipleTest;

import javax.annotation.Resource;

@SpringBootTest
class MultipleTestServiceTest {

    @Resource
    private MultipleTestService multipleTestService;

    @Test
    void selectMultipleTest() {
    }

    @Test
    void insertMultipleTest() {
        MultipleTest m = new MultipleTest();
        m.setName("陆小凤");
        multipleTestService.insertMultipleTest(m);
    }
}