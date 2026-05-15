package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0281Wz2;
import defpackage.C1761xz2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final GoogleSignInOptions D;
    public static final Scope E;
    public static final Scope F;
    public static final Scope G;
    public static final Scope H;
    public static final C1761xz2 I;
    public final String A;
    public final ArrayList B;
    public final String C;
    public final int t;
    public final ArrayList u;
    public final Account v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final String z;

    static {
        Scope scope = new Scope(Scopes.PROFILE);
        E = new Scope(Scopes.EMAIL);
        Scope scope2 = new Scope(Scopes.OPEN_ID);
        F = scope2;
        Scope scope3 = new Scope(Scopes.GAMES_LITE);
        G = scope3;
        H = new Scope(Scopes.GAMES);
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(H)) {
            Scope scope4 = G;
            if (hashSet.contains(scope4)) {
                hashSet.remove(scope4);
            }
        }
        D = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(H)) {
            Scope scope5 = G;
            if (hashSet2.contains(scope5)) {
                hashSet2.remove(scope5);
            }
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new C0281Wz2();
        I = new C1761xz2();
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, HashMap map, String str3) {
        this.t = i;
        this.u = arrayList;
        this.v = account;
        this.w = z;
        this.x = z2;
        this.y = z3;
        this.z = str;
        this.A = str2;
        this.B = new ArrayList(map.values());
        this.C = str3;
    }

    public static GoogleSignInOptions g2(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, AccountType.GOOGLE) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static HashMap h2(ArrayList arrayList) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.u), googleSignInOptionsExtensionParcelable);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: ClassCastException -> 0x0077, TryCatch #0 {ClassCastException -> 0x0077, blocks: (B:5:0x0008, B:7:0x0016, B:10:0x001f, B:12:0x002d, B:15:0x0038, B:21:0x0045, B:23:0x004b, B:29:0x0059, B:31:0x005f, B:33:0x0065, B:35:0x006b, B:26:0x0052, B:19:0x003f), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052 A[Catch: ClassCastException -> 0x0077, TryCatch #0 {ClassCastException -> 0x0077, blocks: (B:5:0x0008, B:7:0x0016, B:10:0x001f, B:12:0x002d, B:15:0x0038, B:21:0x0045, B:23:0x004b, B:29:0x0059, B:31:0x005f, B:33:0x0065, B:35:0x006b, B:26:0x0052, B:19:0x003f), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.String r0 = r7.z
            java.util.ArrayList r1 = r7.u
            r2 = 0
            if (r8 != 0) goto L8
            return r2
        L8:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r8 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r8     // Catch: java.lang.ClassCastException -> L77
            java.lang.String r3 = r8.z     // Catch: java.lang.ClassCastException -> L77
            android.accounts.Account r4 = r8.v     // Catch: java.lang.ClassCastException -> L77
            java.util.ArrayList r5 = r7.B     // Catch: java.lang.ClassCastException -> L77
            boolean r5 = r5.isEmpty()     // Catch: java.lang.ClassCastException -> L77
            if (r5 == 0) goto L77
            java.util.ArrayList r5 = r8.B     // Catch: java.lang.ClassCastException -> L77
            boolean r5 = r5.isEmpty()     // Catch: java.lang.ClassCastException -> L77
            if (r5 != 0) goto L1f
            goto L77
        L1f:
            int r5 = r1.size()     // Catch: java.lang.ClassCastException -> L77
            java.util.ArrayList r6 = r8.f2()     // Catch: java.lang.ClassCastException -> L77
            int r6 = r6.size()     // Catch: java.lang.ClassCastException -> L77
            if (r5 != r6) goto L77
            java.util.ArrayList r5 = r8.f2()     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r1.containsAll(r5)     // Catch: java.lang.ClassCastException -> L77
            if (r1 != 0) goto L38
            goto L77
        L38:
            android.accounts.Account r1 = r7.v     // Catch: java.lang.ClassCastException -> L77
            if (r1 != 0) goto L3f
            if (r4 != 0) goto L77
            goto L45
        L3f:
            boolean r1 = r1.equals(r4)     // Catch: java.lang.ClassCastException -> L77
            if (r1 == 0) goto L77
        L45:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.ClassCastException -> L77
            if (r1 == 0) goto L52
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassCastException -> L77
            if (r0 == 0) goto L77
            goto L59
        L52:
            boolean r0 = r0.equals(r3)     // Catch: java.lang.ClassCastException -> L77
            if (r0 != 0) goto L59
            goto L77
        L59:
            boolean r0 = r7.y     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.y     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            boolean r0 = r7.w     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.w     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            boolean r0 = r7.x     // Catch: java.lang.ClassCastException -> L77
            boolean r1 = r8.x     // Catch: java.lang.ClassCastException -> L77
            if (r0 != r1) goto L77
            java.lang.String r0 = r7.C     // Catch: java.lang.ClassCastException -> L77
            java.lang.String r8 = r8.C     // Catch: java.lang.ClassCastException -> L77
            boolean r8 = android.text.TextUtils.equals(r0, r8)     // Catch: java.lang.ClassCastException -> L77
            if (r8 == 0) goto L77
            r8 = 1
            return r8
        L77:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public final ArrayList f2() {
        return new ArrayList(this.u);
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.u;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).getScopeUri());
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.v;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.z;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.y ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0);
        String str2 = this.C;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeTypedList(parcel, 2, f2(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.v, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.w);
        SafeParcelWriter.writeBoolean(parcel, 5, this.x);
        SafeParcelWriter.writeBoolean(parcel, 6, this.y);
        SafeParcelWriter.writeString(parcel, 7, this.z, false);
        SafeParcelWriter.writeString(parcel, 8, this.A, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.B, false);
        SafeParcelWriter.writeString(parcel, 10, this.C, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
