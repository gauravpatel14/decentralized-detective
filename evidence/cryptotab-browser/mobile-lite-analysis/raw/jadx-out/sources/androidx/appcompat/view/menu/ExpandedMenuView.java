package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import defpackage.C1342qa2;
import defpackage.DQ0;
import defpackage.InterfaceC0706gQ0;
import defpackage.MenuC0775hQ0;
import defpackage.WQ0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements InterfaceC0706gQ0, WQ0, AdapterView.OnItemClickListener {
    public static final int[] u = {R.attr.background, R.attr.divider};
    public MenuC0775hQ0 t;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C1342qa2 c1342qa2F = C1342qa2.f(context, attributeSet, u, R.attr.listViewStyle);
        TypedArray typedArray = c1342qa2F.b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(c1342qa2F.b(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(c1342qa2F.b(1));
        }
        c1342qa2F.g();
    }

    @Override // defpackage.InterfaceC0706gQ0
    public final boolean a(DQ0 dq0) {
        return this.t.q(dq0, null, 0);
    }

    @Override // defpackage.WQ0
    public final void c(MenuC0775hQ0 menuC0775hQ0) {
        this.t = menuC0775hQ0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((DQ0) getAdapter().getItem(i));
    }
}
