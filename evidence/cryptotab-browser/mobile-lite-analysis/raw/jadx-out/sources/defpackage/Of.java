package defpackage;

import android.os.Message;
import android.util.Log;
import android.view.View;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Of extends Thread {
    public static final Of v;
    public ArrayBlockingQueue t;
    public Ci1 u;

    static {
        Of of = new Of();
        of.t = new ArrayBlockingQueue(10);
        of.u = new Ci1(10);
        v = of;
        of.setName("AsyncLayoutInflator");
        of.start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                Nf nf = (Nf) this.t.take();
                try {
                    nf.e = nf.a.inflate(nf.d, nf.c, false);
                } catch (RuntimeException e) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                View view = nf.e;
                Message.obtain(nf.b, 0, nf).sendToTarget();
            } catch (InterruptedException e2) {
                Log.w("AsyncLayoutInflater", e2);
            }
        }
    }
}
