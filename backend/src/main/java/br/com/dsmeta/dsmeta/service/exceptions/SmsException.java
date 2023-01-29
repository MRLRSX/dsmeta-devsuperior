package br.com.dsmeta.dsmeta.service.exceptions;

public class SmsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SmsException(String mgs){
        super(mgs);
    }
}
