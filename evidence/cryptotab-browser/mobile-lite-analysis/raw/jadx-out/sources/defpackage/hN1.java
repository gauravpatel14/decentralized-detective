package defpackage;

import android.content.Intent;
import android.widget.RemoteViewsService;
import org.chromium.chrome.browser.bookmarkswidget.BookmarkWidgetService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hN1 {
    public BookmarkWidgetService a;

    public abstract RemoteViewsService.RemoteViewsFactory a(Intent intent);
}
