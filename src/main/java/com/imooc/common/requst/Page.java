package com.imooc.common.requst;

/**
 * @author kun.wang
 * @date 2018/9/19
 */
public class Page {

    /**
     * 页面显示数量
     */
    private Integer rows;

    /**
     * 当前页数
     */
    private Integer page;

    public PageModel toPageModel() {
        PageModel pageModel = new PageModel();
        pageModel.setCurrentPage(page);
        pageModel.setPageSize(rows);
        return pageModel;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
