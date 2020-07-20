package priv.lyq.springboot.datasource.mapper;

import priv.lyq.springboot.datasource.entity.MultipleTest;

import java.util.List;

/**
 * @author Li Yuqing
 */
public interface MultipleTestMapper {

    /**
     * 查询多条记录
     *
     * @return List<MultipleTest>
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
