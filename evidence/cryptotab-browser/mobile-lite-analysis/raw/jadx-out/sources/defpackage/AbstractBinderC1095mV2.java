package defpackage;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: renamed from: mV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1095mV2 extends zzz {
    public final int t;

    public AbstractBinderC1095mV2(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.t = Arrays.hashCode(bArr);
    }

    public static byte[] W0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public abstract byte[] X0();

    public final boolean equals(Object obj) {
        Zr0 zr0Zzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaaVar = (zzaa) obj;
                if (zzaaVar.zzc() == this.t && (zr0Zzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(X0(), (byte[]) ObjectWrapper.X0(zr0Zzd));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.t;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.t;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final Zr0 zzd() {
        return new ObjectWrapper(X0());
    }
}
