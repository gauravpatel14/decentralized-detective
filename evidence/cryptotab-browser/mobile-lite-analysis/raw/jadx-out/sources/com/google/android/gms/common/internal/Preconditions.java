package com.google.android.gms.common.internal;

import android.content.ContentValues;
import android.os.Handler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
    }

    public static int checkElementIndex(int i, int i2) {
        return i;
    }

    public static void checkHandlerThread(Handler handler) {
    }

    public static String checkNotEmpty(String str) {
        return str;
    }

    public static void checkNotMainThread() {
    }

    public static Object checkNotNull(Object obj) {
        return obj;
    }

    public static int checkNotZero(int i) {
        return i;
    }

    public static int checkPositionIndex(int i, int i2) {
        return i;
    }

    public static void checkState(boolean z) {
    }

    public static void checkArgument(boolean z, Object obj) {
    }

    public static int checkElementIndex(int i, int i2, String str) {
        return i;
    }

    public static void checkHandlerThread(Handler handler, String str) {
    }

    public static String checkNotEmpty(String str, Object obj) {
        return str;
    }

    public static void checkNotMainThread(String str) {
    }

    public static Object checkNotNull(Object obj, Object obj2) {
        return obj;
    }

    public static int checkNotZero(int i, Object obj) {
        return i;
    }

    public static int checkPositionIndex(int i, int i2, String str) {
        return i;
    }

    public static void checkState(boolean z, Object obj) {
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
    }

    public static long checkNotZero(long j) {
        return j;
    }

    public static void checkState(boolean z, String str, Object... objArr) {
    }

    public static long checkNotZero(long j, Object obj) {
        return j;
    }

    public static void checkNotGoogleApiHandlerThread() {
    }

    public static void checkMainThread(String str) {
    }

    public static String checkTag(String str) {
        return str;
    }

    public static void checkNotNullIfPresent(String str, ContentValues contentValues) {
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
    }
}
