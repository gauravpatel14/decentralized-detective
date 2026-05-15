package org.chromium.base.memory;

import J.N;
import android.os.SystemClock;
import defpackage.Gr1;
import defpackage.L21;
import defpackage.M21;
import defpackage.OE0;
import defpackage.Td;
import defpackage.XP0;
import java.util.Iterator;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.memory.MemoryPurgeManager;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MemoryPurgeManager implements Td {
    public static final MemoryPurgeManager x;
    public boolean t;
    public long u;
    public boolean v;
    public boolean w;

    static {
        MemoryPurgeManager memoryPurgeManager = new MemoryPurgeManager();
        memoryPurgeManager.u = -1L;
        x = memoryPurgeManager;
    }

    public static void doDelayedPurge(boolean z) {
        x.a(z);
    }

    public final void a(boolean z) {
        this.v = false;
        if (this.u == -1) {
            return;
        }
        if (!z) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.u;
            if (jElapsedRealtime < 240000) {
                b(240000 - jElapsedRealtime);
                return;
            }
        }
        M21 m21 = MemoryPressureListener.a;
        if (m21 == null) {
            return;
        }
        Iterator it = m21.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((XP0) l21.next()).a(2);
            }
        }
    }

    public final void b(long j) {
        if (this.v) {
            return;
        }
        if (!OE0.h.d() ? false : N._Z(3)) {
            N._V_J(2, j);
        } else {
            PostTask.b(7, new Runnable() { // from class: dQ0
                @Override // java.lang.Runnable
                public final void run() {
                    MemoryPurgeManager memoryPurgeManager = MemoryPurgeManager.x;
                    this.t.a(false);
                }
            }, j);
        }
        this.v = true;
    }

    @Override // defpackage.Td
    public final void q(int i) {
        if (i == 0 || i == 1 || i == 2) {
            if (this.u != -1 && this.w) {
                Gr1.j(SystemClock.elapsedRealtime() - this.u, "Android.ApplicationState.TimeInBackgroundBeforeForegroundedAgain");
            }
            this.w = true;
            this.u = -1L;
            return;
        }
        if (i == 3 && this.u == -1) {
            this.u = SystemClock.elapsedRealtime();
            b(240000L);
        }
    }
}
