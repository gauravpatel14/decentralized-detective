package defpackage;

import android.view.View;
import android.view.ViewGroup;
import org.chromium.ui.widget.ViewLookupCachingFrameLayout;

/* JADX INFO: renamed from: yo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupOnHierarchyChangeListenerC1805yo2 implements ViewGroup.OnHierarchyChangeListener {
    public final /* synthetic */ ViewLookupCachingFrameLayout t;

    public ViewGroupOnHierarchyChangeListenerC1805yo2(ViewLookupCachingFrameLayout viewLookupCachingFrameLayout) {
        this.t = viewLookupCachingFrameLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        this.t.u.remove(view2.getId());
        ViewLookupCachingFrameLayout.g(view2, this);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        this.t.u.remove(view2.getId());
        ViewLookupCachingFrameLayout.g(view2, null);
    }
}
