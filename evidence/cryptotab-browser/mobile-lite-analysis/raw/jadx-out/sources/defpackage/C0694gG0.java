package defpackage;

import java.util.List;

/* JADX INFO: renamed from: gG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0694gG0 extends AbstractC0764hG0 {
    @Override // defpackage.AbstractC0764hG0
    public final void a(long j, Object obj) {
        ((E) ((fz0) AbstractC1633vk2.b.k(j, obj))).t = false;
    }

    @Override // defpackage.AbstractC0764hG0
    public final void b(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02, long j) {
        AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
        fz0 fz0VarY = (fz0) abstractC1577uk2.k(j, abstractC0003Al0);
        fz0 fz0Var = (fz0) abstractC1577uk2.k(j, abstractC0003Al02);
        int size = fz0VarY.size();
        int size2 = fz0Var.size();
        if (size > 0 && size2 > 0) {
            if (!((E) fz0VarY).t) {
                fz0VarY = fz0VarY.Y(size2 + size);
            }
            fz0VarY.addAll(fz0Var);
        }
        if (size > 0) {
            fz0Var = fz0VarY;
        }
        AbstractC1633vk2.u(j, abstractC0003Al0, fz0Var);
    }

    @Override // defpackage.AbstractC0764hG0
    public final List c(long j, Object obj) {
        fz0 fz0Var = (fz0) AbstractC1633vk2.b.k(j, obj);
        if (((E) fz0Var).t) {
            return fz0Var;
        }
        int size = fz0Var.size();
        fz0 fz0VarY = fz0Var.Y(size == 0 ? 10 : size * 2);
        AbstractC1633vk2.u(j, obj, fz0VarY);
        return fz0VarY;
    }
}
