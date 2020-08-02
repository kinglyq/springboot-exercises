package top.funsite.springboot.datasource.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.funsite.springboot.datasource.entity.MultipleTest;

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