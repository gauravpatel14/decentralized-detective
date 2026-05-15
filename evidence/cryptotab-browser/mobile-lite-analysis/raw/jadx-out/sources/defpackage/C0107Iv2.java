package defpackage;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: Iv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0107Iv2 extends WindowInsetsAnimation$Callback {
    public final Uw0 a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public C0107Iv2(Uw0 uw0) {
        super(0);
        this.d = new HashMap();
        this.a = uw0;
    }

    public final C0134Lv2 a(WindowInsetsAnimation windowInsetsAnimation) {
        C0134Lv2 c0134Lv2 = (C0134Lv2) this.d.get(windowInsetsAnimation);
        if (c0134Lv2 == null) {
            c0134Lv2 = new C0134Lv2(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                c0134Lv2.a = new C0114Jv2(windowInsetsAnimation);
            }
            this.d.put(windowInsetsAnimation, c0134Lv2);
        }
        return c0134Lv2;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        Uw0 uw0 = this.a;
        C0134Lv2 c0134Lv2A = a(windowInsetsAnimation);
        Iterator it = uw0.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                this.d.remove(windowInsetsAnimation);
                return;
            }
            ((Xw0) l21.next()).b(c0134Lv2A);
        }
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        Uw0 uw0 = this.a;
        C0134Lv2 c0134Lv2A = a(windowInsetsAnimation);
        Iterator it = uw0.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Xw0) l21.next()).d(c0134Lv2A);
            }
        }
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationG = AbstractC0095Hv2.g(list.get(size));
            C0134Lv2 c0134Lv2A = a(windowInsetsAnimationG);
            c0134Lv2A.a.d(windowInsetsAnimationG.getFraction());
            this.c.add(c0134Lv2A);
        }
        Uw0 uw0 = this.a;
        C0383aw2 c0383aw2G = C0383aw2.g(null, windowInsets);
        List list2 = this.b;
        Iterator it = uw0.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return c0383aw2G.f();
            }
            ((Xw0) l21.next()).a(list2);
        }
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        Uw0 uw0 = this.a;
        a(windowInsetsAnimation);
        bx0 bx0VarC = bx0.c(bounds.getLowerBound());
        bx0 bx0VarC2 = bx0.c(bounds.getUpperBound());
        Iterator it = uw0.b.y.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                AbstractC0095Hv2.h();
                return AbstractC0095Hv2.e(bx0VarC.d(), bx0VarC2.d());
            }
            ((Xw0) l21.next()).getClass();
        }
    }
}
