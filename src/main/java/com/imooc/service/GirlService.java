package com.imooc.service;

import com.imooc.common.response.PageResponse;
import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.mapper.GirlMapper;
import com.imooc.reposiitory.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangkun on 2016/12/15.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlMapper girlMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(19);
        girlRepository.save(girlB);


    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlMapper.selectById(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public PageResponse<Girl> getGrilPageList(Girl girl) {
        int count = girlMapper.selectCount(girl);
        if (count == 0) {
            return new PageResponse<>();
        }
        List<Girl> girls = girlMapper.getGirlPageList(girl, girl.toPageModel());
        return new PageResponse<>(count, girls);
    }
}
