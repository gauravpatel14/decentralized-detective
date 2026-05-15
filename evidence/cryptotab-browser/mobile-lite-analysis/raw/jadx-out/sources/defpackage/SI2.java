package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SI2 {
    public static final OI2 a = new OI2();
    public static final OI2 b;

    static {
        OI2 oi2 = null;
        try {
            oi2 = (OI2) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = oi2;
    }
}
