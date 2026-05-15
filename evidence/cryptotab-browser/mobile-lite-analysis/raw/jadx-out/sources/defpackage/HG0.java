package defpackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HG0 {
    public static void a(PropertyModel propertyModel, View view, AbstractC0197Qm1 abstractC0197Qm1) {
        TextView textView = (TextView) view.findViewById(AbstractC0132Lp1.menu_item_text);
        ImageView imageView = (ImageView) view.findViewById(AbstractC0132Lp1.menu_item_icon);
        ImageView imageView2 = (ImageView) view.findViewById(AbstractC0132Lp1.menu_item_end_icon);
        C0272Wm1 c0272Wm1 = GG0.a;
        if (abstractC0197Qm1 == c0272Wm1) {
            int iE = propertyModel.e(c0272Wm1);
            if (iE != 0) {
                textView.setText(iE);
                return;
            }
            return;
        }
        C0289Xm1 c0289Xm1 = GG0.b;
        if (abstractC0197Qm1 == c0289Xm1) {
            CharSequence charSequence = (CharSequence) propertyModel.g(c0289Xm1);
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        C0289Xm1 c0289Xm12 = GG0.c;
        if (abstractC0197Qm1 == c0289Xm12) {
            textView.setContentDescription((CharSequence) propertyModel.g(c0289Xm12));
            return;
        }
        C0272Wm1 c0272Wm12 = GG0.d;
        C0223Sm1 c0223Sm1 = GG0.o;
        if (abstractC0197Qm1 == c0272Wm12 || abstractC0197Qm1 == GG0.f) {
            int iE2 = propertyModel.e((C0236Tm1) abstractC0197Qm1);
            Drawable drawableA = iE2 == 0 ? null : AbstractC1686wb.a(iE2, view.getContext());
            boolean zH = propertyModel.h(c0223Sm1);
            if (abstractC0197Qm1 == c0272Wm12) {
                if (drawableA == null) {
                    imageView.setImageDrawable(null);
                    imageView.setVisibility(zH ? 4 : 8);
                    return;
                } else {
                    imageView.setImageDrawable(drawableA);
                    imageView.setVisibility(0);
                    imageView2.setImageDrawable(null);
                    imageView2.setVisibility(8);
                    return;
                }
            }
            if (drawableA == null) {
                imageView2.setImageDrawable(null);
                imageView2.setVisibility(8);
                return;
            } else {
                imageView2.setImageDrawable(drawableA);
                imageView2.setVisibility(0);
                imageView.setImageDrawable(null);
                imageView.setVisibility(zH ? 4 : 8);
                return;
            }
        }
        C0289Xm1 c0289Xm13 = GG0.e;
        if (abstractC0197Qm1 == c0289Xm13) {
            Drawable drawable = (Drawable) propertyModel.g(c0289Xm13);
            boolean zH2 = propertyModel.h(c0223Sm1);
            if (drawable == null) {
                imageView.setImageDrawable(null);
                imageView.setVisibility(zH2 ? 4 : 8);
                return;
            } else {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                imageView2.setImageDrawable(null);
                imageView2.setVisibility(8);
                return;
            }
        }
        if (abstractC0197Qm1 == GG0.g || abstractC0197Qm1 == GG0.h || abstractC0197Qm1 == GG0.i || abstractC0197Qm1 == GG0.j) {
            return;
        }
        if (abstractC0197Qm1 == c0223Sm1) {
            if (imageView.getVisibility() != 0) {
                boolean zH3 = propertyModel.h(c0223Sm1);
                imageView.setImageDrawable(null);
                imageView.setVisibility(zH3 ? 4 : 8);
                return;
            }
            return;
        }
        C0257Vm1 c0257Vm1 = GG0.k;
        if (abstractC0197Qm1 == c0257Vm1) {
            textView.setEnabled(propertyModel.h(c0257Vm1));
            imageView.setEnabled(propertyModel.h(c0257Vm1));
            imageView2.setEnabled(propertyModel.h(c0257Vm1));
            return;
        }
        C0272Wm1 c0272Wm13 = GG0.l;
        if (abstractC0197Qm1 == c0272Wm13) {
            if (propertyModel.e(c0272Wm13) != 0) {
                imageView.setImageTintList(U3.b(propertyModel.e(c0272Wm13), view.getContext()));
                imageView2.setImageTintList(U3.b(propertyModel.e(c0272Wm13), view.getContext()));
                return;
            } else {
                imageView.setImageTintList(null);
                imageView2.setImageTintList(null);
                return;
            }
        }
        C0236Tm1 c0236Tm1 = GG0.m;
        if (abstractC0197Qm1 == c0236Tm1) {
            AbstractC0911ja.e(textView, propertyModel.e(c0236Tm1));
            return;
        }
        C0223Sm1 c0223Sm12 = GG0.n;
        if (abstractC0197Qm1 == c0223Sm12) {
            if (!propertyModel.h(c0223Sm12)) {
                textView.setEllipsize(null);
            } else {
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }
}
