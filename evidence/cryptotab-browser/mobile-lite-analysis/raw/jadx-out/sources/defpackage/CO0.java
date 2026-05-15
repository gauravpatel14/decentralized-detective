package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.mediarouter.app.OverlayListView;
import androidx.mediarouter.app.a;
import androidx.mediarouter.app.c;
import androidx.mediarouter.app.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CO0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ boolean t;
    public final /* synthetic */ d u;

    public CO0(d dVar, boolean z) {
        this.u = dVar;
        this.t = z;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iO;
        HashMap map;
        HashMap map2;
        Bitmap bitmap;
        d dVar = this.u;
        dVar.M.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (dVar.y0) {
            dVar.z0 = true;
            return;
        }
        int i = dVar.T.getLayoutParams().height;
        d.r(dVar.T, -1);
        dVar.x(dVar.k());
        View decorView = dVar.getWindow().getDecorView();
        decorView.measure(View.MeasureSpec.makeMeasureSpec(dVar.getWindow().getAttributes().width, 1073741824), 0);
        d.r(dVar.T, i);
        if (!(dVar.N.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) dVar.N.getDrawable()).getBitmap()) == null) {
            iO = 0;
        } else {
            iO = dVar.o(bitmap.getWidth(), bitmap.getHeight());
            dVar.N.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
        }
        int iP = dVar.p(dVar.k());
        int size = dVar.Z.size();
        boolean zQ = dVar.q();
        C0838iP0 c0838iP0 = dVar.B;
        int size2 = zQ ? Collections.unmodifiableList(c0838iP0.v).size() * dVar.h0 : 0;
        if (size > 0) {
            size2 += dVar.j0;
        }
        int iMin = Math.min(size2, dVar.i0);
        if (!dVar.x0) {
            iMin = 0;
        }
        int iMax = Math.max(iO, iMin) + iP;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iHeight = rect.height() - (dVar.L.getMeasuredHeight() - dVar.M.getMeasuredHeight());
        if (iO <= 0 || iMax > iHeight) {
            if (dVar.T.getMeasuredHeight() + dVar.X.getLayoutParams().height >= dVar.M.getMeasuredHeight()) {
                dVar.N.setVisibility(8);
            }
            iMax = iMin + iP;
            iO = 0;
        } else {
            dVar.N.setVisibility(0);
            d.r(dVar.N, iO);
        }
        if (!dVar.k() || iMax > iHeight) {
            dVar.U.setVisibility(8);
        } else {
            dVar.U.setVisibility(0);
        }
        dVar.x(dVar.U.getVisibility() == 0);
        int iP2 = dVar.p(dVar.U.getVisibility() == 0);
        int iMax2 = Math.max(iO, iMin) + iP2;
        if (iMax2 > iHeight) {
            iMin -= iMax2 - iHeight;
        } else {
            iHeight = iMax2;
        }
        dVar.T.clearAnimation();
        dVar.X.clearAnimation();
        dVar.M.clearAnimation();
        boolean z = this.t;
        if (z) {
            dVar.j(iP2, dVar.T);
            dVar.j(iMin, dVar.X);
            dVar.j(iHeight, dVar.M);
        } else {
            d.r(dVar.T, iP2);
            d.r(dVar.X, iMin);
            d.r(dVar.M, iHeight);
        }
        d.r(dVar.K, rect.height());
        List listUnmodifiableList = Collections.unmodifiableList(c0838iP0.v);
        if (listUnmodifiableList.isEmpty()) {
            dVar.Z.clear();
            dVar.Y.notifyDataSetChanged();
            return;
        }
        if (new HashSet(dVar.Z).equals(new HashSet(listUnmodifiableList))) {
            dVar.Y.notifyDataSetChanged();
            return;
        }
        if (z) {
            OverlayListView overlayListView = dVar.X;
            c cVar = dVar.Y;
            map = new HashMap();
            int firstVisiblePosition = overlayListView.getFirstVisiblePosition();
            for (int i2 = 0; i2 < overlayListView.getChildCount(); i2++) {
                Object item = cVar.getItem(firstVisiblePosition + i2);
                View childAt = overlayListView.getChildAt(i2);
                map.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
            }
        } else {
            map = null;
        }
        if (z) {
            OverlayListView overlayListView2 = dVar.X;
            c cVar2 = dVar.Y;
            map2 = new HashMap();
            int firstVisiblePosition2 = overlayListView2.getFirstVisiblePosition();
            for (int i3 = 0; i3 < overlayListView2.getChildCount(); i3++) {
                Object item2 = cVar2.getItem(firstVisiblePosition2 + i3);
                View childAt2 = overlayListView2.getChildAt(i3);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt2.getWidth(), childAt2.getHeight(), Bitmap.Config.ARGB_8888);
                childAt2.draw(new Canvas(bitmapCreateBitmap));
                map2.put(item2, new BitmapDrawable(dVar.C.getResources(), bitmapCreateBitmap));
            }
        } else {
            map2 = null;
        }
        ArrayList arrayList = dVar.Z;
        HashSet hashSet = new HashSet(listUnmodifiableList);
        hashSet.removeAll(arrayList);
        dVar.a0 = hashSet;
        HashSet hashSet2 = new HashSet(dVar.Z);
        hashSet2.removeAll(listUnmodifiableList);
        dVar.b0 = hashSet2;
        dVar.Z.addAll(0, dVar.a0);
        dVar.Z.removeAll(dVar.b0);
        dVar.Y.notifyDataSetChanged();
        if (z && dVar.x0) {
            if (dVar.b0.size() + dVar.a0.size() > 0) {
                dVar.X.setEnabled(false);
                dVar.X.requestLayout();
                dVar.y0 = true;
                dVar.X.getViewTreeObserver().addOnGlobalLayoutListener(new a(dVar, map, map2));
                return;
            }
        }
        dVar.a0 = null;
        dVar.b0 = null;
    }
}
