package cn.mycode.ssm.domain;

import java.util.List;

//泛型
public class PageResult <T>{
    //从页面传入
    private  int currentPage;
    private  int pageSize;
    //查询数据库
    private int totalCount;//数据总条数
    private List<T> data;//每页显示的结果集
    //计算的数据
    private int totalPage;
    private int prevPage;
    private int nextPage;

    //计算
    public PageResult(int currentPage, int pageSize, int totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;

        //this.totalPage=this.totalCount % this.pageSize=0?this.totalCount % this.pageSize:1;
        if(this.totalCount%this.pageSize==0){
            this.totalPage=this.totalCount/this.pageSize;
        }else{
            this.totalPage=this.totalCount/this.pageSize+1;
        }

        if(this.currentPage-1>=1){
            this.prevPage=this.currentPage-1;
        }else{
            this.prevPage=1;
        }

        if(this.currentPage+1<=this.totalPage){
            this.nextPage=this.currentPage+1;
        }else{
            this.nextPage=this.totalPage;
        }

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
