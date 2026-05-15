package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: renamed from: oo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1235oo2 implements Iterator, BB0 {
    public int t;
    public final /* synthetic */ ViewGroup u;

    public C1235oo2(ViewGroup viewGroup) {
        this.u = viewGroup;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u.getChildCount();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.t;
        this.t = i + 1;
        View childAt = this.u.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.t - 1;
        this.t = i;
        this.u.removeViewAt(i);
    }
}
