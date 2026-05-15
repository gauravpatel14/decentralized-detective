package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Uu1 implements Callback {
    public Callback t;

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        this.t.a0(obj);
        int i = AbstractC1872zv.a;
        this.t = null;
    }
}
