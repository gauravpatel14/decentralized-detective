package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Lr1 {
    public final Rect t;
    public ViewOnTouchListenerC1482t7 u;

    public Lr1() {
        this.t = new Rect();
    }

    public void a(ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7) {
        this.u = viewOnTouchListenerC1482t7;
    }

    public void b() {
        this.u = null;
    }

    public Lr1(Rect rect) {
        Rect rect2 = new Rect();
        this.t = rect2;
        rect2.set(rect);
    }
}
