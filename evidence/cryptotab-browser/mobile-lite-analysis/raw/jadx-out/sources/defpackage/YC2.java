package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YC2 extends AbstractC0760hD2 {
    public final transient int v;
    public final transient int w;
    public final /* synthetic */ AbstractC0760hD2 x;

    public YC2(AbstractC0760hD2 abstractC0760hD2, int i, int i2) {
        this.x = abstractC0760hD2;
        this.v = i;
        this.w = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f23.a(i, this.w);
        return this.x.get(i + this.v);
    }

    @Override // defpackage.AbstractC1543uC2
    public final int i() {
        return this.x.j() + this.v + this.w;
    }

    @Override // defpackage.AbstractC1543uC2
    public final int j() {
        return this.x.j() + this.v;
    }

    @Override // defpackage.AbstractC1543uC2
    public final boolean l() {
        return true;
    }

    @Override // defpackage.AbstractC1543uC2
    public final Object[] p() {
        return this.x.p();
    }

    @Override // defpackage.AbstractC0760hD2, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final AbstractC0760hD2 subList(int i, int i2) {
        f23.c(i, i2, this.w);
        int i3 = this.v;
        return this.x.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }
}
