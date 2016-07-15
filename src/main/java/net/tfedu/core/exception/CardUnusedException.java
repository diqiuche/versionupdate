package net.tfedu.core.exception;

/**
 * 卡号尚未使用（绑定）异常
 * @author wangwr
 *
 */
public class CardUnusedException extends CustomException {
	
	
	public CardUnusedException() {
		super("CardUnused", "卡号尚未绑定使用");
	}

	
}
