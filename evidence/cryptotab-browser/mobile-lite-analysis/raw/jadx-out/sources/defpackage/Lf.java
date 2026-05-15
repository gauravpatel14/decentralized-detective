package defpackage;

import android.os.Handler;
import android.os.Message;
import org.chromium.ui.AsyncViewStub;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Lf implements Handler.Callback {
    public final /* synthetic */ Qf t;

    public Lf(Qf qf) {
        this.t = qf;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Nf nf = (Nf) message.obj;
        if (nf.e == null) {
            nf.e = nf.a.inflate(nf.d, nf.c, false);
        }
        Of of = this.t.c;
        ((AsyncViewStub) nf.f).a(nf.e, nf.c);
        of.getClass();
        nf.f = null;
        nf.a = null;
        nf.b = null;
        nf.c = null;
        nf.d = 0;
        nf.e = null;
        of.u.b(nf);
        return true;
    }
}
