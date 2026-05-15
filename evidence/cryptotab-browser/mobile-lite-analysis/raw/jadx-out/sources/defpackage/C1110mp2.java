package defpackage;

/* JADX INFO: renamed from: mp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1110mp2 extends AbstractC1293pp2 {
    public boolean a = false;
    public int b = 0;
    public final /* synthetic */ C1173np2 c;

    public C1110mp2(C1173np2 c1173np2) {
        this.c = c1173np2;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void a() {
        int i = this.b + 1;
        this.b = i;
        C1173np2 c1173np2 = this.c;
        if (i == c1173np2.a.size()) {
            AbstractC1293pp2 abstractC1293pp2 = c1173np2.d;
            if (abstractC1293pp2 != null) {
                abstractC1293pp2.a();
            }
            this.b = 0;
            this.a = false;
            c1173np2.e = false;
        }
    }

    @Override // defpackage.AbstractC1293pp2, defpackage.InterfaceC1236op2
    public final void c() {
        if (this.a) {
            return;
        }
        this.a = true;
        AbstractC1293pp2 abstractC1293pp2 = this.c.d;
        if (abstractC1293pp2 != null) {
            abstractC1293pp2.c();
        }
    }
}
