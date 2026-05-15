package defpackage;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: renamed from: Vo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0259Vo2 extends DataSetObserver {
    public final /* synthetic */ ViewPager a;

    public C0259Vo2(ViewPager viewPager) {
        this.a = viewPager;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.a.f();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.f();
    }
}
