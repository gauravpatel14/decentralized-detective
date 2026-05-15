package defpackage;

import J.N;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: renamed from: Hw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0096Hw2 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!"android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction())) {
            if ("android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction())) {
                N._V(38);
                return;
            } else {
                if (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)) {
                    return;
                }
                N._V(38);
                return;
            }
        }
        try {
            AbstractC0108Iw2.a();
        } catch (KeyStoreException e) {
            Log.e("cr_X509Util", "Unable to reload the default TrustManager", e);
        } catch (NoSuchAlgorithmException e2) {
            Log.e("cr_X509Util", "Unable to reload the default TrustManager", e2);
        } catch (CertificateException e3) {
            Log.e("cr_X509Util", "Unable to reload the default TrustManager", e3);
        }
    }
}
