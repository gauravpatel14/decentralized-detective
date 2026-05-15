package defpackage;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gF1 extends AbstractBinderC1598vB2 {
    public final /* synthetic */ GQ2 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gF1(GQ2 gq2) {
        super("com.google.android.gms.cast.framework.ISessionProvider");
        this.t = gq2;
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        GQ2 gq2 = this.t;
        if (i == 1) {
            String string = parcel.readString();
            gq2.getClass();
            ty tyVar = AbstractC1874zy.b;
            Context context = gq2.a;
            CastOptions castOptions = gq2.d;
            Zr0 zr0C = new Ly(context, gq2.b, string, castOptions, tyVar, new C1256pD2(context, castOptions, gq2.e)).c();
            parcel2.writeNoException();
            QK2.b(parcel2, zr0C);
        } else if (i == 2) {
            boolean z = gq2.d.x;
            parcel2.writeNoException();
            int i2 = QK2.a;
            parcel2.writeInt(z ? 1 : 0);
        } else if (i == 3) {
            String str = gq2.b;
            parcel2.writeNoException();
            parcel2.writeString(str);
        } else {
            if (i != 4) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(12451009);
        }
        return true;
    }
}
