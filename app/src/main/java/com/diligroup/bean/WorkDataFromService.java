package com.diligroup.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class WorkDataFromService extends CommonBean{

    /**
     * list : [{"code":"15001","createTime":1,"dictName":"轻","id":1,"laborCode":"15001","priority":1,"profName":"1","status":"1"}]
     * totalCount : 0
     */

    private int totalCount;
    /**
     * code : 15001
     * createTime : 1
     * dictName : 轻
     * id : 1
     * laborCode : 15001
     * priority : 1
     * profName : 1
     * status : 1
     */

    public List<ListBean> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String code;
        private int createTime;
        private String dictName;
        private int id;
        private String laborCode;
        private int priority;
        private String profName;
        private String status;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictName(String dictName) {
            this.dictName = dictName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLaborCode() {
            return laborCode;
        }

        public void setLaborCode(String laborCode) {
            this.laborCode = laborCode;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getProfName() {
            return profName;
        }

        public void setProfName(String profName) {
            this.profName = profName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
