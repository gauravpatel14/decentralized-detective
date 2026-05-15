package defpackage;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: vP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1615vP0 {
    public boolean c;
    public HandlerC1504tP0 e;
    public final Object a = new Object();
    public final uP0 b = new uP0(this);
    public WeakReference d = new WeakReference(null);

    public final void a(wP0 wp0, Handler handler) {
        if (this.c) {
            this.c = false;
            handler.removeMessages(1);
            PlaybackStateCompat playbackStateCompatD = wp0.d();
            long j = playbackStateCompatD == null ? 0L : playbackStateCompatD.x;
            boolean z = playbackStateCompatD != null && playbackStateCompatD.t == 3;
            boolean z2 = (516 & j) != 0;
            boolean z3 = (j & 514) != 0;
            if (z && z3) {
                c();
            } else {
                if (z || !z2) {
                    return;
                }
                d();
            }
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void g() {
    }

    public void h() {
    }

    public void f(long j) {
    }
}
