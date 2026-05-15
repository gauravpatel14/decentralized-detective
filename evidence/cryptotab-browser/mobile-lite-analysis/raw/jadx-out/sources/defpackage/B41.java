package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class B41 extends RC0 implements InterfaceC0798hk0 {
    public final /* synthetic */ int u;
    public final /* synthetic */ J41 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ B41(J41 j41, int i) {
        super(0);
        this.u = i;
        this.v = j41;
    }

    @Override // defpackage.InterfaceC0798hk0
    public final Object c() {
        switch (this.u) {
            case 0:
                this.v.d();
                break;
            case 1:
                this.v.c();
                break;
            default:
                this.v.d();
                break;
        }
        return C0302Yj2.a;
    }
}
