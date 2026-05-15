package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import defpackage.C0612ez2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new C0612ez2();
    public static final Clock G = DefaultClock.getInstance();
    public final long A;
    public final String B;
    public final ArrayList C;
    public final String D;
    public final String E;
    public final HashSet F = new HashSet();
    public final int t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    public final Uri y;
    public String z;

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.t = i;
        this.u = str;
        this.v = str2;
        this.w = str3;
        this.x = str4;
        this.y = uri;
        this.z = str5;
        this.A = j;
        this.B = str6;
        this.C = arrayList;
        this.D = str7;
        this.E = str8;
    }

    public static GoogleSignInAccount g2(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has(Scopes.EMAIL) ? jSONObject.optString(Scopes.EMAIL) : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, uri, null, j, Preconditions.checkNotEmpty(jSONObject.getString("obfuscatedIdentifier")), new ArrayList((Collection) Preconditions.checkNotNull(hashSet)), jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null);
        googleSignInAccount.z = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.B.equals(this.B) && googleSignInAccount.f2().equals(f2());
    }

    public final HashSet f2() {
        HashSet hashSet = new HashSet(this.C);
        hashSet.addAll(this.F);
        return hashSet;
    }

    public final int hashCode() {
        return ((this.B.hashCode() + 527) * 31) + f2().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeString(parcel, 2, this.u, false);
        SafeParcelWriter.writeString(parcel, 3, this.v, false);
        SafeParcelWriter.writeString(parcel, 4, this.w, false);
        SafeParcelWriter.writeString(parcel, 5, this.x, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.y, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.z, false);
        SafeParcelWriter.writeLong(parcel, 8, this.A);
        SafeParcelWriter.writeString(parcel, 9, this.B, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.C, false);
        SafeParcelWriter.writeString(parcel, 11, this.D, false);
        SafeParcelWriter.writeString(parcel, 12, this.E, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
