package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: Nz, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0168Nz extends SA0 {
    public final C1703wx x;

    public C0168Nz(C1703wx c1703wx) {
        this.x = c1703wx;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        x((Throwable) obj);
        return C0302Yj2.a;
    }

    @Override // defpackage.UA0
    public final void x(Throwable th) {
        L00 l00;
        YA0 ya0W = w();
        C1703wx c1703wx = this.x;
        c1703wx.getClass();
        CancellationException cancellationExceptionR = ya0W.r();
        if (!c1703wx.r() ? false : ((d00) c1703wx.w).k(cancellationExceptionR)) {
            return;
        }
        c1703wx.l(cancellationExceptionR);
        if (c1703wx.r() || (l00 = c1703wx.y) == null) {
            return;
        }
        l00.d();
        c1703wx.y = C1123n01.t;
    }
}
