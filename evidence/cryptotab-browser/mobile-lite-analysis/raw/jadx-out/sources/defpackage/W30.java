package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class W30 extends ArrayAdapter {
    public final Context t;
    public final boolean u;
    public final int v;

    public W30(Context context, ArrayList arrayList) {
        super(context, AbstractC0189Pp1.dropdown_item);
        this.t = context;
        addAll(arrayList);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= getCount()) {
                z = true;
                break;
            }
            d40 d40Var = (d40) getItem(i);
            if (d40Var.j() && !d40Var.k()) {
                break;
            } else {
                i++;
            }
        }
        this.u = z;
        this.v = context.getResources().getDimensionPixelSize(Hp1.dropdown_item_label_margin);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        return this.u;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = this.t;
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(AbstractC0189Pp1.dropdown_item, (ViewGroup) null);
            view.setBackground(new Y30());
        }
        Y30 y30 = (Y30) view.getBackground();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(Hp1.dropdown_item_height);
        if (i == 0) {
            y30.a.setColor(0);
        } else {
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(Hp1.dropdown_item_divider_height);
            dimensionPixelSize += dimensionPixelSize2;
            Rect rect = y30.b;
            rect.set(0, 0, rect.right, dimensionPixelSize2);
            y30.a.setColor(context.getColor(AbstractC0084Gp1.dropdown_divider_color));
        }
        d40 d40Var = (d40) getItem(i);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(AbstractC0132Lp1.dropdown_label_wrapper);
        if (d40Var.m()) {
            dimensionPixelSize = -2;
        }
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, dimensionPixelSize, 1.0f));
        TextView textView = (TextView) view.findViewById(AbstractC0132Lp1.dropdown_label);
        textView.setText(d40Var.d());
        textView.setSingleLine(!d40Var.m());
        if (d40Var.m()) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            int paddingStart = textView.getPaddingStart();
            int paddingEnd = textView.getPaddingEnd();
            int i2 = this.v;
            textView.setPaddingRelative(paddingStart, i2, paddingEnd, i2);
        }
        textView.setEnabled(d40Var.j());
        if (d40Var.k() || d40Var.i()) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setTextColor(context.getColor(d40Var.e()));
        textView.setTextSize(0, context.getResources().getDimension(Hp1.text_size_large));
        TextView textView2 = (TextView) view.findViewById(AbstractC0132Lp1.dropdown_sublabel);
        String strH = d40Var.h();
        if (TextUtils.isEmpty(strH)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(strH);
            textView2.setTextSize(0, context.getResources().getDimension(Hp1.text_size_small));
            textView2.setVisibility(0);
        }
        ImageView imageView = (ImageView) view.findViewById(AbstractC0132Lp1.start_dropdown_icon);
        ImageView imageView2 = (ImageView) view.findViewById(AbstractC0132Lp1.end_dropdown_icon);
        if (d40Var.l()) {
            imageView2.setVisibility(8);
        } else {
            imageView.setVisibility(8);
        }
        if (!d40Var.l()) {
            imageView = imageView2;
        }
        if (d40Var.b() == 0) {
            imageView.setVisibility(8);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.width = -2;
            marginLayoutParams.height = -2;
            int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(Hp1.dropdown_icon_margin);
            marginLayoutParams.setMarginStart(dimensionPixelSize3);
            marginLayoutParams.setMarginEnd(dimensionPixelSize3);
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setImageDrawable(AbstractC1686wb.a(d40Var.b(), context));
            imageView.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (i < 0 || i >= getCount()) {
            return false;
        }
        d40 d40Var = (d40) getItem(i);
        return d40Var.j() && !d40Var.k();
    }
}
