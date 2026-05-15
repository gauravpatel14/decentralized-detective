package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EC0 {
    public static int a(View view) {
        TraceEvent traceEventJ = TraceEvent.j("KeyboardVisibilityDelegate.calculateKeyboardHeight", null);
        if (view != null) {
            try {
                if (view.getRootWindowInsets() != null) {
                    C0307Yv2 c0307Yv2 = C0383aw2.g(view, view.getRootWindowInsets()).a;
                    int i = c0307Yv2.f(8).d;
                    if (i == 0) {
                        if (traceEventJ != null) {
                            traceEventJ.close();
                        }
                        return 0;
                    }
                    int i2 = i - c0307Yv2.f(7).d;
                    if (traceEventJ != null) {
                        traceEventJ.close();
                    }
                    return i2;
                }
            } catch (Throwable th) {
                if (traceEventJ != null) {
                    try {
                        traceEventJ.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
        if (traceEventJ != null) {
            traceEventJ.close();
        }
        return 0;
    }

    public static boolean b(View view) {
        if (view.isAttachedToWindow()) {
            return ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return false;
    }

    public static boolean c(View view) {
        View rootView = view.getRootView();
        return rootView != null && a(rootView) > 0;
    }
}
