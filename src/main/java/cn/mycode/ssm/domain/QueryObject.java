package cn.mycode.ssm.domain;

public class QueryObject {
    private Integer currentPage=1;
    private Integer pageSize=2;

    private Integer startIndex;

   private Long sellerID;
    private String keyword;


    //数据库查询语句的起始值
    public Integer getStartIndex() {

        Integer result=null;
        if(this.currentPage!=null&&this.pageSize!=null){
            result= (this.currentPage-1)*this.pageSize;
        }
        return result;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
