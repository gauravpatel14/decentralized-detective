package defpackage;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: renamed from: No2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0162No2 implements Runnable {
    public final /* synthetic */ ViewPager t;

    public RunnableC0162No2(ViewPager viewPager) {
        this.t = viewPager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewPager viewPager = this.t;
        viewPager.y(0);
        viewPager.r();
    }
}
