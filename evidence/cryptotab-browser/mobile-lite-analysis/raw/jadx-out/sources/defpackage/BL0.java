package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BL0 {
    public static final AL0 a;
    public static final AL0 b;

    static {
        AL0 al0 = null;
        try {
            al0 = (AL0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = al0;
        b = new AL0();
    }
}
