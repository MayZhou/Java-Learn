package pattern.prototype.first;

/**
 * Mail就是一个业务对象
 * @author MayZhou
 */
public class Mail {
    /**
     * 收件人
     */
    private String receiver;

    /**
     * 邮件名称
     */
    private String subject;
    /**
     * 称为
     */
    private String application;

    /**
     * 邮件内容
     */
    private String context;

    /**
     * 邮件的尾部
     */
    private String tail;

    public Mail(AdvTemplate advTemplate) {
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
