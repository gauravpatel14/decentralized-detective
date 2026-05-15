package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: renamed from: Zr1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0321Zr1 extends ViewGroup.MarginLayoutParams {
    public ps1 a;
    public final Rect b;
    public boolean c;
    public boolean d;

    public C0321Zr1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.c = true;
        this.d = false;
    }

    public C0321Zr1(int i, int i2) {
        super(i, i2);
        this.b = new Rect();
        this.c = true;
        this.d = false;
    }

    public C0321Zr1(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.b = new Rect();
        this.c = true;
        this.d = false;
    }

    public C0321Zr1(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.b = new Rect();
        this.c = true;
        this.d = false;
    }

    public C0321Zr1(C0321Zr1 c0321Zr1) {
        super((ViewGroup.LayoutParams) c0321Zr1);
        this.b = new Rect();
        this.c = true;
        this.d = false;
    }
}
