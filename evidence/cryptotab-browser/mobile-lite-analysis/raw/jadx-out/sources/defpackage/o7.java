package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class o7 implements Runnable {
    public final /* synthetic */ ViewOnTouchListenerC1482t7 t;

    public o7(ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7) {
        this.t = viewOnTouchListenerC1482t7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.t;
        if (viewOnTouchListenerC1482t7.y.isShowing()) {
            viewOnTouchListenerC1482t7.b();
        }
    }
}
