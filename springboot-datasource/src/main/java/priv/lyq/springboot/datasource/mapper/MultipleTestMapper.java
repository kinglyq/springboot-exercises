package priv.lyq.springboot.datasource.mapper;

import priv.lyq.springboot.datasource.entity.MultipleTest;

import java.util.List;

/**
 * @author Li Yuqing
 * @date 2020-05-28 09:08:00
 */
public interface MultipleTestMapper {

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
