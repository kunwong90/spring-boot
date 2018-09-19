package com.imooc.common.response;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kun.wang
 * @date 2018/9/19
 */
public class PageResponse<T> {

    /**
     * 总数
     */
    private Integer total;

    /**
     * 数据
     */
    private List<T> rows;

    public PageResponse() {
        this.rows = new ArrayList<>();
        this.total = 0;
    }

    public PageResponse(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
