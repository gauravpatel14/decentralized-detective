package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cf extends AbstractC0295Xv0 {
    public final /* synthetic */ int w;
    public final /* synthetic */ gf x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(gf gfVar, int i) {
        super(gfVar.v);
        this.w = i;
        switch (i) {
            case 1:
                this.x = gfVar;
                super(gfVar.v);
                break;
            default:
                this.x = gfVar;
                break;
        }
    }

    @Override // defpackage.AbstractC0295Xv0
    public final Object a(int i) {
        switch (this.w) {
            case 0:
                return this.x.f(i);
            default:
                return this.x.i(i);
        }
    }

    @Override // defpackage.AbstractC0295Xv0
    public final void b(int i) {
        switch (this.w) {
            case 0:
                this.x.g(i);
                break;
            default:
                this.x.g(i);
                break;
        }
    }
}
