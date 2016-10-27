package org.nero.click.dto;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:14.
 */
public class Operate<T> {
    private boolean state;
    private String msg;
    private T data;

    public Operate() {
    }

    public Operate(boolean state, String msg, T data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Operate(boolean state, T data) {
        this.state = state;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Operate{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
