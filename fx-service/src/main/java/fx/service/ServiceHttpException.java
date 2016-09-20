package fx.service;

import org.apache.http.HttpException;

/**
 * This exception usually throwing, when server return error in the response
 */
public class ServiceHttpException extends HttpException {
    private int code;

    public ServiceHttpException() {
        super();
    }

    public ServiceHttpException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
