package netty.seven.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

/**
 * @author litianwei 2016年12月14日
 */
public class MessagePackAPI {

    public static void main(String[] args) throws IOException {
        List<String> src = new ArrayList<String>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");

        MessagePack messagePack = new MessagePack();

        //Serialize
        byte[] raw = messagePack.write(src);

        //Deserialize
        List<String> dst = messagePack.read(raw, Templates.tList(Templates.TString));

        System.out.println(dst.get(0));
        System.out.println(dst.get(1));
        System.out.println(dst.get(2));
    }
}
