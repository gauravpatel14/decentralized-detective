package defpackage;

/* JADX INFO: renamed from: gd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0725gd2 extends AbstractC1293pp2 {
    public boolean a = false;
    public final /* synthetic */ int b;
    public final /* synthetic */ C0791hd2 c;

    public C0725gd2(C0791hd2 c0791hd2, int i) {
        this.c = c0791hd2;
        this.b = i;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void a() {
        if (this.a) {
            return;
        }
        this.c.a.setVisibility(this.b);
    }

    @Override // defpackage.AbstractC1293pp2, defpackage.InterfaceC1236op2
    public final void b() {
        this.a = true;
    }

    @Override // defpackage.AbstractC1293pp2, defpackage.InterfaceC1236op2
    public final void c() {
        this.c.a.setVisibility(0);
    }
}
