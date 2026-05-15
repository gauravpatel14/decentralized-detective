package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: renamed from: Ea2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0054Ea2 {
    public final Context a;
    public CharSequence b;
    public View c;
    public Integer d;
    public Integer e;
    public int f = 0;
    public int g = 1;

    public C0054Ea2(Context context) {
        this.a = context;
    }

    public final C0064Fa2 a() {
        Context context = this.a;
        TextView textView = (TextView) LayoutInflater.from(context).inflate(AbstractC0189Pp1.custom_toast_layout, (ViewGroup) null);
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            textView.setText(charSequence);
            textView.announceForAccessibility(this.b);
        }
        if (this.d != null) {
            textView.getBackground().setTint(this.d.intValue());
        }
        Integer num = this.e;
        if (num != null) {
            textView.setTextAppearance(num.intValue());
        }
        C0064Fa2 c0064Fa2 = new C0064Fa2(context, textView);
        View view = this.c;
        if (view != null) {
            Point point = o00.a(context).c;
            int i = point.x;
            int i2 = point.y;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            int i3 = iArr[0];
            boolean z = i3 < i / 2;
            int i4 = z ? 3 : 5;
            int i5 = z ? (width / 2) + i3 : (i - i3) - (width / 2);
            int i6 = iArr[1];
            c0064Fa2.d(i4 | 48, i5, i6 < i2 / 2 ? (height / 2) + i6 : i6 - ((height * 3) / 2));
        }
        c0064Fa2.a.setDuration(this.f);
        c0064Fa2.c = this.g;
        c0064Fa2.d = this.b;
        return c0064Fa2;
    }
}
