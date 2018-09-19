package com.imooc.common.requst;

/**
 * @author kun.wang
 * @date 2018/9/19
 */
public class PageModel {
    private Integer pageSize = 10;

    private Integer currentPage = 1;

    private Integer startIndex;

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
        setStartIndex();
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }

        setStartIndex();
    }
}
