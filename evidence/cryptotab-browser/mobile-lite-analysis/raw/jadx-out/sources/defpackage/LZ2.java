package defpackage;

import java.io.PrintStream;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LZ2 {
    public static final AbstractC0584eU2 a;

    static {
        AbstractC0584eU2 c1741xY2;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(printStream);
            }
            c1741xY2 = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new C1683wX2() : new C1741xY2() : new C0537dZ2();
        } catch (Throwable th) {
            PrintStream printStream2 = System.err;
            String name = C1741xY2.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream2.println(sb.toString());
            th.printStackTrace(printStream2);
            c1741xY2 = new C1741xY2();
        }
        a = c1741xY2;
    }
}
