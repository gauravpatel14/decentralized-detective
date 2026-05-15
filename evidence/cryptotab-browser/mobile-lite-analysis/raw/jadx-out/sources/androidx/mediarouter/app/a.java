package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import defpackage.C0838iP0;
import defpackage.C1730xO0;
import defpackage.Q51;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ HashMap t;
    public final /* synthetic */ HashMap u;
    public final /* synthetic */ d v;

    public a(d dVar, HashMap map, HashMap map2) {
        this.v = dVar;
        this.t = map;
        this.u = map2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        HashMap map;
        HashMap map2;
        Q51 q51;
        C0838iP0 c0838iP0;
        d dVar = this.v;
        dVar.X.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = dVar.a0;
        if (hashSet == null || dVar.b0 == null) {
            return;
        }
        int size = hashSet.size() - dVar.b0.size();
        b bVar = new b(dVar);
        int firstVisiblePosition = dVar.X.getFirstVisiblePosition();
        int i = 0;
        boolean z = false;
        while (true) {
            int childCount = dVar.X.getChildCount();
            map = this.t;
            map2 = this.u;
            if (i >= childCount) {
                break;
            }
            View childAt = dVar.X.getChildAt(i);
            C0838iP0 c0838iP02 = (C0838iP0) dVar.Y.getItem(firstVisiblePosition + i);
            Rect rect = (Rect) map.get(c0838iP02);
            int top = childAt.getTop();
            int i2 = rect != null ? rect.top : (dVar.h0 * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            HashSet hashSet2 = dVar.a0;
            if (hashSet2 == null || !hashSet2.contains(c0838iP02)) {
                c0838iP0 = c0838iP02;
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                c0838iP0 = c0838iP02;
                alphaAnimation.setDuration(dVar.B0);
                animationSet.addAnimation(alphaAnimation);
                i2 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i2 - top, 0.0f);
            translateAnimation.setDuration(dVar.A0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(dVar.D0);
            if (!z) {
                animationSet.setAnimationListener(bVar);
                z = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            C0838iP0 c0838iP03 = c0838iP0;
            map.remove(c0838iP03);
            map2.remove(c0838iP03);
            i++;
        }
        for (Map.Entry entry : map2.entrySet()) {
            C0838iP0 c0838iP04 = (C0838iP0) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(c0838iP04);
            if (dVar.b0.contains(c0838iP04)) {
                q51 = new Q51(bitmapDrawable, rect2);
                q51.h = 0.0f;
                q51.e = dVar.C0;
                q51.d = dVar.D0;
            } else {
                int i3 = dVar.h0 * size;
                Q51 q512 = new Q51(bitmapDrawable, rect2);
                q512.g = i3;
                q512.e = dVar.A0;
                q512.d = dVar.D0;
                q512.l = new C1730xO0(dVar, c0838iP04);
                dVar.c0.add(c0838iP04);
                q51 = q512;
            }
            dVar.X.t.add(q51);
        }
    }
}
