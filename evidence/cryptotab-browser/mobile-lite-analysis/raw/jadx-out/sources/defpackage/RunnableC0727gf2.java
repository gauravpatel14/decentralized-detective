package defpackage;

import J.N;
import android.os.Looper;

/* JADX INFO: renamed from: gf2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0727gf2 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (!N._Z(2)) {
            if (C0794hf2.c == null || !C0794hf2.b) {
                return;
            }
            Looper.myQueue().removeIdleHandler(C0794hf2.c);
            C0794hf2.b = false;
            return;
        }
        if (C0794hf2.c == null) {
            C0794hf2.c = new C0794hf2();
        }
        if (C0794hf2.b) {
            return;
        }
        Looper.myQueue().addIdleHandler(C0794hf2.c);
        C0794hf2.b = true;
    }
}
