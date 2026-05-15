package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import defpackage.C1450sT;
import defpackage.InterfaceC0671fr0;
import defpackage.dr0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsSessionToken {
    public final InterfaceC0671fr0 a;
    public final PendingIntent b;
    public final C1450sT c;

    public CustomTabsSessionToken(InterfaceC0671fr0 interfaceC0671fr0, PendingIntent pendingIntent) {
        if (interfaceC0671fr0 == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.a = interfaceC0671fr0;
        this.b = pendingIntent;
        this.c = interfaceC0671fr0 == null ? null : new C1450sT(this);
    }

    public static CustomTabsSessionToken a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        IBinder binder = extras.getBinder("android.support.customtabs.extra.SESSION");
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("android.support.customtabs.extra.SESSION_ID");
        if (binder == null && pendingIntent == null) {
            return null;
        }
        return new CustomTabsSessionToken(binder != null ? dr0.W0(binder) : null, pendingIntent);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent pendingIntent = customTabsSessionToken.b;
        PendingIntent pendingIntent2 = this.b;
        if ((pendingIntent2 == null) != (pendingIntent == null)) {
            return false;
        }
        if (pendingIntent2 != null) {
            return pendingIntent2.equals(pendingIntent);
        }
        InterfaceC0671fr0 interfaceC0671fr0 = this.a;
        if (interfaceC0671fr0 == null) {
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        IBinder iBinderAsBinder = interfaceC0671fr0.asBinder();
        InterfaceC0671fr0 interfaceC0671fr02 = customTabsSessionToken.a;
        if (interfaceC0671fr02 != null) {
            return iBinderAsBinder.equals(interfaceC0671fr02.asBinder());
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        InterfaceC0671fr0 interfaceC0671fr0 = this.a;
        if (interfaceC0671fr0 != null) {
            return interfaceC0671fr0.asBinder().hashCode();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }
}
