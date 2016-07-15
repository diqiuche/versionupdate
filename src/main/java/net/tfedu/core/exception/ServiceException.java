package net.tfedu.core.exception;

public class ServiceException extends Exception{
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public ServiceException(){
        super("service层异常");
    }
    
    public ServiceException(String msg){
        super(msg);
    }
    
    public ServiceException(Exception e){
        super("service层异常",e);
    }
    
    public ServiceException(String msg , Exception e){
        super(msg,e);
    }
}
