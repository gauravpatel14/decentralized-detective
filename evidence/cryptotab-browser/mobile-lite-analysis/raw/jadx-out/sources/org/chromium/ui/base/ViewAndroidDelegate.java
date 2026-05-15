package org.chromium.ui.base;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import com.google.android.gms.common.ConnectionResult;
import defpackage.InterfaceC0237Tn2;
import defpackage.L21;
import defpackage.M21;
import defpackage.m30;
import java.util.Iterator;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewAndroidDelegate {
    public final ViewGroup b;
    public Callback f;
    public final int[] c = new int[2];
    public final M21 d = new M21();
    public final M21 e = new M21();
    public final m30 a = new m30();

    public ViewAndroidDelegate(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    public View acquireView() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null || viewGroup.getParent() == null) {
            return null;
        }
        View view = new View(viewGroup.getContext());
        viewGroup.addView(view);
        return view;
    }

    public m30 b() {
        return null;
    }

    public boolean d() {
        return false;
    }

    public final View getContainerView() {
        return this.b;
    }

    public int getViewportInsetBottom() {
        return 0;
    }

    public final int getXLocationOfContainerViewInWindow() {
        View containerView = getContainerView();
        if (containerView == null) {
            return 0;
        }
        int[] iArr = this.c;
        containerView.getLocationInWindow(iArr);
        return iArr[0];
    }

    public final int getXLocationOnScreen() {
        View containerView = getContainerView();
        if (containerView == null) {
            return 0;
        }
        int[] iArr = this.c;
        containerView.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public final int getYLocationOfContainerViewInWindow() {
        View containerView = getContainerView();
        if (containerView == null) {
            return 0;
        }
        int[] iArr = this.c;
        containerView.getLocationInWindow(iArr);
        return iArr[1];
    }

    public final int getYLocationOnScreen() {
        View containerView = getContainerView();
        if (containerView == null) {
            return 0;
        }
        int[] iArr = this.c;
        containerView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public final boolean hasFocus() {
        View containerView = getContainerView();
        if (containerView == null) {
            return false;
        }
        if (containerView.isInTouchMode() ? containerView.isFocusableInTouchMode() : containerView.isFocusable()) {
            return containerView.hasFocus();
        }
        return true;
    }

    public void notifyHoverActionStylusWritable(boolean z) {
        Callback callback = this.f;
        if (callback != null) {
            callback.a0(Boolean.valueOf(z));
        }
    }

    public void onCursorChanged(int i) {
        int i2 = 1000;
        if (i != 45) {
            switch (i) {
                case 1:
                    i2 = 1007;
                    break;
                case 2:
                    i2 = 1002;
                    break;
                case 3:
                    i2 = 1008;
                    break;
                case 4:
                case 34:
                    i2 = 1004;
                    break;
                case 5:
                    i2 = 1003;
                    break;
                case 6:
                case 13:
                case 15:
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    i2 = 1014;
                    break;
                case 7:
                case 10:
                case 14:
                case 19:
                    i2 = 1015;
                    break;
                case 8:
                case 12:
                case 16:
                    i2 = 1016;
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                case 17:
                    i2 = 1017;
                    break;
                case 20:
                case 29:
                    i2 = 1013;
                    break;
                case 30:
                    i2 = 1009;
                    break;
                case 31:
                    i2 = 1006;
                    break;
                case 32:
                    i2 = 1001;
                    break;
                case 33:
                    i2 = 1010;
                    break;
                case 35:
                case 38:
                    i2 = 1012;
                    break;
                case 36:
                    i2 = 1011;
                    break;
                case 37:
                    i2 = 0;
                    break;
                case 39:
                    i2 = 1018;
                    break;
                case 40:
                    i2 = 1019;
                    break;
                case 41:
                    i2 = 1020;
                    break;
                case 42:
                    i2 = 1021;
                    break;
            }
        }
        ViewGroup viewGroup = this.b;
        viewGroup.setPointerIcon(PointerIcon.getSystemIcon(viewGroup.getContext(), i2));
    }

    public void onCursorChangedToCustom(Bitmap bitmap, int i, int i2) {
        this.b.setPointerIcon(PointerIcon.create(bitmap, i, i2));
    }

    public void onVerticalScrollDirectionChanged(boolean z, float f) {
        Iterator it = this.e.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((InterfaceC0237Tn2) l21.next()).c(z, f);
            }
        }
    }

    public void removeView(View view) {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public final void requestDisallowInterceptTouchEvent() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void requestFocus() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            if (!(viewGroup.isInTouchMode() ? viewGroup.isFocusableInTouchMode() : viewGroup.isFocusable()) || viewGroup.isFocused()) {
                return;
            }
            viewGroup.requestFocus();
        }
    }

    public final void requestUnbufferedDispatch(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                if (motionEvent.getToolType(i) == 2) {
                    return;
                }
            }
            viewGroup.requestUnbufferedDispatch(motionEvent);
        }
    }

    public void setViewPosition(View view, float f, float f2, float f3, float f4, int i, int i2) {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        int iRound = Math.round(f3);
        int iRound2 = Math.round(f4);
        if (viewGroup.getLayoutDirection() == 1) {
            i = viewGroup.getMeasuredWidth() - Math.round(f3 + f);
        }
        if (iRound + i > viewGroup.getWidth()) {
            iRound = viewGroup.getWidth() - i;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.width = iRound;
        marginLayoutParams.height = iRound2;
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean startDragAndDrop(android.graphics.Bitmap r25, org.chromium.ui.dragdrop.DropDataAndroid r26, org.chromium.ui.base.WindowAndroid r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.ui.base.ViewAndroidDelegate.startDragAndDrop(android.graphics.Bitmap, org.chromium.ui.dragdrop.DropDataAndroid, org.chromium.ui.base.WindowAndroid, int, int, int, int):boolean");
    }

    public void a(SparseArray sparseArray) {
    }

    public void c(ViewStructure viewStructure) {
    }

    public void onBackgroundColorChanged(int i) {
    }

    public void onControlsChanged(int i, int i2, int i3, int i4, int i5) {
    }
}
