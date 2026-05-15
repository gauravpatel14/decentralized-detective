package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A3 extends AbstractViewOnTouchListenerC0044Dh0 {
    public final /* synthetic */ B3 C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A3(B3 b3, B3 b32) {
        super(b32);
        this.C = b3;
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final nI1 b() {
        C1710x3 c1710x3 = this.C.w.L;
        if (c1710x3 == null) {
            return null;
        }
        return c1710x3.a();
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final boolean c() {
        this.C.w.l();
        return true;
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final boolean d() {
        C3 c3 = this.C.w;
        if (c3.N != null) {
            return false;
        }
        c3.g();
        return true;
    }
}
