package priv.lyq.springboot.multipleds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.multipleds.datasource.Database;
import priv.lyq.springboot.multipleds.datasource.DatabaseContextHolder;
import priv.lyq.springboot.multipleds.entity.User;
import priv.lyq.springboot.multipleds.mapper.DemoMapper;
import priv.lyq.springboot.multipleds.service.DemoService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Yuqing Li
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    @Resource
    private DemoMapper demoMapper;

    @Resource
    private DemoService demoService;

    @GetMapping("demo")
    public User user(@RequestParam Map<String, String> map) {
        String site = map.get("site").toUpperCase();
        Database database = Database.valueOf(site);
        Database databaseLocale = DatabaseContextHolder.getDatabase();
        log.info(database.name());
        log.info(databaseLocale.name());
        if (databaseLocale == database) {
            log.info("数据库一致");
        }
        if (database != Database.NARCOS_1) {
            DatabaseContextHolder.setDatabase(database);
        }
        return demoMapper.getUserById(1L);
    }

    @GetMapping("insert")
    public void insert() {
        User user = new User();
        user.setName("火焰刀");
        demoService.insertUser(user);
        DatabaseContextHolder.setDatabase(Database.NARCOS_2);
        user.setName("多罗叶指");
        demoService.insertUser(user, "");
    }

}

