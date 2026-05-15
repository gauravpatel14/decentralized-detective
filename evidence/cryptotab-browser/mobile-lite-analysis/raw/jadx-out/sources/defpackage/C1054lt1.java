package defpackage;

import org.chromium.base.ApplicationStatus;

/* JADX INFO: renamed from: lt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1054lt1 extends iY0 implements Td {
    public boolean u;

    @Override // defpackage.iY0
    public final void a() {
        if (this.u) {
            return;
        }
        ApplicationStatus.l(this);
        this.u = true;
    }

    @Override // defpackage.iY0
    public final void b(C0908jY0 c0908jY0) {
        this.t = c0908jY0;
        ApplicationStatus.g(this);
        q(0);
    }

    @Override // defpackage.Td
    public final void q(int i) {
        if (ApplicationStatus.hasVisibleActivities()) {
            c();
        } else {
            this.t.h();
        }
    }
}
