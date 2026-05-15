package defpackage;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ue0 {
    public final Context a;

    public Ue0(Context context) {
        this.a = context;
    }

    public static FingerprintManager b(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    public final void a(C0233Te0 c0233Te0, Bx bx, AbstractC0205Re0 abstractC0205Re0) {
        CancellationSignal cancellationSignal;
        CancellationSignal cancellationSignal2;
        FingerprintManager.CryptoObject cryptoObject = null;
        if (bx != null) {
            synchronized (bx) {
                try {
                    if (bx.c == null) {
                        CancellationSignal cancellationSignal3 = new CancellationSignal();
                        bx.c = cancellationSignal3;
                        if (bx.a) {
                            cancellationSignal3.cancel();
                        }
                    }
                    cancellationSignal2 = bx.c;
                } finally {
                }
            }
            cancellationSignal = cancellationSignal2;
        } else {
            cancellationSignal = null;
        }
        FingerprintManager fingerprintManagerB = b(this.a);
        if (fingerprintManagerB != null) {
            if (c0233Te0 != null) {
                Cipher cipher = c0233Te0.b;
                if (cipher != null) {
                    cryptoObject = new FingerprintManager.CryptoObject(cipher);
                } else {
                    Signature signature = c0233Te0.a;
                    if (signature != null) {
                        cryptoObject = new FingerprintManager.CryptoObject(signature);
                    } else {
                        Mac mac = c0233Te0.c;
                        if (mac != null) {
                            cryptoObject = new FingerprintManager.CryptoObject(mac);
                        }
                    }
                }
            }
            fingerprintManagerB.authenticate(cryptoObject, cancellationSignal, 0, new C0195Qe0(abstractC0205Re0), null);
        }
    }
}
