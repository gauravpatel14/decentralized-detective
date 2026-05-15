package defpackage;

/* JADX INFO: renamed from: rH0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1374rH0 extends AbstractC1435sH0 implements InterfaceC0564eF0 {
    public final InterfaceC0762hF0 x;
    public final /* synthetic */ AbstractC1493tH0 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1374rH0(AbstractC1493tH0 abstractC1493tH0, InterfaceC0762hF0 interfaceC0762hF0, K21 k21) {
        super(abstractC1493tH0, k21);
        this.y = abstractC1493tH0;
        this.x = interfaceC0762hF0;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        InterfaceC0762hF0 interfaceC0762hF02 = this.x;
        cF0 cf0 = ((C0886jF0) interfaceC0762hF02.getLifecycle()).c;
        if (cf0 == cF0.t) {
            this.y.g(this.t);
            return;
        }
        cF0 cf02 = null;
        while (cf02 != cf0) {
            d(g());
            cf02 = cf0;
            cf0 = ((C0886jF0) interfaceC0762hF02.getLifecycle()).c;
        }
    }

    @Override // defpackage.AbstractC1435sH0
    public final void e() {
        this.x.getLifecycle().b(this);
    }

    @Override // defpackage.AbstractC1435sH0
    public final boolean f(InterfaceC0762hF0 interfaceC0762hF0) {
        return this.x == interfaceC0762hF0;
    }

    @Override // defpackage.AbstractC1435sH0
    public final boolean g() {
        return ((C0886jF0) this.x.getLifecycle()).c.a(cF0.w);
    }
}
