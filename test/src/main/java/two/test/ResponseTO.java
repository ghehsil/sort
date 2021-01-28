package two.test;

import java.io.Serializable;

public class ResponseTO<T> implements Serializable{
	private static final long serialVersionUID = 8154889351783541876L;
	// -1 没有业务服务提供对象 0失败，200成功
	private String msgCode = "200"; 
	private String msg;
	private T data;

	public ResponseTO() {
	}

	public ResponseTO(String msgCode, String msg) {
		this.msgCode = msgCode;
		this.msg = msg;
	}

	public ResponseTO setResponse(String msgCode, String msg){
		this.msgCode = msgCode;
		this.msg = msg;
		return this;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
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

	public boolean isSuccess() {
		return "200".equals(msgCode);
	}
}
