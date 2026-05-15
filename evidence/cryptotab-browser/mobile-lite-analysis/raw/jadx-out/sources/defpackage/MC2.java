package defpackage;

import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MC2 extends AbstractBinderC1598vB2 {
    public final fF1 t;
    public final Class u;

    public MC2(fF1 ff1) {
        super("com.google.android.gms.cast.framework.ISessionManagerListener");
        this.t = ff1;
        this.u = Ly.class;
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        Class cls = this.u;
        fF1 ff1 = this.t;
        switch (i) {
            case 1:
                ObjectWrapper objectWrapper = new ObjectWrapper(ff1);
                parcel2.writeNoException();
                QK2.b(parcel2, objectWrapper);
                return true;
            case 2:
                AbstractC0338aF1 abstractC0338aF1 = (AbstractC0338aF1) ObjectWrapper.X0(ObjectWrapper.W0(parcel.readStrongBinder()));
                if (cls.isInstance(abstractC0338aF1) && ff1 != null) {
                    ff1.j((AbstractC0338aF1) cls.cast(abstractC0338aF1));
                }
                parcel2.writeNoException();
                return true;
            case 3:
                Zr0 zr0W0 = ObjectWrapper.W0(parcel.readStrongBinder());
                String string = parcel.readString();
                AbstractC0338aF1 abstractC0338aF12 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W0);
                if (cls.isInstance(abstractC0338aF12) && ff1 != null) {
                    ff1.i((AbstractC0338aF1) cls.cast(abstractC0338aF12), string);
                }
                parcel2.writeNoException();
                return true;
            case 4:
                Zr0 zr0W02 = ObjectWrapper.W0(parcel.readStrongBinder());
                parcel.readInt();
                AbstractC0338aF1 abstractC0338aF13 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W02);
                if (cls.isInstance(abstractC0338aF13) && ff1 != null) {
                    ff1.f((AbstractC0338aF1) cls.cast(abstractC0338aF13));
                }
                parcel2.writeNoException();
                return true;
            case 5:
                AbstractC0338aF1 abstractC0338aF14 = (AbstractC0338aF1) ObjectWrapper.X0(ObjectWrapper.W0(parcel.readStrongBinder()));
                if (cls.isInstance(abstractC0338aF14) && ff1 != null) {
                    ff1.c((AbstractC0338aF1) cls.cast(abstractC0338aF14));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                Zr0 zr0W03 = ObjectWrapper.W0(parcel.readStrongBinder());
                parcel.readInt();
                AbstractC0338aF1 abstractC0338aF15 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W03);
                if (cls.isInstance(abstractC0338aF15) && ff1 != null) {
                    ff1.d((AbstractC0338aF1) cls.cast(abstractC0338aF15));
                }
                parcel2.writeNoException();
                return true;
            case 7:
                Zr0 zr0W04 = ObjectWrapper.W0(parcel.readStrongBinder());
                parcel.readString();
                AbstractC0338aF1 abstractC0338aF16 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W04);
                if (cls.isInstance(abstractC0338aF16) && ff1 != null) {
                    ff1.l((AbstractC0338aF1) cls.cast(abstractC0338aF16));
                }
                parcel2.writeNoException();
                return true;
            case 8:
                Zr0 zr0W05 = ObjectWrapper.W0(parcel.readStrongBinder());
                int i2 = QK2.a;
                parcel.readInt();
                AbstractC0338aF1 abstractC0338aF17 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W05);
                if (cls.isInstance(abstractC0338aF17) && ff1 != null) {
                    ff1.b((AbstractC0338aF1) cls.cast(abstractC0338aF17));
                }
                parcel2.writeNoException();
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                Zr0 zr0W06 = ObjectWrapper.W0(parcel.readStrongBinder());
                parcel.readInt();
                AbstractC0338aF1 abstractC0338aF18 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W06);
                if (cls.isInstance(abstractC0338aF18) && ff1 != null) {
                    ff1.h((AbstractC0338aF1) cls.cast(abstractC0338aF18));
                }
                parcel2.writeNoException();
                return true;
            case 10:
                Zr0 zr0W07 = ObjectWrapper.W0(parcel.readStrongBinder());
                parcel.readInt();
                AbstractC0338aF1 abstractC0338aF19 = (AbstractC0338aF1) ObjectWrapper.X0(zr0W07);
                if (cls.isInstance(abstractC0338aF19) && ff1 != null) {
                    ff1.a((AbstractC0338aF1) cls.cast(abstractC0338aF19));
                }
                parcel2.writeNoException();
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                parcel2.writeNoException();
                parcel2.writeInt(12451009);
                return true;
            default:
                return false;
        }
    }
}
