//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileToStr {
    private static final int EOF = -1;

    public FileToStr() {
    }

    public static String read(String var0) {
        try {
            BufferedInputStream var1 = new BufferedInputStream(new FileInputStream(var0));
            StringBuffer var2 = new StringBuffer(var1.available());

            for(int var3 = var1.read(); var3 != -1; var3 = var1.read()) {
                var2.append((char)var3);
            }

            var1.close();
            return var2.toString();
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
            return "";
        } catch (IOException var5) {
            var5.printStackTrace();
            return "";
        }
    }
}
