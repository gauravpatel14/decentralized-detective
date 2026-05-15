package defpackage;

import kotlinx.coroutines.channels.ClosedReceiveChannelException;

/* JADX INFO: renamed from: m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1059m extends PI0 implements InterfaceC0805hr1 {
    public final C1703wx w;

    public C1059m(C1703wx c1703wx) {
        this.w = c1703wx;
    }

    @Override // defpackage.InterfaceC0805hr1
    public final eT1 b(Object obj) {
        if (this.w.w(w(obj), obj) == null) {
            return null;
        }
        return xx.a;
    }

    @Override // defpackage.InterfaceC0805hr1
    public final /* bridge */ /* synthetic */ Object e() {
        return r.b;
    }

    @Override // defpackage.InterfaceC0805hr1
    public final void g() {
        C1703wx c1703wx = this.w;
        c1703wx.m(c1703wx.v);
    }

    @Override // defpackage.PI0
    public final String toString() {
        return "ReceiveElement@" + hV.a(this) + "[receiveMode=0]";
    }

    public InterfaceC0926jk0 w(Object obj) {
        return null;
    }

    public final void x(C1433sG c1433sG) {
        C1703wx c1703wx = this.w;
        Throwable closedReceiveChannelException = c1433sG.w;
        if (closedReceiveChannelException == null) {
            closedReceiveChannelException = new ClosedReceiveChannelException("Channel was closed");
        }
        c1703wx.d(new Zv1(closedReceiveChannelException));
    }
}
