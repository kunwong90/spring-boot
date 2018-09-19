package com.imooc.mapper;

import com.imooc.common.requst.Page;
import com.imooc.common.requst.PageModel;
import com.imooc.domain.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    Integer selectCount(@Param("girl") Girl girl);

    List<Girl> getGirlPageList(@Param("girl") Girl girl, @Param("page")PageModel pageModel);
}
