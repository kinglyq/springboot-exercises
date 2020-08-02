package top.funsite.springboot.datasource.service;

import top.funsite.springboot.datasource.entity.MultipleTest;

import java.util.List;

/**
 * @author Li Yuqing
 * @date 2020-05-28 09:20:00
 */
public interface MultipleTestService {

    /**
     * 查询多条记录
     *
     * @return List
     * @see MultipleTest
     */
    List<MultipleTest> selectMultipleTest();

    /**
     * 添加一条记录
     *
     * @param multipleTest multipleTest
     * @return multipleTest
     * @see MultipleTest
     */
    int insertMultipleTest(MultipleTest multipleTest);

}
