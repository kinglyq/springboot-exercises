package priv.lyq.springboot.multipleds.mapper;

import priv.lyq.springboot.multipleds.entity.MultipleTest;

import java.util.List;

/**
 * @author Yuqing Li
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
