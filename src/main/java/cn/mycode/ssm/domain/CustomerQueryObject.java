package cn.mycode.ssm.domain;

public class CustomerQueryObject extends QueryObject{
    private String keyword;
    private Long sellerID;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }
}
