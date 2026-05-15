package defpackage;

import android.os.CancellationSignal;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Bx {
    public boolean a;
    public Ax b;
    public CancellationSignal c;
    public boolean d;

    public final void a() {
        synchronized (this) {
            try {
                if (this.a) {
                    return;
                }
                this.a = true;
                this.d = true;
                Ax ax = this.b;
                CancellationSignal cancellationSignal = this.c;
                if (ax != null) {
                    try {
                        ax.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
                synchronized (this) {
                    this.d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }
}
