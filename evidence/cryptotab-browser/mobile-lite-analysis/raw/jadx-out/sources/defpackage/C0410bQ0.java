package defpackage;

import J.N;
import android.app.ActivityManager;
import java.util.Iterator;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: bQ0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0410bQ0 {
    public static final C0410bQ0 f = new C0410bQ0();
    public Integer b;
    public boolean c;
    public boolean d;
    public int a = 0;
    public final ZP0 e = new Runnable() { // from class: ZP0
        @Override // java.lang.Runnable
        public final void run() {
            C0410bQ0 c0410bQ0 = this.t;
            c0410bQ0.c = false;
            Integer num = c0410bQ0.b;
            if (num != null && c0410bQ0.a != num.intValue()) {
                int iIntValue = c0410bQ0.b.intValue();
                c0410bQ0.b = null;
                c0410bQ0.c(iIntValue);
            } else if (c0410bQ0.d && c0410bQ0.a == 2) {
                c0410bQ0.b();
            }
        }
    };

    public static Integer a(int i) {
        if (i >= 80 || i == 15) {
            return 2;
        }
        if (i >= 40) {
            return Integer.valueOf(!OE0.h.d() ? false : N._Z(1) ? 2 : 1);
        }
        return null;
    }

    public final void b() {
        Integer numA;
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            numA = a(runningAppProcessInfo.lastTrimLevel);
        } catch (Exception unused) {
            numA = null;
        }
        if (numA != null) {
            c(numA.intValue());
        }
    }

    public final void c(int i) {
        PostTask.b(7, this.e, 60000);
        this.c = true;
        this.a = i;
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
                ((XP0) l21.next()).a(i);
            }
        }
    }
}
