package pattern.prototype.first;

import java.util.Random;

/**
 * 单线程发送太慢，多线程也不安全
 * @author MayZhou
 */
public class Client {
    private static final int MAX_COUNT = 6;

    public static void main(String[] args) {
        int i = 0;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("xx银行所有");
        while (i < MAX_COUNT) {
            mail.setApplication(getRandSubject(5) + "先生（女士）");
            mail.setReceiver(getRandSubject(5) + "@" + getRandSubject(8) + ".com");
            sendMail(mail);
            i++;
        }
    }

    private static void sendMail(Mail mail) {
        System.out.printf("标题：%s\t收件人：%s\t...发送成功！%n", mail.getSubject(), mail.getReceiver());
    }

    private static String getRandSubject(int maxLength) {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
}
