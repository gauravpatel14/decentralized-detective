package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: vP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1617vP2 extends BroadcastReceiver {
    public final QX2 a;
    public boolean b;
    public boolean c;

    public C1617vP2(QX2 qx2) {
        Preconditions.checkNotNull(qx2);
        this.a = qx2;
    }

    public final void a() {
        QX2 qx2 = this.a;
        qx2.g();
        qx2.b().g();
        qx2.b().g();
        if (this.b) {
            qx2.d().n.a("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                qx2.l.a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                qx2.d().f.b(e, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        QX2 qx2 = this.a;
        qx2.g();
        String action = intent.getAction();
        qx2.d().n.b(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            qx2.d().i.b(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        nP2 np2 = qx2.b;
        QX2.H(np2);
        boolean zK = np2.k();
        if (this.c != zK) {
            this.c = zK;
            qx2.b().o(new RunnableC1388rP2(this, zK));
        }
    }
}
