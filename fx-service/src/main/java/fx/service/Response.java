package fx.service;

/**
 * Simple class to determining response of http-server object
 */
public class Response {
    private int code;
    /**
     * returning code
     */
    private String message;
    /**
     * message
     */
    private String body;

    /**
     * the body of response (if present)
     */

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "Code: " + getCode() + "\nMessage: " + getMessage() + "\nBody: " + getBody();

    }
}
