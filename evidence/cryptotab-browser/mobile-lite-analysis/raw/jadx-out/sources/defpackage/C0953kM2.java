package defpackage;

/* JADX INFO: renamed from: kM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0953kM2 extends AbstractC1441sM2 {
    public final transient int v;
    public final transient int w;
    public final /* synthetic */ AbstractC1441sM2 x;

    public C0953kM2(AbstractC1441sM2 abstractC1441sM2, int i, int i2) {
        this.x = abstractC1441sM2;
        this.v = i;
        this.w = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        RL2.a(i, this.w);
        return this.x.get(i + this.v);
    }

    @Override // defpackage.AbstractC0462cM2
    public final int i() {
        return this.x.j() + this.v + this.w;
    }

    @Override // defpackage.AbstractC0462cM2
    public final int j() {
        return this.x.j() + this.v;
    }

    @Override // defpackage.AbstractC0462cM2
    public final boolean l() {
        return true;
    }

    @Override // defpackage.AbstractC0462cM2
    public final Object[] p() {
        return this.x.p();
    }

    @Override // defpackage.AbstractC1441sM2, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final AbstractC1441sM2 subList(int i, int i2) {
        RL2.b(i, i2, this.w);
        int i3 = this.v;
        return this.x.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }
}
