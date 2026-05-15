package defpackage;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: renamed from: db, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0538db extends ContentFrameLayout {
    public final /* synthetic */ LayoutInflaterFactory2C0658fb B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0538db(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, C1264pM c1264pM) {
        super(c1264pM, null);
        this.B = layoutInflaterFactory2C0658fb;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.B.v(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.B;
                layoutInflaterFactory2C0658fb.t(layoutInflaterFactory2C0658fb.A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(AbstractC1686wb.a(i, getContext()));
    }
}
