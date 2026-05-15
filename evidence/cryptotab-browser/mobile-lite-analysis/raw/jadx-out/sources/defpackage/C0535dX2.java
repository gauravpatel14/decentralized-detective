package defpackage;

/* JADX INFO: renamed from: dX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0535dX2 extends AbstractC0716gX2 {
    @Override // defpackage.AbstractC0716gX2
    public final void a(long j, Object obj) {
        ((EU2) ((LW2) NY2.c.m(j, obj))).t = false;
    }

    @Override // defpackage.AbstractC0716gX2
    public final void b(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22, long j) {
        MY2 my2 = NY2.c;
        LW2 lw2C = (LW2) my2.m(j, abstractC1852zW2);
        LW2 lw2 = (LW2) my2.m(j, abstractC1852zW22);
        int size = lw2C.size();
        int size2 = lw2.size();
        if (size > 0 && size2 > 0) {
            if (!((EU2) lw2C).t) {
                lw2C = lw2C.c(size2 + size);
            }
            lw2C.addAll(lw2);
        }
        if (size > 0) {
            lw2 = lw2C;
        }
        NY2.o(j, abstractC1852zW2, lw2);
    }
}
