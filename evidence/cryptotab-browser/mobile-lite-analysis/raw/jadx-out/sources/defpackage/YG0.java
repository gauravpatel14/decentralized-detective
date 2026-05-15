package defpackage;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YG0 implements View.OnTouchListener {
    public final /* synthetic */ ZG0 t;

    public YG0(ZG0 zg0) {
        this.t = zg0;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1459sb c1459sb;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        ZG0 zg0 = this.t;
        if (action == 0 && (c1459sb = zg0.S) != null && c1459sb.isShowing() && x >= 0 && x < zg0.S.getWidth() && y >= 0 && y < zg0.S.getHeight()) {
            zg0.O.postDelayed(zg0.K, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        zg0.O.removeCallbacks(zg0.K);
        return false;
    }
}
