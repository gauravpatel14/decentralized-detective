package defpackage;

import android.os.Handler;
import android.os.MessageQueue;
import java.util.LinkedList;

/* JADX INFO: renamed from: zW, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1850zW implements MessageQueue.IdleHandler {
    public final /* synthetic */ CW a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        CW cw = this.a;
        LinkedList linkedList = cw.a;
        try {
            Runnable runnable = (Runnable) linkedList.poll();
            if (runnable != null) {
                runnable.run();
            }
            if (linkedList.isEmpty()) {
                if (CW.b == cw) {
                    CW.b = null;
                }
                return false;
            }
        } catch (Throwable th) {
            new Handler().post(new Runnable() { // from class: AW
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    throw th;
                }
            });
        }
        new Handler().post(new BW());
        return true;
    }
}
