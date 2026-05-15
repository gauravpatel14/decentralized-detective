package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p80 extends AbstractC0771hO {
    public static final /* synthetic */ int x = 0;
    public long u;
    public boolean v;
    public C0792hf w;

    public void C(long j, m80 m80Var) {
        LV.A.P(j, m80Var);
    }

    @Override // defpackage.AbstractC0771hO
    public final AbstractC0771hO e(int i) {
        qF0.a(1);
        return this;
    }

    public final void k(boolean z) {
        long j = this.u - (z ? 4294967296L : 1L);
        this.u = j;
        if (j <= 0 && this.v) {
            shutdown();
        }
    }

    public final void n(g00 g00Var) {
        C0792hf c0792hf = this.w;
        if (c0792hf == null) {
            c0792hf = new C0792hf();
            c0792hf.a = new Object[16];
            this.w = c0792hf;
        }
        Object[] objArr = c0792hf.a;
        int i = c0792hf.c;
        objArr[i] = g00Var;
        int length = (objArr.length - 1) & (i + 1);
        c0792hf.c = length;
        int i2 = c0792hf.b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            AbstractC1229of.c(objArr, objArr2, 0, i2, 0, 10);
            Object[] objArr3 = c0792hf.a;
            int length3 = objArr3.length;
            int i3 = c0792hf.b;
            AbstractC1229of.c(objArr3, objArr2, length3 - i3, 0, i3, 4);
            c0792hf.a = objArr2;
            c0792hf.b = 0;
            c0792hf.c = length2;
        }
    }

    public abstract Thread s();

    public abstract void shutdown();

    public final void t(boolean z) {
        this.u = (z ? 4294967296L : 1L) + this.u;
        if (z) {
            return;
        }
        this.v = true;
    }

    public abstract long y();

    public final boolean z() throws IllegalAccessException, InvocationTargetException {
        C0792hf c0792hf = this.w;
        if (c0792hf == null) {
            return false;
        }
        int i = c0792hf.b;
        Object obj = null;
        if (i != c0792hf.c) {
            Object[] objArr = c0792hf.a;
            Object obj2 = objArr[i];
            objArr[i] = null;
            c0792hf.b = (i + 1) & (objArr.length - 1);
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
            }
            obj = obj2;
        }
        g00 g00Var = (g00) obj;
        if (g00Var == null) {
            return false;
        }
        g00Var.run();
        return true;
    }
}
