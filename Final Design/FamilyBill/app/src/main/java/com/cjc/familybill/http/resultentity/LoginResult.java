package com.cjc.familybill.http.resultentity;

/**
 * Created by CC
 **/
public class LoginResult {

    @Override
    public String toString() {
        return "LoginResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * status : 0
     * msg : 用户名和密码正确
     * data : {"member_id":35,"uname":"123456","password":"4QrcOUm6Wau+VuBX8g+IPg==","email":"123456@qq.com","sex":0,"mobile":"","regtime":1598250411000,"lastlogin":1598250428000,"image":"","memberAddresses":null}
     */


    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "member_id=" + member_id +
                    ", uname='" + uname + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", sex=" + sex +
                    ", mobile='" + mobile + '\'' +
                    ", regtime=" + regtime +
                    ", lastlogin=" + lastlogin +
                    ", image='" + image + '\'' +
                    ", memberAddresses=" + memberAddresses +
                    '}';
        }

        /**
         * member_id : 35
         * uname : 123456
         * password : 4QrcOUm6Wau+VuBX8g+IPg==
         * email : 123456@qq.com
         * sex : 0
         * mobile :
         * regtime : 1598250411000
         * lastlogin : 1598250428000
         * image :
         * memberAddresses : null
         */



        private int member_id;
        private String uname;
        private String password;
        private String email;
        private int sex;
        private String mobile;
        private String regtime;
        private String lastlogin;
        private String image;
        private Object memberAddresses;

        public int getMember_id() {
            return member_id;
        }

        public void setMember_id(int member_id) {
            this.member_id = member_id;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRegtime() {
            return regtime;
        }

        public void setRegtime(String regtime) {
            this.regtime = regtime;
        }

        public String getLastlogin() {
            return lastlogin;
        }

        public void setLastlogin(String lastlogin) {
            this.lastlogin = lastlogin;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Object getMemberAddresses() {
            return memberAddresses;
        }

        public void setMemberAddresses(Object memberAddresses) {
            this.memberAddresses = memberAddresses;
        }
    }
}
