package org.chromium.ui.base;

import android.content.ClipboardManager;
import android.net.Uri;
import android.util.Log;
import defpackage.AbstractC1499tM;
import defpackage.ClipboardManagerOnPrimaryClipChangedListenerC0566eG;
import defpackage.ZF;
import org.chromium.url.GURL;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Clipboard {
    public static Clipboard b;
    public long a;

    public static Clipboard getInstance() {
        if (b == null) {
            ClipboardManager clipboardManager = (ClipboardManager) AbstractC1499tM.a.getSystemService("clipboard");
            if (clipboardManager != null) {
                b = new ClipboardManagerOnPrimaryClipChangedListenerC0566eG(clipboardManager);
            } else {
                b = new Clipboard();
            }
        }
        return b;
    }

    public boolean a() {
        return false;
    }

    public Uri c() {
        return null;
    }

    public void e(ZF zf) {
        Log.w("cr_Clipboard", "setImageFileProvider is a no-op because Clipboard service isn't available");
    }

    public void f(Uri uri) {
        Log.w("cr_Clipboard", "setImageUri is a no-op because Clipboard service isn't available");
    }

    public void g(boolean z, Uri uri) {
        Log.w("cr_Clipboard", "setImageUriAndNotify is a no-op because Clipboard service isn't available");
    }

    public String getCoercedText() {
        return null;
    }

    public String getFilenames() {
        return null;
    }

    public String getHTMLText() {
        return null;
    }

    public String getImageUriString() {
        return null;
    }

    public byte[] getPng() {
        return null;
    }

    public String getUrl() {
        return null;
    }

    public void h(String str, String str2, boolean z) {
        Log.w("cr_Clipboard", "setText is a no-op because Clipboard service isn't available");
    }

    public boolean hasCoercedText() {
        return false;
    }

    public boolean hasFilenames() {
        return false;
    }

    public boolean hasHTMLOrStyledText() {
        return false;
    }

    public boolean hasImage() {
        return false;
    }

    public boolean hasUrl() {
        return false;
    }

    public void i(String str) {
        Log.w("cr_Clipboard", "setText is a no-op because Clipboard service isn't available");
    }

    public void setFilenames(String str) {
        Log.w("cr_Clipboard", "setFilenames is a no-op because Clipboard service isn't available");
    }

    public void setHTMLText(String str, String str2) {
        Log.w("cr_Clipboard", "setHTMLText is a no-op because Clipboard service isn't available");
    }

    public void setImage(byte[] bArr, String str) {
        Log.w("cr_Clipboard", "setImage is a no-op because Clipboard service isn't available");
    }

    public final void setNativePtr(long j) {
        this.a = j;
    }

    public void setPassword(String str) {
        Log.w("cr_Clipboard", "setPassword is a no-op because Clipboard service isn't available");
    }

    public void setText(String str) {
        Log.w("cr_Clipboard", "setText is a no-op because Clipboard service isn't available");
    }

    public void clear() {
    }

    public void b(GURL gurl) {
    }

    public void d(boolean z) {
    }
}
