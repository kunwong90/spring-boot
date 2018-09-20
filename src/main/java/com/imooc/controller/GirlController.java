package com.imooc.controller;

import com.imooc.common.response.LayuiResponse;
import com.imooc.common.response.PageResponse;
import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.reposiitory.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by wangkun on 2016/12/15.
 */
@RequestMapping
@Controller
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    @ResponseBody
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    @ResponseBody
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }


    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    @ResponseBody
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    @DeleteMapping(value = "/girls/{id}")
    @ResponseBody
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 更新
     */
    @PutMapping(value = "/girls/{id}")
    @ResponseBody
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRepository.save(girl);

    }


    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    @ResponseBody
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }


    @PostMapping(value = "/girls/two")
    @ResponseBody
    public void girlAddTwo() {
        girlService.insertTwo();
    }


    @RequestMapping(value = "girls/getAge/{id}")
    @ResponseBody
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    @GetMapping(value = "/jsp")
    public String indexJsp() {
        return "index";
    }

    @ResponseBody
    @PostMapping(value = "/getPageList")
    public PageResponse<Girl> getPageList(Girl girl) {
        return girlService.getGrilPageList(girl);
    }

    @GetMapping(value = "/layui")
    public String layui() {
        return "layui";
    }


    @PostMapping(value = "/layuiData")
    @ResponseBody
    public LayuiResponse<Girl> getGirlPageList(Girl girl) {
        return new LayuiResponse<>(girlService.getGrilPageList(girl).getRows(), girlService.getGrilPageList(girl).getTotal());
    }


}
