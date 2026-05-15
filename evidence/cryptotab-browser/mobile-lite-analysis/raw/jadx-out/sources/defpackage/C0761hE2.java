package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.internal.vision.zzam;

/* JADX INFO: renamed from: hE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0761hE2 extends AbstractC1651w23 {
    public final zzam i;

    public C0761hE2(Context context, zzam zzamVar) {
        super(context, "TextNativeHandle", "ocr");
        this.i = zzamVar;
        e();
    }

    @Override // defpackage.AbstractC1651w23
    public final Object a(m50 m50Var, Context context) throws DynamiteModule$LoadingException {
        RC2 rc2;
        IBinder iBinderB = m50Var.b("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        C1656wC2 c1656wC2 = null;
        if (iBinderB == null) {
            rc2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            rc2 = iInterfaceQueryLocalInterface instanceof RC2 ? (RC2) iInterfaceQueryLocalInterface : new RC2(iBinderB, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
        }
        if (rc2 == null) {
            return null;
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        zzam zzamVar = (zzam) Preconditions.checkNotNull(this.i);
        Parcel parcelW0 = rc2.W0();
        AbstractC1777yK2.a(parcelW0, objectWrapper);
        AbstractC1777yK2.b(parcelW0, zzamVar);
        Parcel parcelX0 = rc2.X0(1, parcelW0);
        IBinder strongBinder = parcelX0.readStrongBinder();
        if (strongBinder != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            c1656wC2 = iInterfaceQueryLocalInterface2 instanceof C1656wC2 ? (C1656wC2) iInterfaceQueryLocalInterface2 : new C1656wC2(strongBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
        }
        parcelX0.recycle();
        return c1656wC2;
    }

    @Override // defpackage.AbstractC1651w23
    public final void b() {
        C1656wC2 c1656wC2 = (C1656wC2) Preconditions.checkNotNull((C1656wC2) e());
        c1656wC2.Y0(2, c1656wC2.W0());
    }
}
