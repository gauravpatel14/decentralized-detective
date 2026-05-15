package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BE0 {
    public static final void a(AbstractC1867zo2 abstractC1867zo2, tz1 tz1Var, AbstractC0514dF0 abstractC0514dF0) {
        AutoCloseable autoCloseable;
        boolean z;
        C0005Ao2 c0005Ao2 = abstractC1867zo2.a;
        if (c0005Ao2 != null) {
            synchronized (c0005Ao2.a) {
                autoCloseable = (AutoCloseable) c0005Ao2.b.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        jz1 jz1Var = (jz1) autoCloseable;
        if (jz1Var == null || (z = jz1Var.v)) {
            return;
        }
        if (z) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        jz1Var.v = true;
        abstractC0514dF0.a(jz1Var);
        tz1Var.c(jz1Var.t, jz1Var.u.e);
        cF0 cf0 = ((C0886jF0) abstractC0514dF0).c;
        if (cf0 == cF0.u || cf0.a(cF0.w)) {
            tz1Var.d();
        } else {
            abstractC0514dF0.a(new AE0(abstractC0514dF0, tz1Var));
        }
    }
}
