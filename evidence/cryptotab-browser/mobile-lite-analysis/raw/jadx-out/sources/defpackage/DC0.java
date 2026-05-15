package defpackage;

import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DC0 implements Runnable {
    public final /* synthetic */ View t;
    public final /* synthetic */ AtomicInteger u;
    public final /* synthetic */ Handler v;

    public DC0(View view, AtomicInteger atomicInteger, Handler handler) {
        this.t = view;
        this.u = atomicInteger;
        this.v = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.t;
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            try {
                inputMethodManager.showSoftInput(view, 0);
            } catch (IllegalArgumentException e) {
                if (this.u.incrementAndGet() <= 10) {
                    this.v.postDelayed(this, 100L);
                } else {
                    Log.e("cr_KeyboardVisibility", "Unable to open keyboard.  Giving up.", e);
                }
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        }
    }
}
