package defpackage;

/* JADX INFO: renamed from: q90, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1309q90 {
    public static final C1252p90 a = new C1252p90();
    public static final C1252p90 b;

    static {
        C1252p90 c1252p90 = null;
        try {
            c1252p90 = (C1252p90) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = c1252p90;
    }
}
