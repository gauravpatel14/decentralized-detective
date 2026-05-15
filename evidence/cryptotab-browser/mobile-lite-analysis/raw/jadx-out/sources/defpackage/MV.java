package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MV {
    public static final DW a;

    static {
        String property;
        C1636vn0 c1636vn0;
        int i = AbstractC1563uU1.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            C0649fW c0649fW = j00.a;
            C1636vn0 c1636vn02 = AbstractC0571eK0.a;
            C1636vn0 c1636vn03 = c1636vn02.x;
            c1636vn0 = !(c1636vn02 instanceof DW) ? LV.A : c1636vn02;
        } else {
            c1636vn0 = LV.A;
        }
        a = c1636vn0;
    }
}
