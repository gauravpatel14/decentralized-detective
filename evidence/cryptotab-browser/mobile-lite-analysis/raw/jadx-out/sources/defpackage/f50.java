package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class f50 implements Callback {
    public final b50 t;
    public final Callback u;

    public f50(b50 b50Var, Callback callback) {
        this.t = b50Var;
        this.u = callback;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        this.u.a0((Zu1) obj);
        this.t.c(this);
    }
}
