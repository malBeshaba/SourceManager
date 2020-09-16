package com.example.demo;

public class JsonResult<T> {
    private T data;
    private int code;
    private String msg;

    /**
     *无数据返回 默认状态码为1 提示信息为“success”
     */
    public JsonResult(){
        this.code=0;
        this.msg="success";
    }

    /**
     *无数据返回 默认状态码为1 人为设定提示信息
     */
    public JsonResult(String msg){
        this.code=0;
        this.msg=msg;
    }

    /**
     *有数据返回 默认状态码为1 提示信息为“success”
     */
    public JsonResult(T data){
        this.code=0;
        this.msg="success";
        this.data=data;
    }

    /**
     *有数据返回 人为设定状态码与提示信息
     */
    public JsonResult(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
