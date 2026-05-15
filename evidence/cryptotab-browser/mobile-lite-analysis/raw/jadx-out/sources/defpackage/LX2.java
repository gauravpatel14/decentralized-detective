package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LX2 {
    public static final JX2 a;
    public static final JX2 b;

    static {
        JX2 jx2 = null;
        try {
            jx2 = (JX2) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = jx2;
        b = new JX2();
    }
}
