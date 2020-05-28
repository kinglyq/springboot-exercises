package priv.lyq.springboot.multipleds.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import priv.lyq.springboot.multipleds.entity.User;
import priv.lyq.springboot.multipleds.mapper.DemoMapper;
import priv.lyq.springboot.multipleds.service.DemoService;

import javax.annotation.Resource;

/**
 * @author: Yuqing Li
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        int i;
        try {
            i = demoMapper.insertUser(user);
            // int r = 1 / 0;
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user, String s) {
        int i;
        try {
            i = demoMapper.insertUser(user);
            int r = 1 / 0;
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return i;
    }

}
