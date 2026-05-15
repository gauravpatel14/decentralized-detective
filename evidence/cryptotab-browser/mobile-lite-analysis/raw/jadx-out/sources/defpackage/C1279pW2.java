package defpackage;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.TimerTask;

/* JADX INFO: renamed from: pW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1279pW2 extends TimerTask {
    public final /* synthetic */ UN0 t;

    public C1279pW2(UN0 un0) {
        this.t = un0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        BasePendingResult basePendingResultO;
        UN0 un0 = this.t;
        ArrayDeque arrayDeque = un0.i;
        if (!arrayDeque.isEmpty() && un0.l == null && un0.d && un0.b != 0) {
            int[] iArrB = AbstractC0700gL2.b(arrayDeque);
            Nt1 nt1 = un0.c;
            nt1.getClass();
            Preconditions.checkMainThread("Must be called from the main thread.");
            if (nt1.r()) {
                WD2 wd2 = new WD2(nt1, nt1.f, iArrB);
                nt1.p(wd2);
                basePendingResultO = wd2;
            } else {
                basePendingResultO = Nt1.o();
            }
            un0.l = basePendingResultO;
            basePendingResultO.setResultCallback(un0.n);
            arrayDeque.clear();
        }
    }
}
