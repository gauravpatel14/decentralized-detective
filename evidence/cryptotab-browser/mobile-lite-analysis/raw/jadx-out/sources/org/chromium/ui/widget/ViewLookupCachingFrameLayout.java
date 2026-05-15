package org.chromium.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC1872zv;
import defpackage.ViewGroupOnHierarchyChangeListenerC1805yo2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewLookupCachingFrameLayout extends OptimizedFrameLayout {
    public final SparseArray u;

    public ViewLookupCachingFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new SparseArray();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC1805yo2(this));
    }

    public static void g(View view, ViewGroupOnHierarchyChangeListenerC1805yo2 viewGroupOnHierarchyChangeListenerC1805yo2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setOnHierarchyChangeListener(viewGroupOnHierarchyChangeListenerC1805yo2);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), viewGroupOnHierarchyChangeListenerC1805yo2);
            }
        }
    }

    public final View c(int i) {
        SparseArray sparseArray = this.u;
        WeakReference weakReference = (WeakReference) sparseArray.get(i);
        View viewFindViewById = weakReference != null ? (View) weakReference.get() : null;
        if (viewFindViewById == null) {
            viewFindViewById = findViewById(i);
        }
        int i2 = AbstractC1872zv.a;
        if (viewFindViewById != null) {
            sparseArray.put(i, new WeakReference(viewFindViewById));
        }
        return viewFindViewById;
    }
}
