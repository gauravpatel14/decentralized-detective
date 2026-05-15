package defpackage;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: nT, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1151nT {
    public ArrayList c;
    public ActivityOptions d;
    public final Intent a = new Intent("android.intent.action.VIEW");
    public final uR b = new uR();
    public int e = 0;
    public final boolean f = true;

    public final C1216oT a() {
        Intent intent = this.a;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        ArrayList<? extends Parcelable> arrayList = this.c;
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f);
        Integer num = this.b.a;
        Bundle bundle2 = new Bundle();
        if (num != null) {
            bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        intent.putExtras(bundle2);
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.e);
        int i = Build.VERSION.SDK_INT;
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        String languageTag = adjustedDefault.size() > 0 ? adjustedDefault.get(0).toLanguageTag() : null;
        if (!TextUtils.isEmpty(languageTag)) {
            Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (!bundleExtra.containsKey("Accept-Language")) {
                bundleExtra.putString("Accept-Language", languageTag);
                intent.putExtra("com.android.browser.headers", bundleExtra);
            }
        }
        if (i >= 34) {
            if (this.d == null) {
                this.d = ActivityOptions.makeBasic();
            }
            AbstractC1091mT.a(this.d);
        }
        ActivityOptions activityOptions = this.d;
        return new C1216oT(intent, activityOptions != null ? activityOptions.toBundle() : null);
    }

    public final void b(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid value for the colorScheme argument");
        }
        this.a.putExtra("androidx.browser.customtabs.extra.COLOR_SCHEME", i);
    }

    public final void c(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid value for the shareState argument");
        }
        this.e = i;
        Intent intent = this.a;
        if (i == 1) {
            intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
        } else if (i == 2) {
            intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
        } else {
            intent.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
        }
    }

    public final void d(boolean z) {
        this.a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
    }
}
