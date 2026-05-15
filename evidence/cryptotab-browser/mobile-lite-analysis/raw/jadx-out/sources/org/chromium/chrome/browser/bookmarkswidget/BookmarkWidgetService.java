package org.chromium.chrome.browser.bookmarkswidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViewsService;
import defpackage.hN1;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BookmarkWidgetService extends RemoteViewsService {
    public String t = "Mt";
    public hN1 u;

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        hN1 hn1 = (hN1) BundleUtils.g(contextB, this.t);
        this.u = hn1;
        hn1.a = this;
        super.attachBaseContext(contextB);
    }

    @Override // android.widget.RemoteViewsService
    public final RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return this.u.a(intent);
    }
}
