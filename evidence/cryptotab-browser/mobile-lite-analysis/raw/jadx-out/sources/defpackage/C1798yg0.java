package defpackage;

/* JADX INFO: renamed from: yg0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1798yg0 implements InterfaceC0208Ri2 {
    public static final C1798yg0 a = new C1798yg0();

    @Override // defpackage.InterfaceC0208Ri2
    public final Object a(float f, Float f2, Float f3) {
        float fFloatValue = f2.floatValue();
        return Float.valueOf(((f3.floatValue() - fFloatValue) * f) + fFloatValue);
    }
}
