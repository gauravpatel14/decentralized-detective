package defpackage;

import J.N;
import org.chromium.ui.accessibility.AccessibilityState;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v0 implements Runnable {
    public final /* synthetic */ int t;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                AccessibilityState.k();
                break;
            case 1:
                int i = AccessibilityState.a;
                N._V(40);
                break;
            case 2:
                AccessibilityState.k();
                N._V(41);
                break;
            default:
                AccessibilityState.h();
                break;
        }
    }
}
