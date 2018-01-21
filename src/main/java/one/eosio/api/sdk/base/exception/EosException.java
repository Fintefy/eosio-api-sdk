package one.eosio.api.sdk.base.exception;

/**
 * <p> EOS 异常类 </p>
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EosException extends RuntimeException {

    /**
     * 错误码
     */
    private long errCode;
    /**
     * 错误信息
     */
    private String errMsg;

    public EosException() {
        super();
    }

    public EosException(long errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public EosException(String message) {
        super(message);
    }

    public EosException(Throwable throwable) {
        super(throwable);
    }

    public EosException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
