package net.tfedu.core.exception;

/**
 * 卡号绑定时的异常
 * @author wangwr
 *
 */
public class CardBindErrorExcepion extends CustomException {

	public CardBindErrorExcepion() {
		super("CardBindError","卡号信息异常");
	}

	public CardBindErrorExcepion(String msg) {
		super("CardBindError",msg);
	}

}
