package netty.f;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author litianwei 2016年12月13日
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.setUserId(100);
        info.setUserName("welcome to netty");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);

        os.writeObject(info);
        os.flush();
        os.close();

        byte[] b = bos.toByteArray();
        System.out.println("the jdk serializable length is : " + b.length);

        bos.close();

        System.out.println("--------");

        System.out.println("the byte array serializable length is : " + info.codeC().length);
    }
}
