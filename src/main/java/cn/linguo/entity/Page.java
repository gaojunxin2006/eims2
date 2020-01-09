package cn.linguo.entity;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：高俊欣
 * 日期：2020/1/8
 * 微信：15000952623
 **/


//分页实体

public class Page<T> implements Serializable {


    //起始记录
    private Integer start;

    //页面大小
    private Integer rows;

    //查询条件
    private String keyWord;

    //数据列表(不要写死)
    private List<T> pageList;

    //总记录数
    private Integer totalRecord;

    //当前页
    private Integer page;


    //查询条件2,任意类型，多条件
    private T paramEntity;


    //返回页面的map,包括total rows数据
    private Map<String,Object> pageMap=new HashMap<String, Object>(0);



    public Map<String, Object> getPageMap() {
        return pageMap;
    }



//    public void setPageMap(Map<String, Object> pageMap) {
//
//        this.pageMap = pageMap;
//    }




    public T getParamEntity() {
        return paramEntity;
    }

    public void setParamEntity(T paramEntity) {
        this.paramEntity = paramEntity;
    }

    //开始记录数 自己计算
    public Integer getStart() {

        start=(page-1)*rows;

        return start;


    }



    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        pageMap.put("rows",pageList);
        this.pageList = pageList;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        pageMap.put("total",totalRecord);
        this.totalRecord = totalRecord;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }




    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", rows=" + rows +
                ", keyWord='" + keyWord + '\'' +
                ", pageList=" + pageList +
                ", totalRecord=" + totalRecord +
                ", page=" + page +
                ", paramEntity=" + paramEntity +
                '}';
    }



}
