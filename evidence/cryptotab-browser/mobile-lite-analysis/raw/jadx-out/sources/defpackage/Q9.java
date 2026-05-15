package defpackage;

import com.google.protobuf.UninitializedMessageException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Q9 {
    public static R9 a(BufferedReader bufferedReader) throws IOException {
        Pattern patternCompile = Pattern.compile("\"(.*)\".*prio=\\d+ tid=\\d+ \\w+");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            Matcher matcher = patternCompile.matcher(line);
            if (matcher.matches()) {
                sb4 = matcher.group(1).equals("main") ? sb2 : sb3;
            }
            sb4.append(line);
            sb4.append("\n");
        }
        R9 r9 = new R9();
        r9.e |= 1;
        r9.f = "Chrome_ANR_Cause";
        String string = sb.toString();
        string.getClass();
        r9.e |= 8;
        r9.i = string;
        String string2 = sb2.toString();
        string2.getClass();
        r9.e |= 4;
        r9.h = string2;
        String string3 = sb3.toString();
        string3.getClass();
        r9.e |= 2;
        r9.g = string3;
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        c0734gn1.a(R9.class).d(r9);
        if (AbstractC0003Al0.j(r9, true)) {
            return r9;
        }
        throw new UninitializedMessageException();
    }
}
