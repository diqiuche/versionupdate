package net.tfedu.core.exception;

public class LackOfSearchword extends CustomException{

	 /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public LackOfSearchword(){
    	super("LackOfSearchword","请输入检索词！");
    }
}
