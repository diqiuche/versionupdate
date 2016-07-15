package net.tfedu.core.exception;

/**
 * 
 * verificationcode异常
 * @author wangwr
 *
 */
public class VerificationCodeExcepion extends CustomException {

	
	public VerificationCodeExcepion(){
		super("VerificationCodeErr", "验证码异常");
	}
	
	public VerificationCodeExcepion(String msg){
		super("VerificationCodeErr", msg);
	}
}
