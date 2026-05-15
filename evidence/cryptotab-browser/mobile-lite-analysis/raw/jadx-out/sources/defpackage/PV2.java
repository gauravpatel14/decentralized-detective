package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PV2 {
    public static final NV2 a = new NV2();
    public static final NV2 b;

    static {
        NV2 nv2 = null;
        try {
            nv2 = (NV2) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = nv2;
    }
}
