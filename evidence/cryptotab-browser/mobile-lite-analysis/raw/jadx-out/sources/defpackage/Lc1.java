package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.util.regex.Pattern;
import org.chromium.base.task.PostTask;
import org.chromium.components.payments.Address;
import org.chromium.components.payments.PaymentRequestUpdateEventListener;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Lc1 extends Binder implements IInterface {
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("org.chromium.components.payments.IPaymentDetailsUpdateService");
        }
        if (i == 1598968902) {
            parcel2.writeString("org.chromium.components.payments.IPaymentDetailsUpdateService");
            return true;
        }
        if (i == 1) {
            final Bundle bundle = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
            final InterfaceC0991ks0 interfaceC0991ks0W0 = AbstractBinderC0930js0.W0(parcel.readStrongBinder());
            final int callingUid = Binder.getCallingUid();
            final int i3 = 1;
            PostTask.d(7, new Runnable() { // from class: Kc1
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener2;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener3;
                    switch (i3) {
                        case 0:
                            if (Mc1.a().b(callingUid)) {
                                Mc1 mc1A = Mc1.a();
                                Bundle bundle2 = (Bundle) bundle;
                                InterfaceC0991ks0 interfaceC0991ks0 = interfaceC0991ks0W0;
                                if (bundle2 != null) {
                                    mc1A.getClass();
                                    if (!bundle2.isEmpty()) {
                                        Address addressA = Address.a(bundle2);
                                        if (Address.k == null) {
                                            addressA.getClass();
                                            Address.k = Pattern.compile("^[A-Z]{2}$");
                                        }
                                        if (!Address.k.matcher(addressA.a).matches()) {
                                            Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                        } else if (mc1A.a == null && (paymentRequestUpdateEventListener = mc1A.b) != null && paymentRequestUpdateEventListener.d(yc1.a(addressA))) {
                                            mc1A.a = interfaceC0991ks0;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks0);
                                        }
                                    }
                                }
                                mc1A.getClass();
                                Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                break;
                            }
                            break;
                        case 1:
                            if (Mc1.a().b(callingUid)) {
                                Mc1 mc1A2 = Mc1.a();
                                Bundle bundle3 = (Bundle) bundle;
                                InterfaceC0991ks0 interfaceC0991ks02 = interfaceC0991ks0W0;
                                if (bundle3 != null) {
                                    mc1A2.getClass();
                                    String string = bundle3.getString("methodName");
                                    if (!TextUtils.isEmpty(string)) {
                                        String string2 = bundle3.getString("details", "{}");
                                        if (mc1A2.a == null && (paymentRequestUpdateEventListener2 = mc1A2.b) != null && paymentRequestUpdateEventListener2.changePaymentMethodFromInvokedApp(string, string2)) {
                                            mc1A2.a = interfaceC0991ks02;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks02);
                                        }
                                    } else {
                                        Mc1.c("Method name required.", interfaceC0991ks02);
                                    }
                                } else {
                                    mc1A2.getClass();
                                    Mc1.c("Method data required.", interfaceC0991ks02);
                                }
                                break;
                            }
                            break;
                        default:
                            if (Mc1.a().b(callingUid)) {
                                Mc1 mc1A3 = Mc1.a();
                                mc1A3.getClass();
                                String str = (String) bundle;
                                boolean zIsEmpty = TextUtils.isEmpty(str);
                                InterfaceC0991ks0 interfaceC0991ks03 = interfaceC0991ks0W0;
                                if (zIsEmpty) {
                                    Mc1.c("Shipping option identifier required.", interfaceC0991ks03);
                                } else if (mc1A3.a == null && (paymentRequestUpdateEventListener3 = mc1A3.b) != null && paymentRequestUpdateEventListener3.changeShippingOptionFromInvokedApp(str)) {
                                    mc1A3.a = interfaceC0991ks03;
                                } else {
                                    Mc1.c("Invalid state.", interfaceC0991ks03);
                                }
                                break;
                            }
                            break;
                    }
                }
            });
        } else if (i == 2) {
            final String string = parcel.readString();
            final InterfaceC0991ks0 interfaceC0991ks0W02 = AbstractBinderC0930js0.W0(parcel.readStrongBinder());
            final int callingUid2 = Binder.getCallingUid();
            final int i4 = 2;
            PostTask.d(7, new Runnable() { // from class: Kc1
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener2;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener3;
                    switch (i4) {
                        case 0:
                            if (Mc1.a().b(callingUid2)) {
                                Mc1 mc1A = Mc1.a();
                                Bundle bundle2 = (Bundle) string;
                                InterfaceC0991ks0 interfaceC0991ks0 = interfaceC0991ks0W02;
                                if (bundle2 != null) {
                                    mc1A.getClass();
                                    if (!bundle2.isEmpty()) {
                                        Address addressA = Address.a(bundle2);
                                        if (Address.k == null) {
                                            addressA.getClass();
                                            Address.k = Pattern.compile("^[A-Z]{2}$");
                                        }
                                        if (!Address.k.matcher(addressA.a).matches()) {
                                            Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                        } else if (mc1A.a == null && (paymentRequestUpdateEventListener = mc1A.b) != null && paymentRequestUpdateEventListener.d(yc1.a(addressA))) {
                                            mc1A.a = interfaceC0991ks0;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks0);
                                        }
                                    }
                                }
                                mc1A.getClass();
                                Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                break;
                            }
                            break;
                        case 1:
                            if (Mc1.a().b(callingUid2)) {
                                Mc1 mc1A2 = Mc1.a();
                                Bundle bundle3 = (Bundle) string;
                                InterfaceC0991ks0 interfaceC0991ks02 = interfaceC0991ks0W02;
                                if (bundle3 != null) {
                                    mc1A2.getClass();
                                    String string2 = bundle3.getString("methodName");
                                    if (!TextUtils.isEmpty(string2)) {
                                        String string22 = bundle3.getString("details", "{}");
                                        if (mc1A2.a == null && (paymentRequestUpdateEventListener2 = mc1A2.b) != null && paymentRequestUpdateEventListener2.changePaymentMethodFromInvokedApp(string2, string22)) {
                                            mc1A2.a = interfaceC0991ks02;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks02);
                                        }
                                    } else {
                                        Mc1.c("Method name required.", interfaceC0991ks02);
                                    }
                                } else {
                                    mc1A2.getClass();
                                    Mc1.c("Method data required.", interfaceC0991ks02);
                                }
                                break;
                            }
                            break;
                        default:
                            if (Mc1.a().b(callingUid2)) {
                                Mc1 mc1A3 = Mc1.a();
                                mc1A3.getClass();
                                String str = (String) string;
                                boolean zIsEmpty = TextUtils.isEmpty(str);
                                InterfaceC0991ks0 interfaceC0991ks03 = interfaceC0991ks0W02;
                                if (zIsEmpty) {
                                    Mc1.c("Shipping option identifier required.", interfaceC0991ks03);
                                } else if (mc1A3.a == null && (paymentRequestUpdateEventListener3 = mc1A3.b) != null && paymentRequestUpdateEventListener3.changeShippingOptionFromInvokedApp(str)) {
                                    mc1A3.a = interfaceC0991ks03;
                                } else {
                                    Mc1.c("Invalid state.", interfaceC0991ks03);
                                }
                                break;
                            }
                            break;
                    }
                }
            });
        } else {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            final Bundle bundle2 = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
            final InterfaceC0991ks0 interfaceC0991ks0W03 = AbstractBinderC0930js0.W0(parcel.readStrongBinder());
            final int callingUid3 = Binder.getCallingUid();
            final int i5 = 0;
            PostTask.d(7, new Runnable() { // from class: Kc1
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener2;
                    PaymentRequestUpdateEventListener paymentRequestUpdateEventListener3;
                    switch (i5) {
                        case 0:
                            if (Mc1.a().b(callingUid3)) {
                                Mc1 mc1A = Mc1.a();
                                Bundle bundle22 = (Bundle) bundle2;
                                InterfaceC0991ks0 interfaceC0991ks0 = interfaceC0991ks0W03;
                                if (bundle22 != null) {
                                    mc1A.getClass();
                                    if (!bundle22.isEmpty()) {
                                        Address addressA = Address.a(bundle22);
                                        if (Address.k == null) {
                                            addressA.getClass();
                                            Address.k = Pattern.compile("^[A-Z]{2}$");
                                        }
                                        if (!Address.k.matcher(addressA.a).matches()) {
                                            Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                        } else if (mc1A.a == null && (paymentRequestUpdateEventListener = mc1A.b) != null && paymentRequestUpdateEventListener.d(yc1.a(addressA))) {
                                            mc1A.a = interfaceC0991ks0;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks0);
                                        }
                                    }
                                }
                                mc1A.getClass();
                                Mc1.c("Payment app returned invalid shipping address in response.", interfaceC0991ks0);
                                break;
                            }
                            break;
                        case 1:
                            if (Mc1.a().b(callingUid3)) {
                                Mc1 mc1A2 = Mc1.a();
                                Bundle bundle3 = (Bundle) bundle2;
                                InterfaceC0991ks0 interfaceC0991ks02 = interfaceC0991ks0W03;
                                if (bundle3 != null) {
                                    mc1A2.getClass();
                                    String string2 = bundle3.getString("methodName");
                                    if (!TextUtils.isEmpty(string2)) {
                                        String string22 = bundle3.getString("details", "{}");
                                        if (mc1A2.a == null && (paymentRequestUpdateEventListener2 = mc1A2.b) != null && paymentRequestUpdateEventListener2.changePaymentMethodFromInvokedApp(string2, string22)) {
                                            mc1A2.a = interfaceC0991ks02;
                                        } else {
                                            Mc1.c("Invalid state.", interfaceC0991ks02);
                                        }
                                    } else {
                                        Mc1.c("Method name required.", interfaceC0991ks02);
                                    }
                                } else {
                                    mc1A2.getClass();
                                    Mc1.c("Method data required.", interfaceC0991ks02);
                                }
                                break;
                            }
                            break;
                        default:
                            if (Mc1.a().b(callingUid3)) {
                                Mc1 mc1A3 = Mc1.a();
                                mc1A3.getClass();
                                String str = (String) bundle2;
                                boolean zIsEmpty = TextUtils.isEmpty(str);
                                InterfaceC0991ks0 interfaceC0991ks03 = interfaceC0991ks0W03;
                                if (zIsEmpty) {
                                    Mc1.c("Shipping option identifier required.", interfaceC0991ks03);
                                } else if (mc1A3.a == null && (paymentRequestUpdateEventListener3 = mc1A3.b) != null && paymentRequestUpdateEventListener3.changeShippingOptionFromInvokedApp(str)) {
                                    mc1A3.a = interfaceC0991ks03;
                                } else {
                                    Mc1.c("Invalid state.", interfaceC0991ks03);
                                }
                                break;
                            }
                            break;
                    }
                }
            });
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
