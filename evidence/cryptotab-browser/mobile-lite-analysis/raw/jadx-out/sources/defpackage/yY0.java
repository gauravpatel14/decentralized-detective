package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yY0 {
    public static final xY0 a;
    public static final xY0 b;

    static {
        xY0 xy0 = null;
        try {
            xy0 = (xY0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = xy0;
        b = new xY0();
    }
}
