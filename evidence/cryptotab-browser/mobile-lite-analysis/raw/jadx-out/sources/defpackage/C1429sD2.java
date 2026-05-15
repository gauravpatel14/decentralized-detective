package defpackage;

/* JADX INFO: renamed from: sD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1429sD2 extends AD2 {
    public final transient int v;
    public final transient int w;
    public final /* synthetic */ AD2 x;

    public C1429sD2(AD2 ad2, int i, int i2) {
        this.x = ad2;
        this.v = i;
        this.w = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        YB2.a(i, this.w);
        return this.x.get(i + this.v);
    }

    @Override // defpackage.AbstractC0335aD2
    public final int i() {
        return this.x.j() + this.v + this.w;
    }

    @Override // defpackage.AbstractC0335aD2
    public final int j() {
        return this.x.j() + this.v;
    }

    @Override // defpackage.AbstractC0335aD2
    public final boolean p() {
        return true;
    }

    @Override // defpackage.AbstractC0335aD2
    public final Object[] s() {
        return this.x.s();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.w;
    }

    @Override // defpackage.AD2, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final AD2 subList(int i, int i2) {
        YB2.c(i, i2, this.w);
        int i3 = this.v;
        return this.x.subList(i + i3, i2 + i3);
    }
}
