package priv.lyq.springboot.datasource.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import priv.lyq.springboot.datasource.datasource.Database;
import priv.lyq.springboot.datasource.datasource.DatabaseContextHolder;
import priv.lyq.springboot.datasource.entity.MultipleTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MultipleTestMapperTest {

    @Resource
    private MultipleTestMapper multipleTestMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void selectMultipleTest() {
        List<MultipleTest> multipleTests1 = multipleTestMapper.selectMultipleTest();
        multipleTests1.forEach(System.out::println);
        // DatabaseContextHolder.setDatabase(Database.NARCOS_2);
        DatabaseContextHolder.clear();
        multipleTests1 = multipleTestMapper.selectMultipleTest();
        multipleTests1.forEach(System.out::println);
    }

    @Test
    void insertMultipleTest() {
        MultipleTest m = new MultipleTest();
        // DatabaseContextHolder.clear();
        DatabaseContextHolder.setDatabase(Database.NARCOS_2);
        m.setName("陆小鸡");
        multipleTestMapper.insertMultipleTest(m);
    }

    @Test
    void jdbcTemplateTest() {
        String sql = "select * from multiple_test";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(System.out::println);
        DatabaseContextHolder.setDatabase(Database.NARCOS_2);
        maps = jdbcTemplate.queryForList(sql);
        maps.forEach(System.out::println);
    }
}