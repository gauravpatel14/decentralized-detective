package defpackage;

import org.chromium.base.ThreadUtils;

/* JADX INFO: renamed from: sj2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1464sj2 extends X62 implements IK1 {
    @Override // defpackage.IK1
    public final boolean a() {
        return ThreadUtils.f();
    }

    @Override // defpackage.X62
    public final boolean h(Runnable runnable, long j) {
        ThreadUtils.b().postDelayed(runnable, j);
        return true;
    }

    @Override // defpackage.X62
    public final void i() {
        ThreadUtils.b().post(this.e);
    }
}
