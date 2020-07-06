package priv.lyq.springboot.datasource.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyq.springboot.datasource.entity.MultipleTest;
import priv.lyq.springboot.datasource.mapper.MultipleTestMapper;
import priv.lyq.springboot.datasource.service.MultipleTestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yuqing Li
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
        int r = 1 / 0;
        return i;
    }
}
