package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.AbstractC1278pV2;
import defpackage.CallableC0415bU2;
import defpackage.CallableC1376rI2;
import defpackage.FQ2;
import defpackage.NK2;
import defpackage.VM2;
import defpackage.Zr0;
import defpackage.mN2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class FlagProviderImpl extends NK2 {
    public boolean t;
    public SharedPreferences u;

    public FlagProviderImpl() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        this.t = false;
    }

    @Override // defpackage.qI2
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        if (!this.t) {
            return z;
        }
        SharedPreferences sharedPreferences = this.u;
        Boolean boolValueOf = Boolean.valueOf(z);
        try {
            boolValueOf = (Boolean) VM2.a(new CallableC1376rI2(sharedPreferences, str, boolValueOf));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return boolValueOf.booleanValue();
    }

    @Override // defpackage.qI2
    public int getIntFlagValue(String str, int i, int i2) {
        if (!this.t) {
            return i;
        }
        SharedPreferences sharedPreferences = this.u;
        Integer numValueOf = Integer.valueOf(i);
        try {
            numValueOf = (Integer) VM2.a(new mN2(sharedPreferences, str, numValueOf));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return numValueOf.intValue();
    }

    @Override // defpackage.qI2
    public long getLongFlagValue(String str, long j, int i) {
        if (!this.t) {
            return j;
        }
        SharedPreferences sharedPreferences = this.u;
        Long lValueOf = Long.valueOf(j);
        try {
            lValueOf = (Long) VM2.a(new FQ2(sharedPreferences, str, lValueOf));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return lValueOf.longValue();
    }

    @Override // defpackage.qI2
    public String getStringFlagValue(String str, String str2, int i) {
        if (!this.t) {
            return str2;
        }
        try {
            return (String) VM2.a(new CallableC0415bU2(this.u, str, str2));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }

    @Override // defpackage.qI2
    public void init(Zr0 zr0) {
        Context context = (Context) ObjectWrapper.X0(zr0);
        if (this.t) {
            return;
        }
        try {
            this.u = AbstractC1278pV2.a(context.createPackageContext("com.google.android.gms", 0));
            this.t = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagProviderImpl", strValueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(strValueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
