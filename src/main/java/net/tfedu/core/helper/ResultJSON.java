package net.tfedu.core.helper;

/**
 * 新的api标准 返回的json 对象
 * @author wangwr
 * JSON格式： { "code":"ok", "message":"", "data":"", "sign":"57edf4a22be3c955ac49da2e2107b67a" }
 */
public class ResultJSON {

    /**
     * 成功或失败的编码
     */
    String code;

    /**
     * 失败的信息
     */
    String message;

    /**
     * 成功后返回的数据
     */
    Object data;

    /**
     * 签名字符串
     */
    String sign;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public ResultJSON(){
        super();
    }
    
    public ResultJSON(String code, String message, Object data, String sign) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.sign = sign;
    }

    
    /**
     * 返回成功
     * @param data
     * @return
     */
    public static ResultJSON getSuccess(Object data){
    	return new ResultJSON("OK", "成功", data==null?"":data, "");
    	
    }
    
    @Override
    public String toString() {
        return "[code :" + code + "  ;message:" + message + ";data:" + data.toString() + ";sign:" + sign + "]";
    }

}
