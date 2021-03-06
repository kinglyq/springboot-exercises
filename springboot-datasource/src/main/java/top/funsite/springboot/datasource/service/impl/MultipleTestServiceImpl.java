package top.funsite.springboot.datasource.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.funsite.springboot.datasource.entity.MultipleTest;
import top.funsite.springboot.datasource.mapper.MultipleTestMapper;
import top.funsite.springboot.datasource.service.MultipleTestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li Yuqing
 * @date 2020-05-28 11:33:00
 */
@Slf4j
@Service
public class MultipleTestServiceImpl implements MultipleTestService {

    @Resource
    private MultipleTestMapper multipleTestMapper;

    // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

    @Override
    public List<MultipleTest> selectMultipleTest() {
        return multipleTestMapper.selectMultipleTest();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertMultipleTest(MultipleTest multipleTest) {
        int i = multipleTestMapper.insertMultipleTest(multipleTest);
        // int r = 1 / 0;
        return i;
    }
}
