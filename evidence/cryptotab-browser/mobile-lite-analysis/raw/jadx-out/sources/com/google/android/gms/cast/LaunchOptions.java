package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.AbstractC0700gL2;
import defpackage.C1657wD2;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LaunchOptionsCreator")
@SafeParcelable.Reserved({1})
public class LaunchOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1657wD2();
    public boolean t;
    public final String u;

    public LaunchOptions(String str, boolean z) {
        this.t = z;
        this.u = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.t == launchOptions.t && AbstractC0700gL2.a(this.u, launchOptions.u);
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.t), this.u);
    }

    public final String toString() {
        return "LaunchOptions(relaunchIfRunning=" + this.t + ", language=" + this.u + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.t);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public LaunchOptions() {
        Locale locale = Locale.getDefault();
        Pattern pattern = AbstractC0700gL2.a;
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-');
            sb.append(variant);
        }
        this(sb.toString(), false);
    }
}
