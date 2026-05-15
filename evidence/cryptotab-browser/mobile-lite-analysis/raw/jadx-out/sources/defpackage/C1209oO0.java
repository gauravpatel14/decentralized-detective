package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.ArrayList;

/* JADX INFO: renamed from: oO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1209oO0 extends ArrayAdapter implements AdapterView.OnItemClickListener {
    public final LayoutInflater t;
    public final Drawable u;
    public final Drawable v;
    public final Drawable w;
    public final Drawable x;

    public C1209oO0(Context context, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.t = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{Ep1.mediaRouteDefaultIconDrawable, Ep1.mediaRouteTvIconDrawable, Ep1.mediaRouteSpeakerIconDrawable, Ep1.mediaRouteSpeakerGroupIconDrawable});
        this.u = AbstractC1686wb.a(typedArrayObtainStyledAttributes.getResourceId(0, 0), context);
        this.v = AbstractC1686wb.a(typedArrayObtainStyledAttributes.getResourceId(1, 0), context);
        this.w = AbstractC1686wb.a(typedArrayObtainStyledAttributes.getResourceId(2, 0), context);
        this.x = AbstractC1686wb.a(typedArrayObtainStyledAttributes.getResourceId(3, 0), context);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto Lb
            android.view.LayoutInflater r8 = r6.t
            int r1 = defpackage.AbstractC0189Pp1.mr_chooser_list_item
            android.view.View r8 = r8.inflate(r1, r9, r0)
        Lb:
            java.lang.Object r7 = r6.getItem(r7)
            iP0 r7 = (defpackage.C0838iP0) r7
            int r9 = defpackage.AbstractC0132Lp1.mr_chooser_route_name
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r1 = defpackage.AbstractC0132Lp1.mr_chooser_route_desc
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r7.d
            r9.setText(r2)
            java.lang.String r2 = r7.e
            int r3 = r7.i
            r4 = 1
            r5 = 2
            if (r3 == r5) goto L30
            if (r3 != r4) goto L42
        L30:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L42
            r3 = 80
            r9.setGravity(r3)
            r1.setVisibility(r0)
            r1.setText(r2)
            goto L51
        L42:
            r0 = 16
            r9.setGravity(r0)
            r9 = 8
            r1.setVisibility(r9)
            java.lang.String r9 = ""
            r1.setText(r9)
        L51:
            boolean r9 = r7.g
            r8.setEnabled(r9)
            int r9 = defpackage.AbstractC0132Lp1.mr_chooser_route_icon
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto La8
            android.net.Uri r0 = r7.f
            if (r0 == 0) goto L8c
            android.content.Context r1 = r6.getContext()     // Catch: java.io.IOException -> L78
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.io.IOException -> L78
            java.io.InputStream r1 = r1.openInputStream(r0)     // Catch: java.io.IOException -> L78
            r2 = 0
            android.graphics.drawable.Drawable r0 = android.graphics.drawable.Drawable.createFromStream(r1, r2)     // Catch: java.io.IOException -> L78
            if (r0 == 0) goto L8c
            goto La5
        L78:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to load "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "MediaRouteChooserDialog"
            android.util.Log.w(r2, r0, r1)
        L8c:
            int r0 = r7.n
            if (r0 == r4) goto La2
            if (r0 == r5) goto L9f
            boolean r7 = r7.c()
            if (r7 == 0) goto L9c
            android.graphics.drawable.Drawable r7 = r6.x
        L9a:
            r0 = r7
            goto La5
        L9c:
            android.graphics.drawable.Drawable r7 = r6.u
            goto L9a
        L9f:
            android.graphics.drawable.Drawable r7 = r6.w
            goto L9a
        La2:
            android.graphics.drawable.Drawable r7 = r6.v
            goto L9a
        La5:
            r9.setImageDrawable(r0)
        La8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1209oO0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        return ((C0838iP0) getItem(i)).g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0838iP0 c0838iP0 = (C0838iP0) getItem(i);
        ImageView imageView = (ImageView) view.findViewById(AbstractC0132Lp1.mr_chooser_route_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(AbstractC0132Lp1.mr_chooser_route_progress_bar);
        if (imageView != null && progressBar != null) {
            imageView.setVisibility(8);
            progressBar.setVisibility(0);
        }
        c0838iP0.j(true);
    }
}
