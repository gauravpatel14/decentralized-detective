package defpackage;

import android.app.Notification;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: wW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1681wW0 implements InterfaceC1692wm {
    public final /* synthetic */ Cm a;

    public C1681wW0(Cm cm) {
        this.a = cm;
    }

    @Override // defpackage.InterfaceC1692wm
    public final void a(final boolean z) {
        final Cm cm = this.a;
        PostTask.d(7, new Runnable() { // from class: uW0
            @Override // java.lang.Runnable
            public final void run() {
                cm.a(z);
            }
        });
    }

    @Override // defpackage.InterfaceC1692wm
    public final void b(final int i, final Notification notification) {
        final Cm cm = this.a;
        PostTask.d(7, new Runnable() { // from class: vW0
            @Override // java.lang.Runnable
            public final void run() {
                cm.b(i, notification);
            }
        });
    }
}
