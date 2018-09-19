package com.imooc.mapper;

import com.imooc.domain.Girl;

/**
 * @author kun.wang
 * @date 2018/9/19
 */
public interface GirlMapper {

    /**
     *
     * @param id
     * @return
     */
    Girl selectById(Integer id);
}
