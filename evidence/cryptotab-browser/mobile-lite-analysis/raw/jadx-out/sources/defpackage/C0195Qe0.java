package defpackage;

import android.hardware.fingerprint.FingerprintManager;

/* JADX INFO: renamed from: Qe0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0195Qe0 extends FingerprintManager.AuthenticationCallback {
    public final /* synthetic */ AbstractC0205Re0 a;

    public C0195Qe0(AbstractC0205Re0 abstractC0205Re0) {
        this.a = abstractC0205Re0;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationError(int i, CharSequence charSequence) {
        this.a.a(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationFailed() {
        this.a.b();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        this.a.c(charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        FingerprintManager.CryptoObject cryptoObject = authenticationResult.getCryptoObject();
        C0233Te0 c0233Te0 = null;
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                c0233Te0 = new C0233Te0(cryptoObject.getCipher());
            } else if (cryptoObject.getSignature() != null) {
                c0233Te0 = new C0233Te0(cryptoObject.getSignature());
            } else if (cryptoObject.getMac() != null) {
                c0233Te0 = new C0233Te0(cryptoObject.getMac());
            }
        }
        this.a.d(new C0220Se0(c0233Te0));
    }
}
