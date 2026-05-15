package org.chromium.components.payments;

import defpackage.C0965kV;
import defpackage.ER0;
import defpackage.MT;
import defpackage.xc1;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface PaymentRequestUpdateEventListener {
    boolean changePaymentMethodFromInvokedApp(String str, String str2);

    default boolean changeShippingAddress(ByteBuffer byteBuffer) {
        MT[] mtArr = xc1.l;
        return d(xc1.d(new C0965kV(new ER0(byteBuffer, new ArrayList()))));
    }

    boolean changeShippingOptionFromInvokedApp(String str);

    boolean d(xc1 xc1Var);
}
