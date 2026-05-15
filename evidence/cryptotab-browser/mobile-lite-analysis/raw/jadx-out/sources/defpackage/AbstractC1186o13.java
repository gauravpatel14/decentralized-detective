package defpackage;

import java.io.PrintStream;

/* JADX INFO: renamed from: o13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1186o13 {
    public static final S13 a;

    static {
        S13 c0681g13;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(printStream);
            }
            c0681g13 = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new H23() : new C0681g13() : new W23();
        } catch (Throwable th) {
            PrintStream printStream2 = System.err;
            String name = C0681g13.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream2.println(sb.toString());
            th.printStackTrace(printStream2);
            c0681g13 = new C0681g13();
        }
        a = c0681g13;
    }
}
