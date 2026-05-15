package defpackage;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* JADX INFO: renamed from: oO1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1210oO1 {
    public final Context a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();

    public C1210oO1(Context context) {
        this.a = context;
    }

    public final mO1 a(int[] iArr, int i) {
        ArrayList arrayList = this.b;
        mO1 mo1 = new mO1(i, arrayList.size() + 1, iArr);
        arrayList.add(mo1);
        return mo1;
    }

    public final void b(mO1 mo1, mO1 mo12, int i) {
        this.c.add(new nO1(i, mo1.c, mo12.c));
    }

    public final AnimatedStateListDrawable c() {
        Context context;
        AnimatedStateListDrawable animatedStateListDrawable = new AnimatedStateListDrawable();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            context = this.a;
            if (i >= size) {
                break;
            }
            mO1 mo1 = (mO1) arrayList.get(i);
            animatedStateListDrawable.addState(mo1.b, AbstractC1686wb.a(mo1.a, context), mo1.c);
            i++;
        }
        ArrayList arrayList2 = this.c;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            nO1 no1 = (nO1) arrayList2.get(i2);
            animatedStateListDrawable.addTransition(no1.b, no1.c, (Drawable) ((Animatable) AbstractC1686wb.a(no1.a, context)), false);
        }
        return animatedStateListDrawable;
    }
}
